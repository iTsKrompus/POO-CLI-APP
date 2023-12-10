package upm.Data.Repositories;

import upm.Data.Models.Plan;

import java.util.Optional;


public interface PlanRepositoryInterface extends GenericRepositoryInterface<Plan> {
    Optional<Plan> findById (int id);
}
