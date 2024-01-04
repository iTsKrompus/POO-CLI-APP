package upm.Services;

import upm.Data.Models.Actividad;
import upm.Data.Repositories.ActividadRepositoryInterface;

import java.util.ArrayList;
import java.util.List;


public class ActividadServices {
    private final ActividadRepositoryInterface actividadRepositoryInterface;

    public ActividadServices(ActividadRepositoryInterface actividadRepositoryInterface) {
        this.actividadRepositoryInterface = actividadRepositoryInterface;
    }

    public Actividad create(Actividad actividad) {
        return actividadRepositoryInterface.create(actividad);

    }

    public List<Actividad> listarDuracionDosHoras() {
        List<Actividad> actividades = new ArrayList<Actividad>();
        for (Actividad actividad : actividadRepositoryInterface.findAll()) {
            if (actividad.getDuracion().toMinutes() >= 120) {
                actividades.add(actividad);
            }
        }
        return actividades;
    }

    public List<Actividad> listarMaxCosteDiez() {
        List<Actividad> actividades = new ArrayList<Actividad>();
        for (Actividad actividad : actividadRepositoryInterface.findAll()) {
            if (actividad.getCoste() <= 10) {
                actividades.add(actividad);
            }
        }
        return actividades;
    }

    public List<Actividad> listarTipo(String tipo) {
        List<Actividad> actividades = new ArrayList<Actividad>();
        for (Actividad actividad : actividadRepositoryInterface.findAll()) {
            if (actividad.getTipo().equals(tipo)) {
                actividades.add(actividad);
            }
        }
        return actividades;
    }
}
