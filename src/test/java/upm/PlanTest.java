package upm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlanTest {
    private Plan plan;

    @BeforeEach
    void before() {
        plan = new Plan("Quedada", "10 de noviembre", "10:30", "Calle lazarillo de Tormes", 0, new ArrayList<Actividad>(), new ArrayList<User>());
    }

    @Test
    public void getAforo() {
        assertEquals(Integer.MAX_VALUE, plan.getCapacidadMax());
    }

}