package upm.Data.Repositories;

import upm.Data.Models.User;

import java.util.Optional;

public interface UserRepositoryInterface extends GenericRepositoryInterface<User> {
    Optional<User> findByName(String nombre);

    Optional<User> findByMobile(int telefono);
}
