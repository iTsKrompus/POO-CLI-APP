package upm.Services;

import upm.Data.Models.User;
import upm.Data.Models.Plan;
import upm.Data.Repositories.PlanRepositoryInterface;
import upm.Data.Repositories.UserRepositoryInterface;

import java.util.Optional;

public class UserServices {


    private final UserRepositoryInterface userRepositoryInterface;
    private final PlanRepositoryInterface planRepositoryInterface;

    public UserServices(UserRepositoryInterface userRepositoryInterface, PlanRepositoryInterface planRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
        this.planRepositoryInterface = planRepositoryInterface;
    }

    public User create(User user) {
        if (userRepositoryInterface.isNameUnic(user.getNombreUsuario()).isPresent()) {
            throw new IllegalArgumentException("El nombre ya existe cuando deberia ser unico: " + user.getNombreUsuario());
        } else if (userRepositoryInterface.isMobileUnic(user.getTelefono()).isPresent()) {
            throw new IllegalArgumentException("El telefono ya existe cuando deberia de ser unico: " + user.getTelefono());
        }
        return userRepositoryInterface.create(user);
    }
    public User login (String name, String password){
        Optional<User> userOptional = userRepositoryInterface.isNameUnic(name);
            if (userOptional.isPresent()){
               User user = userOptional.get();
               if(user.getPassword().equals(password)) {
                   user.setStatus("connected");
                   return user;
               }
            }
        throw new IllegalArgumentException("Parametros de inicio de sesion incorrectos\n");
        }

    }

