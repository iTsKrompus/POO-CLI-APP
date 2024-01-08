package upm.Data.Models.ActividadesTipos;

import upm.Data.Models.Actividad;

import java.time.Duration;

public class ActividadTeatro extends Actividad {
    private static final double DTO_ANCIANO = 0.3;
    private static final int EDAD_JOVEN = 25;
    private static final int EDAD_ANCIANO = 65;

    public ActividadTeatro(String tipo, String nombre, String descripcion, Duration duracion, double coste, int aforo) {
        super("teatro", nombre, descripcion, duracion, coste, aforo);
    }


    @Override
    public double aplicarDto(int edad) {
        double dto = 1.0;
        if (edad <= EDAD_JOVEN) {
            dto = DTO_JOVEN;
        } else if (edad >= EDAD_ANCIANO) {
            dto = DTO_ANCIANO;
        }

        return getCoste() * dto;
    }
}
