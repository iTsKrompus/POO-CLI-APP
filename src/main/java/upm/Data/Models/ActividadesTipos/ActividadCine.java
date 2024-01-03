package upm.Data.Models.ActividadesTipos;

import upm.Data.Models.Actividad;

import java.time.Duration;

public class ActividadCine extends Actividad {

    private static final int EDAD_JOVEN = 21;

    public ActividadCine(String tipo, String nombre, String descripcion, Duration duracion, double coste, int aforo) {
        super("cine", nombre, descripcion, duracion, coste, aforo);
    }
    @Override
    public double aplicarDto(int edad) {
        double dto = 1.0;
        if (edad <= EDAD_JOVEN) {
            dto = DTO_JOVEN;
        }
        return getCoste() * dto;
    }
}
