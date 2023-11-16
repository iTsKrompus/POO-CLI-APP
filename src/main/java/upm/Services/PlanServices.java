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
        if (user.getLoginStatus().equals("connected")) {
            return planRepositoryInterface.create(plan);
        }
        throw new IllegalArgumentException("No puede crear un plan sin loggearse primero\n");
    }

    public void listarPlanes() {

        for (Plan plan : planRepositoryInterface.findAll()) {
            System.out.println(plan.toString());
        }
    }

    public void listarPlanesSubscritos() {
        for (Plan plan : planRepositoryInterface.findAll()) {
            for (User user : plan.getUserList()) {
                if (user.getNombreUsuario()) {
                    System.out.println(plan.toString());
                }
            }
        }

    }
}
