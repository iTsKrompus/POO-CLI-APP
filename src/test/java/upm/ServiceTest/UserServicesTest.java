package upm.ServiceTest;

import org.junit.jupiter.api.Test;
import upm.Data.Models.User;
import upm.Data.Repositories.UserRepositoryInterface;
import upm.DependencyInjector;
import upm.Services.UserServices;
import static org.junit.jupiter.api.Assertions.*;


public class UserServicesTest {

    private UserServices userServices = DependencyInjector.getDependencyInjector().getUserServices();
    private UserRepositoryInterface userRepositoryInterface = DependencyInjector.getDependencyInjector().getUserRepositoryInterface();

    @Test
    public void testCreateCorrect (){
        User user = new User("Paco", 79, 65656565, "432");
        assertEquals(user, userServices.create(user));
    }
    @Test
    public void testCreateSameName (){
        User user = new User("hugo", 44, 353535, "573");
        assertThrows(IllegalArgumentException.class, () -> {userServices.create(user);
        throw new IllegalArgumentException("El nombre ya existe cuando deberia ser unico: " + user.getNombreUsuario());
        });
    }
    @Test
    public void testCreateSamePhone(){
        User user = new User("Aznar", 54, 637945824, "111");
        assertThrows(IllegalArgumentException.class, () -> {userServices.create(user);
            throw new IllegalArgumentException("El telefono ya existe cuando deberia de ser unico: " + user.getTelefono());
        });
    }
    @Test
    public void testLoginCorrect(){

        assertEquals(userRepositoryInterface.findByName("hugo").get(), userServices.login("hugo", "123"));
    }

    @Test
    public void testLoginFailPassword(){
        assertThrows(IllegalArgumentException.class, () -> {userServices.login("hugo", "111");
            throw new IllegalArgumentException("Parametros de inicio de sesion incorrectos");
        });
    }
    @Test
    public void testLoginFailName(){
        assertThrows(IllegalArgumentException.class, () -> {userServices.login("juan", "123");
            throw new IllegalArgumentException("Parametros de inicio de sesion incorrectos");
        });
    }
}
