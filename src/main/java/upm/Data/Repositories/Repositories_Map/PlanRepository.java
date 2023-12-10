package upm.Data.Repositories.Repositories_Map;

import upm.Data.Models.Plan;
import upm.Data.Repositories.PlanRepositoryInterface;

import java.util.Optional;

public class PlanRepository extends GenericRepository<Plan> implements PlanRepositoryInterface {

    @Override
    protected void setId(Plan plan, Integer id) {
        plan.setId(id);
    }

    @Override
    protected Integer getId(Plan plan) {
        return plan.getId();
    }

    @Override
    public Optional<Plan> findById (int id){
        for (Plan plan : findAll()){
            if (plan.getId() == id){
                return Optional.of(plan);
            }
        }
        return Optional.empty();
    }
}
