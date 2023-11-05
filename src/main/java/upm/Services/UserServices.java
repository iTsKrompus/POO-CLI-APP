package upm.Services;

import upm.Data.Models.User;
import upm.Data.Repositories.UserRepositoryInterface;

public class UserServices {

    //Crear el login comprobando que el nombre y la contraseña coincidan. En cuanto al logout, de momento no (lo haremos con el cli)
    //Si los repositorios
    private final UserRepositoryInterface userRepositoryInterface;

    public UserServices(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }

    public User create(User user) {
        if (userRepositoryInterface.isNameUnic(user.getNombreUsuario()).isPresent()) {
            throw new IllegalArgumentException("El nombre ya existe cuando deberia ser unico: " + user.getNombreUsuario());
        } else if (userRepositoryInterface.isMobileUnic(user.getTelefono()).isPresent()) {
            throw new IllegalArgumentException("El telefono ya existe cuando deberia de ser unico: " + user.getTelefono());
        }
        return userRepositoryInterface.create(user);
    }
}
