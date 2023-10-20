package upm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testGetCapacidadMax() {
        assertEquals(2147483647, plan.getCapacidadMax());
    }

    @Test
    public void testSetCapacidadMax() {
        plan.setCapacidadMax(15);
        assertEquals(15, plan.getCapacidadMax());
    }
}

