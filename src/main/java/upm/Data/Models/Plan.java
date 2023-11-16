package upm.Data.Models;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private final String nombre;
    private final String fechaInicio;
    private final String horaInicio;
    private final String lugarEncuentro;
    private int aforo;
    private Integer id;
    private final List<Actividad> actividadesList;
    private final List<User> userList;
    private static final int desplazamiento = 20;

    public Plan(String nombre, String fecha, String hora, String lugarEncuentro, int aforo) {
        this.nombre = nombre;
        this.fechaInicio = fecha;
        this.horaInicio = hora;
        this.lugarEncuentro = lugarEncuentro;
        if (aforo == 0) {
            this.aforo = Integer.MAX_VALUE;
        } else {
            this.aforo = aforo;
        }
        this.actividadesList = new ArrayList<>();
        this.userList = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fechaInicio;
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
                ", fecha='" + fechaInicio + '\'' +
                ", hora='" + horaInicio + '\'' +
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
            actividadesList.add(actividad);
            if (actividad.getAforo() < this.getAforo()) {
                this.setAforo(actividad.getAforo());
            }
        } else {
            throw new IllegalArgumentException("El aforo de la actividad no puede ser mayor al del plan\n");
        }
    }

    public void deleteActividad(Actividad actividad) {
        if (this.actividadesList.contains(actividad)) {
            actividadesList.remove(actividad);
        } else {
            throw new IllegalArgumentException("La actividad no se encuentra en el plan\n");
        }
    }

    public List<Actividad> getActividades() {
        return actividadesList;
    }

    public List<User> getUserList() {
        return userList;
    }
    public int totalTime() {
        int totalTime = 0;
        for (Actividad act : getActividades()) {
            totalTime += act.getDuracion() + desplazamiento;
        }
        return totalTime;
    }

    public double totalCost() {
        double totalCost = 0.0;
        for (Actividad act : getActividades()) {
            totalCost += act.getCoste();
        }
        return totalCost;
    }
}
