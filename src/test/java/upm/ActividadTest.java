package upm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActividadTest {
    private Actividad act;
    private User user;
    private User user2;
    private Actividad act2;

    @BeforeEach
    void before() {
        act = new Actividad("teatro", "salida", "Actividad para no tan jovenes", 140, 25.99, 10);
        act2 = new Actividad("cine", "salida", "Actividad para no tan jovenes", 140, 25.99, 10);

        user = new User("Hugo", 18, 6290336521L, "123");
        user2 = new User("Paco", 27, 6290966521L, "273");


    }

    @Test
    public void aplicarDtoTest() {
        assertEquals(12.995, (act.aplicarDto(user)));
    }

    @Test
    public void noAplicarDtoTest() {
        assertEquals(12.995, act.aplicarDto(user2));

    }

    @Test
    public void igualAplicarDtoTest() {
        assertEquals(25.99, act.aplicarDto(user2));
    }

    @Test
    public void cineAplicarDtoTest() {
        assertEquals(12.995, act.aplicarDto(user));
    }

    @Test
    public void cineNoAplicarDtoTest() {
        assertEquals(25.99, act.aplicarDto(user2));
    }
}

