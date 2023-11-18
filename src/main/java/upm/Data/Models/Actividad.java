package upm.Data.Models;

import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;

public class Actividad {
    private final String tipo;
    private final String nombre;
    private final String descripcion;
    private Duration duracion;
    private final int aforo;
    private double coste;
    private Integer id;

    public Actividad(String tipo, String nombre, String descripcion, Duration duracion, double coste, int aforo) {
        while (!tipo.equals("genérica") && !(tipo.equals("cine")) && !(tipo.equals("teatro"))) {
            System.out.print("Introduzca el tipo de actividad existente(genérica, cine o teatro)\n");
            System.out.print("Tipo de actividad no existente:\n");
            Scanner sc = new Scanner(System.in);
            tipo = sc.nextLine();
        }
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.coste = coste;
        if (aforo == 0) {
            this.aforo = Integer.MAX_VALUE;
        } else {
            this.aforo = aforo;
        }
    }

    public String getTipo() {
        return tipo;
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

    public int getAforo() {
        return aforo;
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
                ", duracion=" + duracion +
                ", coste=" + coste +
                ", aforo=" + aforo +
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

    public double aplicarDto(User user) {
        if (tipo.equals("teatro") && user.getEdad() <= 25) {
            this.coste *= 0.5;
        } else if (tipo.equals("teatro") && user.getEdad() >= 65) {
            this.coste *= 0.3;
        } else if (tipo.equals("cine") && user.getEdad() <= 21) {
            this.coste *= 0.5;
        }
        return coste;
    }
}
