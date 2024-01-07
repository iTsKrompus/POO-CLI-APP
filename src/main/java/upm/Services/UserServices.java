package upm.Services;

import upm.Data.Models.User;
import upm.Data.Repositories.PlanRepositoryInterface;
import upm.Data.Repositories.UserRepositoryInterface;

import java.util.HashMap;
import java.util.Optional;

public class UserServices {


    private final UserRepositoryInterface userRepositoryInterface;

    public UserServices(UserRepositoryInterface userRepositoryInterface, PlanRepositoryInterface planRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }

    public User create(User user) {
        if (userRepositoryInterface.findByName(user.getNombreUsuario()).isPresent()) {
            throw new IllegalArgumentException("El nombre ya existe cuando deberia ser unico: " + user.getNombreUsuario());
        } else if (userRepositoryInterface.findByMobile(user.getTelefono()).isPresent()) {
            throw new IllegalArgumentException("El telefono ya existe cuando deberia de ser unico: " + user.getTelefono());
        }
        return userRepositoryInterface.create(user);
    }

    public User login(String name, String password) {
        Optional<User> userOptional = userRepositoryInterface.findByName(name);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Parametros de inicio de sesion incorrectos");
    }
public HashMap<Integer, Float> ratePlan (HashMap<Integer, Float> puntuaciones, Integer id, float rate){
    if (rate < 0.0 || rate > 10.0){
        throw new IllegalArgumentException("La puntucion debe estar comprendida entre el 0 y 10");
    }

    puntuaciones.put(id,rate);
    return puntuaciones;
}

}

