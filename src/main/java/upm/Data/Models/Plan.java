package upm.Data.Models;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private final String nombre;
    private final String fecha;
    private final String hora;
    private final String lugarEncuentro;
    private int aforo;
    private int id;
    private final List<Actividad> actividades;
    private final List<User> userList;

    public Plan(String nombre, String fecha, String hora, String lugarEncuentro, int aforo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.lugarEncuentro = lugarEncuentro;
        if (aforo == 0) {
            this.aforo = Integer.MAX_VALUE;
        } else {
            this.aforo = aforo;
        }
        this.actividades = new ArrayList<>();
        this.userList = new ArrayList<>();
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

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int newAforo) {
        aforo = newAforo;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", lugarEncuentro='" + lugarEncuentro + '\'' +
                ", aforo=" + aforo +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addActividad(Actividad actividad) {
        if (actividad.getAforo() <= this.getAforo()) {
            actividades.add(actividad);
            if (actividad.getAforo() < this.getAforo()) {
                this.setAforo(actividad.getAforo());
            }
        } else {
            throw new IllegalArgumentException("El aforo de la actividad no puede ser mayor al del plan\n");
        }
    }

    public void deleteActividad(Actividad actividad) {
        if (this.actividades.contains(actividad)) {
            actividades.remove(actividad);
        } else {
            throw new IllegalArgumentException("La actividad no se encuentra en el plan\n");
        }
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public List<User> getUserList() {
        return userList;
    }
}
