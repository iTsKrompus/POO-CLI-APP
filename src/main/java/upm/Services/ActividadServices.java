package upm.Services;

import upm.Data.Models.Actividad;
import upm.Data.Models.User;
import upm.Data.Repositories.ActividadRepositoryInterface;


public class ActividadServices {
    private final ActividadRepositoryInterface actividadRepositoryInterface;

    public ActividadServices(ActividadRepositoryInterface actividadRepositoryInterface){
        this.actividadRepositoryInterface = actividadRepositoryInterface;
    }
    public Actividad create (Actividad actividad, User user){
        if(user.getLoginStatus().equals("connected")){
            return actividadRepositoryInterface.create(actividad);
        }
        throw new IllegalArgumentException("No puede crear una actividad sin loggearse primero\n");
    }
}
