package upm.Data.Repositories.RepositoriesMap;

import upm.Data.Models.Plan;
import upm.Data.Repositories.PlanRepositoryInterface;

public class PlanRepository extends GenericRepository<Plan> implements PlanRepositoryInterface {

    @Override
    protected void setId(Plan plan, Integer id) {
        plan.setId(id);
    }

    @Override
    protected Integer getId(Plan plan) {
        return plan.getId();
    }


}
