package upm.Data.Models.ActividadesTipos;

import upm.Data.Models.Actividad;

import java.time.Duration;

public class Cine extends Actividad {

    public static final double DTO_JOVEN = 0.5;
    private static final int EDAD_JOVEN = 21;

    public Cine(String tipo, String nombre, String descripcion, Duration duracion, double coste, int aforo) {
        super(tipo, nombre, descripcion, duracion, coste, aforo);
    }

    public double aplicarDto(int edad){
      double dto = 1.0;
        if(edad<=EDAD_JOVEN){
            dto = DTO_JOVEN;
        }
        return getCoste()*dto;
    }
}
