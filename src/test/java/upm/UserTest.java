package upm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserTest {
    private User user;

    @BeforeEach
    void before() {
        user = new User("Hugo", 57, 629054242, "123");

    }


    @Test
    public void testGetNombreUsuario() {

        assertEquals("Hugo", user.getNombreUsuario());
    }

    @Test
    public void testNombreUsuarioUnico() {

        // Verificar que el nombre de usuario es único
        assertTrue(user.isNomUserUnico("otroUsuario"));
    }


    @Test
    public void testTelefonoUnico() {
        User user1 = new User("usuario3", 40, 555555555, "contrasena");

        // Verificar que el número de teléfono es único
        assertTrue(user1.isTelefonoUnico(555555556));
    }


}

