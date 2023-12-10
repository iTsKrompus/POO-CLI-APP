package upm.Services;

import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.Data.Repositories.PlanRepositoryInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;


public class PlanServices {
    private final PlanRepositoryInterface planRepositoryInterface;

    public PlanServices(PlanRepositoryInterface planRepositoryInterface) {
        this.planRepositoryInterface = planRepositoryInterface;
    }

    public Plan create(Plan plan) {
        return planRepositoryInterface.create(plan);
    }

    public void listarPlanes() {

        for (Plan plan : planRepositoryInterface.findAll()) {
            if (plan.getFecha().isAfter(LocalDate.now()) || (plan.getFecha().isEqual(LocalDate.now()) && plan.getHoraInicio().isAfter(LocalTime.now()))) {
                System.out.println(plan);
            }
        }
    }

    public void listarPlanesSubscritos(String actualUser) {
        for (Plan plan : planRepositoryInterface.findAll()) {
            for (User user : plan.getUserList()) {
                if (user.getNombreUsuario().equals(actualUser)) {
                    System.out.println(plan);
                }
            }
        }


    }

    public void joinPlanById(User user, int id) {
        Optional<Plan> plan = planRepositoryInterface.read(id);
        checkIfPlanExist(plan,id);

        if (plan.get().getUserList().contains(user)) {
            throw new IllegalArgumentException("El usuario ya esta apuntado al plan con el id=" + id);
        }

        if (plan.get().getAforo() <= 0) {
            throw new IllegalArgumentException("No es posible unirse al plan dado que el aforo esta completo");
        }

        plan.get().getUserList().add(user);
        plan.get().setAforo(plan.get().getAforo() - 1);
    }

    public void leftPlanById (User user, int id) {
        Optional<Plan> plan = planRepositoryInterface.read(id);
        checkIfPlanExist(plan, id);

        if (!(plan.get().getUserList().contains(user))){
            throw new IllegalArgumentException("El usuario no esta apuntado al plan con id=" + id);
        }

        plan.get().getUserList().remove(user);
        plan.get().setAforo(plan.get().getAforo() + 1);
        }


        private void checkIfPlanExist (Optional<Plan> plan, int id){
            if (plan.isEmpty()) {
                throw new IllegalArgumentException("El id especificado no corresponde a ningun plan");
            }
        }
    }

