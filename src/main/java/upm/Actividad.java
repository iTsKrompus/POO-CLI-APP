package upm;

import java.util.Scanner;

public class Actividad {
    private String tipo;
    private String nombre;
    private String descripcion;
    private int duracion;
    private float coste;
    private int aforo;

    public Actividad(String tipo, String nombre, String descripcion, int duracion, float coste,int aforo ){
        while(!tipo.equals("genérica")&&!(tipo.equals("cine"))&&!(tipo.equals("teatro"))){
            System.out.print("Introduzca el tipo de actividad(genérica, cine o teatro)\n");
            System.out.print("Tipo de actividad no existente:\n");
            Scanner sc = new Scanner(System.in);
            tipo = sc.nextLine();
        }
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
