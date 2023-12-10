package upm.ServiceTest;

import org.junit.jupiter.api.Test;
import upm.Data.Models.Actividad;
import upm.DependencyInjector;
import upm.Services.ActividadServices;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class ActividadServicesTest {
    private final ActividadServices actividadServices= DependencyInjector.getDependencyInjector().getActividadServices();


    @Test
    public void testActividadesDosHoras (){
        List<Actividad> actividades = actividadServices.listarDuracionDosHoras();
        assertEquals(2, actividades.size());

    }

    @Test
    public void testActividadesMaxCosteDiez (){
        List<Actividad> actividades = actividadServices.listarMaxCosteDiez();
        assertEquals(1, actividades.size());
    }

    @Test
    public void testActividadesTipoTeatro (){
        List<Actividad> actividades = actividadServices.listarTipo("teatro");
        assertEquals(1, actividades.size());
    }
    @Test
    public void testActividadesTipoCine (){
        List<Actividad> actividades = actividadServices.listarTipo("cine");
        assertEquals(1, actividades.size());
    }

    @Test
    public void testActividadesTipoGenerico (){
        List<Actividad> actividades = actividadServices.listarTipo("generica");
        assertEquals(1, actividades.size());
    }
}
