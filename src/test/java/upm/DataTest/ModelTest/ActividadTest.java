package upm.DataTest.ModelTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.Actividad;
import upm.Data.Models.ActividadesTipos.ActividadCine;
import upm.Data.Models.ActividadesTipos.ActividadTeatro;
import upm.Data.Models.User;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActividadTest {
    private Actividad act;
    private User user;
    private User user2;
    private Actividad act2;

    @BeforeEach
    void before() {
        act = new ActividadTeatro("teatro", "salida", "Actividad para no tan jovenes", Duration.ofMinutes(140), 25.99, 10);
        act2 = new ActividadCine("cine", "salida", "Actividad para no tan jovenes", Duration.ofMinutes(140), 25.99, 10);

        user = new User("Hugo", 18, 629033652, "123");
        user2 = new User("Paco", 27, 629096621, "273");


    }

    @Test
    public void aplicarDtoTest() {
        assertEquals(12.995, (act.aplicarDto(user.getEdad())));
    }

    @Test
    public void noAplicarDtoTest() {
        assertEquals(12.995, act.aplicarDto(user2.getEdad()));

    }

    @Test
    public void igualAplicarDtoTest() {
        assertEquals(25.99, act.aplicarDto(user2.getEdad()));
    }

    @Test
    public void cineAplicarDtoTest() {
        assertEquals(12.995, act.aplicarDto(user.getEdad()));
    }

    @Test
    public void cineNoAplicarDtoTest() {
        assertEquals(25.99, act.aplicarDto(user2.getEdad()));
    }
}

