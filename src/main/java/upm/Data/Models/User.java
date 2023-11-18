package upm.Data.Models;

import java.util.Objects;
import java.util.Scanner;

public class User {
    private final int edad;
    private final String password;
    private int telefono;
    private String nombreUsuario;
    private Integer id;
    private String loginStatus = "disconected";

    public User(String nombreUsuario, int edad, int telefono, String password) {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object user) {
        return this == user || user != null && getClass() == user.getClass() && (this.equals(((User) user).id));
    }


    public String getLoginStatus() {
        return loginStatus;
    }

    public void setStatus(String status) {
        this.loginStatus = status;
    }
}