package upm.Services;

import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.Data.Repositories.PlanRepositoryInterface;


public class PlanServices {
    private final PlanRepositoryInterface planRepositoryInterface;

    public PlanServices(PlanRepositoryInterface planRepositoryInterface) {
        this.planRepositoryInterface = planRepositoryInterface;
    }

    public Plan create(Plan plan, User user) {
            return planRepositoryInterface.create(plan);
        }

    public void listarPlanes() {

        for (Plan plan : planRepositoryInterface.findAll()) {
            System.out.println(plan.toString());
        }
    }

    public void listarPlanesSubscritos(String actualUser) {  //Por hacer
        for (Plan plan : planRepositoryInterface.findAll()) {
            for (User user : plan.getUserList()) {
                if (user.getNombreUsuario().equals(actualUser)) {
                    System.out.println(plan.toString());
                }
            }
        }

    }


}
