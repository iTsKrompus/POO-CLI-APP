package upm;

import java.util.Scanner;

public class User {
    private  String nombreUsuario;
    private final int edad;
    private final int telefono;
    private String password;


    public User(String nombreUsuario, int edad, int telefono, String password) {
        this.nombreUsuario = nombreUsuario;
        while(edad<14 || edad>100){
            System.out.print("Introduzca otro valor de edad\n");
            System.out.print("La edad introducida no es valida\n");
            Scanner sc = new Scanner(System.in);
            edad = sc.nextInt();
        }
        this.edad = edad;
        this.telefono = telefono;
        while(password.length()<3){
            System.out.print("La contraseña es demasiado corta (3 caracteres al menos)");
            Scanner ps = new Scanner(System.in);
            password = ps.nextLine();
        }
        this.password=password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }
    public String getPassword(){
        return password;
    }
    public void setNombreUsuario(String newNombre){
        nombreUsuario=newNombre;
    }

}
