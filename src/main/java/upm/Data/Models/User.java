package upm.Data.Models;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private static final Map<Integer, User> userList = new HashMap<>();
    private final int edad;
    private final String password;
    private int telefono;
    private String nombreUsuario;
    private Integer id;

    public User(String nombreUsuario, int edad, int telefono, String password) {
        if (isNomUserUnico(nombreUsuario)) {
            throw new IllegalArgumentException("Nombre de usuario ya existente");
        }
        this.nombreUsuario = nombreUsuario;
        while (edad < 14 || edad > 100) {
            System.out.print("Introduzca otro valor de edad\n");
            System.out.print("La edad introducida no es valida\n");
            Scanner sc = new Scanner(System.in);
            edad = sc.nextInt();
        }
        this.edad = edad;
        if (!isTelefonoUnico(telefono)) {
            throw new IllegalArgumentException("El número de teléfono " + telefono + " ya existe");
        }
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

    public boolean isTelefonoUnico(int telefono) {
        return !userList.containsKey(telefono);
    }

    public boolean isNomUserUnico(String nombre) {
        for (User user : userList.values()) {
            if (user.getNombreUsuario().equals(nombre)) {
                return false;
            }
        }
        return true;
    }
}