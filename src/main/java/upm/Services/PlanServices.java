package upm.Services;

import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.Data.Repositories.ActividadRepositoryInterface;
import upm.Data.Repositories.PlanRepositoryInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;


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
        checkIfPlanExist(plan);
        checkPlanOwner(plan.get(), activeUser);
        planRepositoryInterface.delete(plan.get().getId());
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
        checkIfPlanExist(plan);

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
        checkIfPlanExist(plan);
        findUserIsntSubscribed(plan.get(), user);


        plan.get().getUserList().remove(user);
        plan.get().setAforo(plan.get().getAforo() + 1);
        }
        private void findUserIsntSubscribed (Plan plan, User user){
            if (!(plan.getUserList().contains(user))){
                throw new IllegalArgumentException("El usuario no esta apuntado al plan");
            }
        }


        private void checkIfPlanExist (Optional<Plan> plan){
            if (plan.isEmpty()) {
                throw new IllegalArgumentException("El id especificado no corresponde a ningun plan");
            }
        }

        public void addActivityToPlan (Integer [] ids, User activeUser) {
            Optional<Plan> plan = planRepositoryInterface.read(ids[1]);
            checkIfPlanExist(plan);
            checkPlanOwner(plan.get(), activeUser);
            if (actividadRepositoryInterface.read(ids[0]).isEmpty()) {
                throw new IllegalArgumentException("La actividad con el id:" + ids[0] + " no se ha encontrado");
            }
            plan.get().addActividad(actividadRepositoryInterface.read(ids[0]).get());
            planRepositoryInterface.update(plan.get());
        }
        private void checkPlanOwner (Plan plan, User activeUser){
               if (!(plan.getOwnerName().equals(activeUser.getNombreUsuario()))){
                   throw new IllegalArgumentException("Solo el propietario puede modificar/eliminar el plan");
               }
           }
           public double checkPlanTotalCost (Integer id, User activeUser){
              Optional<Plan> plan = planRepositoryInterface.read(id);
              checkIfPlanExist(plan);
              findUserIsntSubscribed(plan.get(), activeUser);

              return plan.get().totalCost(activeUser.getEdad());
           }

        }

