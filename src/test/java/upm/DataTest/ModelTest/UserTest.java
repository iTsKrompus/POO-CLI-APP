package upm.DataTest.ModelTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.User;

import static org.junit.jupiter.api.Assertions.assertEquals;


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


}

