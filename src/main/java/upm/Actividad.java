package upm;

public class Actividad {
    private String tipo;
    private String nombre;
    private String descripcion;
    private int duracion;
    private float coste;
    private int aforo;

    public Actividad(String tipo, String nombre, String descripcion, int duracion, float coste,int aforo ){
        this.tipo=tipo;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.duracion=duracion;
        this.coste=coste;
        this.aforo=aforo;
    }

    public String getTipo(){
        return tipo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public int getDuracion(){
        return duracion;
    }
    public float getCoste(){
        return coste;
    }
    public int getAforo(){
        return aforo;
    }
}
