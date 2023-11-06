package upm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.Actividad;
import upm.Data.Models.Plan;
import upm.Data.Models.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanTest {
    private Plan plan;

    @BeforeEach
    void before() {
        plan = new Plan("Quedada", "15-11-2023", "10:30", "Calle lazarillo de Tormes", 0, new ArrayList<Actividad>(), new ArrayList<User>());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Quedada", plan.getNombre());
    }

    @Test
    public void testGetFecha() {
        assertEquals("15-11-2023", plan.getFecha());
    }

    @Test
    public void testGetLugarEncuentro() {
        assertEquals("Calle lazarillo de Tormes", plan.getLugarEncuentro());
    }

    @Test
    public void testAforo() {
        assertEquals(2147483647, plan.getAforo());
    }

    @Test
    public void setAforo() {
        plan.setAforo(15);
        assertEquals(15, plan.getAforo());
    }
}

