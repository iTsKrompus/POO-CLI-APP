package upm.Data.Repositories;

import upm.Data.Models.User;

import java.util.Optional;

public interface UserRepositoryInterface extends GenericRepositoryInterface<User> {
    Optional<User> isNameUnic(String nombre);

    Optional<User> isMobileUnic(int telefono);
}
