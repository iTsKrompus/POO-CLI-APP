package upm.Data.Models;

import java.util.List;

public class Plan {
    private final String nombre;
    private final String fecha;
    private final String hora;
    private final String lugarEncuentro;
    private int aforo;
    private int id;
    private List<Actividad> actividades;
    private List<User> userList;

    public Plan(String nombre, String fecha, String hora, String lugarEncuentro, int aforo, List<Actividad> actividades, List<User> userList) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.lugarEncuentro = lugarEncuentro;
        if (aforo == 0) {
            this.aforo = Integer.MAX_VALUE;
        } else {
            this.aforo = aforo;
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
            if(actividad.getAforo()< this.getAforo()){
                this.setAforo(actividad.getAforo());
            }
        } else{
            throw new IllegalArgumentException("El aforo de la actividad no puede ser mayor al del plan\n");
        }
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public List<User> getUserList() {
        return userList;
    }
}
