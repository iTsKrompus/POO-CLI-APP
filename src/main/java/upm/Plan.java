package upm;

public class Plan {
    private final String nombre;
    private final String fecha;
    private final String hora;
    private final String lugarEncuentro;
    private final int capacidadMax;

    public Plan(String nombre, String fecha, String hora, String lugarEncuentro, int capacidadMax) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.lugarEncuentro = lugarEncuentro;
        this.capacidadMax = capacidadMax;
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

}
