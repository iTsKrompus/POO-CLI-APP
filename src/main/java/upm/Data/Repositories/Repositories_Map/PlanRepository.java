package upm.Data.Repositories.Repositories_Map;

import upm.Data.Models.Plan;

public class PlanRepository extends GenericRepository<Plan> {

    @Override
    protected void setId(Plan plan, Integer id) {
        plan.setId(id);
    }

    @Override
    protected int getId(Plan plan) {
        return plan.getId();
    }
}
