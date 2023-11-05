package upm.Data.Repositories.Repositories_Map;

import upm.Data.Models.User;
import upm.Data.Repositories.UserRepositoryInterface;

import java.util.Optional;

public class UserRepository extends GenericRepository<User> implements UserRepositoryInterface {

    @Override
    protected void setId(User user, Integer telefono) {
        user.setTelefono(telefono);
    }

    @Override
    protected int getId(User user) {
        return user.getTelefono();
    }


@Override
public Optional<User> isMobileUnic (Integer mobile) {
    for (User user : findAll()) {
        if (user.getTelefono() == mobile){
            return (Optional.of(user));
        }
    }
    return Optional.empty();
}

@Override
public Optional<User> isNameUnic(String nombre) {
    for (User user : findAll()) {
        if (user.getNombreUsuario().equals(nombre)) {
            return Optional.of(user);
        }
    }
   return Optional.empty();
    }

}