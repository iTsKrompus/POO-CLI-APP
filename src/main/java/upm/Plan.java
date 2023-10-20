package upm;

import java.util.ArrayList;

public class Plan {
    private final String nombre;
    private final String fecha;
    private final String hora;
    private final String lugarEncuentro;
    private int capacidadMax;
    private int id;

    public Plan(String nombre, String fecha, String hora, String lugarEncuentro, int capacidadMax, ArrayList<Actividad> actividadList, ArrayList<User> userList) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.lugarEncuentro = lugarEncuentro;
        if (capacidadMax == 0) {
            this.capacidadMax = Integer.MAX_VALUE;
        } else {
            this.capacidadMax = capacidadMax;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugarEncuentro() {
        return lugarEncuentro;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int newCapacidad) {
        capacidadMax = newCapacidad;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", lugarEncuentro='" + lugarEncuentro + '\'' +
                ", capacidadMax=" + capacidadMax +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
