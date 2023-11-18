package upm.DataTest.ModelTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.Actividad;
import upm.Data.Models.Plan;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanTest {
    private Plan plan;
    private Plan plan2;
    private Actividad act1;
    private Actividad act2;
    private Actividad act3;

    @BeforeEach
    void before() {
        plan = new Plan("Quedada", LocalDate.of(2023,11,15), LocalTime.of(10,30), "Calle lazarillo de Tormes", 0);
        plan2 = new Plan("Quedada", LocalDate.of(2023,11,15), LocalTime.of(10,30), "Calle lazarillo de Tormes", 15);
        act1 = new Actividad("teatro", "salida", "Actividad para no tan jovenes", Duration.ofMinutes(140), 25.99, 10);
        act2 = new Actividad("cine", "salida", "Actividad para no tan jovenes", Duration.ofMinutes(140), 25.99, 15);
        act3 = new Actividad("cine", "salida", "Actividad para no tan jovenes", Duration.ofMinutes(140), 25.99, 20);
        plan2.getActividades().add(act2);
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

    @Test
    public void testAddActividad() {
        plan.addActividad(act1);
        assertEquals(10, plan.getAforo());
    }

    @Test
    public void testAddActividadExtra() {
        plan2.addActividad(act3);
        assertEquals(20, plan2.getAforo());
    }

}

