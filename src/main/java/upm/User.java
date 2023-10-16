package upm;

import java.util.Scanner;

public class User {
    private final int edad;
    private final long telefono;
    private final String password;
    private String nombreUsuario;


    public User(String nombreUsuario, int edad, long telefono, String password) {
        this.nombreUsuario = nombreUsuario;
        while (edad < 14 || edad > 100) {
            System.out.print("Introduzca otro valor de edad\n");
            System.out.print("La edad introducida no es valida\n");
            Scanner sc = new Scanner(System.in);
            edad = sc.nextInt();
        }
        this.edad = edad;
        this.telefono = telefono;
        while (password.length() < 3) {
            System.out.print("La contraseña es demasiado corta (3 caracteres al menos)");
            Scanner ps = new Scanner(System.in);
            password = ps.nextLine();
        }
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String newNombre) {
        nombreUsuario = newNombre;
    }

    public int getEdad() {
        return edad;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "edad=" + edad +
                ", telefono=" + telefono +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
