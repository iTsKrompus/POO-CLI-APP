package upm.Services;

import upm.Data.Models.Actividad;
import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.Data.Repositories.PlanRepositoryInterface;

import java.util.Iterator;
import java.util.List;


public class PlanServices {
    private final PlanRepositoryInterface planRepositoryInterface;

    public PlanServices(PlanRepositoryInterface planRepositoryInterface){
        this.planRepositoryInterface = planRepositoryInterface;
    }
    public Plan create (Plan plan, User user){
        if(user.getLoginStatus().equals("connected")){
            return planRepositoryInterface.create(plan);
        }
        throw new IllegalArgumentException("No puede crear un plan sin loggearse primero\n");
    }
    public int totalTime (Plan plan){
        int totalTime = 0;
        List<Actividad> actividadesList = plan.getActividades();
        for(int i=0; i< actividadesList.size();i++){
           Actividad act = actividadesList.get(i);
            totalTime+=act.getDuracion() + 20;
        }
        return totalTime;
    }
    public double totalCost(Plan plan, User user){
        double totalCost = 0;
        List<Actividad> actividadesList = plan.getActividades();
        for(int i=0; i< actividadesList.size();i++){
            Actividad act = actividadesList.get(i);
            totalCost+=act.aplicarDto(user);
        }
        return totalCost;
    }

}
