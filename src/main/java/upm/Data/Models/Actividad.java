package upm.Data.Models;

import java.time.Duration;
import java.util.Objects;

public abstract class Actividad {
    protected static final double DTO_JOVEN = 0.5;
    private final String nombre;
    private String tipo;
    private final String descripcion;
    private final Duration duracion;
    private int aforo;
    private double coste;
    private Integer id;


    public Actividad(String tipo, String nombre, String descripcion, Duration duracion, double coste, int aforo) {
        setTipo(tipo);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.coste = coste;
        setAforo(aforo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (!tipo.equals("generica") && !(tipo.equals("cine")) && !(tipo.equals("teatro"))) {
            throw new IllegalArgumentException("Tipo de actividad no existente");
        }
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        if (aforo == 0) {
            aforo = Integer.MAX_VALUE;
        }
        this.aforo = aforo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion.toMinutes() +
                ", coste=" + coste +
                "€, aforo=" + aforo +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object actividad) {
        return this == actividad || actividad != null && getClass() == actividad.getClass() && (this.equals(((Actividad) actividad).id));
    }

    public abstract double aplicarDto(int edad);


}
