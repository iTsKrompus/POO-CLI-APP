package upm.Data.Models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plan {
    private static final Duration DESPLAZAMIENTO = Duration.ofMinutes(20);
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalTime horaInicio;
    private final String lugarEncuentro;
    private final List<Actividad> actividadesList;
    private final List<User> userList;
    private Integer aforo;
    private Integer id;
    private String ownerName;

    public Plan(String nombre, LocalDate fecha, LocalTime hora, String lugarEncuentro, int aforo) {
        this.nombre = nombre;
        this.fechaInicio = fecha;
        this.horaInicio = hora;
        this.lugarEncuentro = lugarEncuentro;
        setAforo(aforo);
        this.actividadesList = new ArrayList<>();
        this.userList = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fechaInicio;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public String getLugarEncuentro() {
        return lugarEncuentro;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int newAforo) {
        if (newAforo == 0) {
            newAforo = Integer.MAX_VALUE;
        }
        this.aforo = newAforo;
    }


    @Override
    public String toString() {
        return "Plan{" +
                "nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", horaInicio=" + horaInicio +
                ", lugarEncuentro='" + lugarEncuentro + '\'' +
                ", aforo=" + aforo +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object plan) {
        return this == plan || plan != null && getClass() == plan.getClass() && (this.equals(((Plan) plan).id));
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


    public List<Actividad> getActividades() {
        return actividadesList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public int totalTime() {
        int totalTime = 0;
        for (Actividad act : getActividades()) {
            totalTime += (int) (act.getDuracion().plus(DESPLAZAMIENTO)).toMinutes();
        }
        return totalTime;
    }

    public double totalCost(int edad) {
        double totalCost = 0.0;
        for (Actividad act : getActividades()) {
            totalCost += act.aplicarDto(edad);
        }
        return totalCost;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
