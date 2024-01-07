package upm.Services;

import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.Data.Repositories.ActividadRepositoryInterface;
import upm.Data.Repositories.PlanRepositoryInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class PlanServices {
    private final PlanRepositoryInterface planRepositoryInterface;
    private final ActividadRepositoryInterface actividadRepositoryInterface;

    public PlanServices(PlanRepositoryInterface planRepositoryInterface, ActividadRepositoryInterface actividadRepositoryInterface) {
        this.planRepositoryInterface = planRepositoryInterface;
        this.actividadRepositoryInterface = actividadRepositoryInterface;
    }

    public Plan create(Plan plan) {
        return planRepositoryInterface.create(plan);
    }

    public void delete(Integer id, User activeUser) {
        Optional<Plan> plan = planRepositoryInterface.read(id);
        checkIfExist(plan);
        checkOwner(plan.get(), activeUser);
        planRepositoryInterface.delete(plan.get().getId());
    }

    public void listar() {

        for (Plan plan : planRepositoryInterface.findAll()) {
            if (plan.getFecha().isAfter(LocalDate.now()) || (plan.getFecha().isEqual(LocalDate.now()) && plan.getHoraInicio().isAfter(LocalTime.now()))) {
                System.out.println(plan);
            }
        }
    }

    public List<Plan> listarSubscritos(String actualUser) {
        List<Plan> planes = new ArrayList<>();
        for (Plan plan : planRepositoryInterface.findAll()) {
            for (User user : plan.getUserList()) {
                if (user.getNombreUsuario().equals(actualUser)) {
                    planes.add(plan);
                }
            }
        }
        return planes;

    }

    public void joinPlanById(User user, int id) {
        Optional<Plan> plan = planRepositoryInterface.read(id);
        checkIfExist(plan);

        if (plan.get().getUserList().contains(user)) {
            throw new IllegalArgumentException("El usuario ya esta apuntado al plan con el id=" + id);
        }

        if (plan.get().getAforo() <= 0) {
            throw new IllegalArgumentException("No es posible unirse al plan dado que el aforo esta completo");
        }
        if (plan.get().getFecha().isBefore(LocalDate.now()) || (plan.get().getFecha().isEqual(LocalDate.now()) && plan.get().getHoraInicio().isBefore(LocalTime.now()))) {
            throw new IllegalArgumentException(("No es posible unirse a un plan que ya ha ocurrido"));
        }

        plan.get().getUserList().add(user);
        plan.get().setAforo(plan.get().getAforo() - 1);
    }

    public void leftById(User user, int id) {
        Optional<Plan> plan = planRepositoryInterface.read(id);
        checkIfExist(plan);
        findUserIsntSubscribed(plan.get(), user);

        if (plan.get().getFecha().isBefore(LocalDate.now()) || (plan.get().getFecha().isEqual(LocalDate.now()) && plan.get().getHoraInicio().isBefore(LocalTime.now()))) {
            throw new IllegalArgumentException(("No es posible abandonar un plan que ya ha ocurrido"));
        }

        plan.get().getUserList().remove(user);
        plan.get().setAforo(plan.get().getAforo() + 1);
    }

    private void findUserIsntSubscribed(Plan plan, User user) {
        if (!(plan.getUserList().contains(user))) {
            throw new IllegalArgumentException("El usuario no esta apuntado al plan");
        }
    }


    private void checkIfExist(Optional<Plan> plan) {
        if (plan.isEmpty()) {
            throw new IllegalArgumentException("El id especificado no corresponde a ningun plan");
        }
    }

    public void addActivity(Integer[] ids, User activeUser) {
        Optional<Plan> plan = planRepositoryInterface.read(ids[1]);
        checkIfExist(plan);
        checkOwner(plan.get(), activeUser);
        if (actividadRepositoryInterface.read(ids[0]).isEmpty()) {
            throw new IllegalArgumentException("La actividad con el id:" + ids[0] + " no se ha encontrado");
        }
        plan.get().addActividad(actividadRepositoryInterface.read(ids[0]).get());
        planRepositoryInterface.update(plan.get());
    }

    private void checkOwner(Plan plan, User activeUser) {
        if (!(plan.getOwnerName().equals(activeUser.getNombreUsuario()))) {
            throw new IllegalArgumentException("Solo el propietario puede modificar/eliminar el plan");
        }
    }

    public double checkTotalCost(Integer id, User activeUser) {
        Optional<Plan> plan = planRepositoryInterface.read(id);
        checkIfExist(plan);
        findUserIsntSubscribed(plan.get(), activeUser);

        return plan.get().totalCost(activeUser.getEdad());
    }
 public void rate (Integer id){
        Optional<Plan> plan = planRepositoryInterface.read(id);
        checkIfExist(plan);
 }
}

