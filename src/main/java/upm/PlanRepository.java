package upm;

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
