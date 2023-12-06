package upm.Data.Models.ActividadesTipos;

import upm.Data.Models.Actividad;

import java.time.Duration;

public class ActividadGenerica extends Actividad {
    public ActividadGenerica(String tipo, String nombre, String descripcion, Duration duracion, double coste, int aforo) {
        super("generica", nombre, descripcion, duracion, coste, aforo);
    }

    @Override
    public double aplicarDto(int edad) {
        return getCoste();
    }
}
