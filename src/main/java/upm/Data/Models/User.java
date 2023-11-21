package upm.Data.Models;

import java.util.Objects;

public class User {
    private int edad;
    private String password;
    private int telefono;
    private String nombreUsuario;
    private Integer id;
    private String loginStatus = "disconected";

    public User(String nombreUsuario, int edad, int telefono, String password) {
        this.nombreUsuario = nombreUsuario;
        setEdad(edad);
        this.telefono = telefono;
        setPassword(password);
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

    public void setEdad(int edad) {
        if (edad < 14 || edad > 100) {
            throw new IllegalArgumentException("Rango de edad incorrecto (Permitido entre 14 y 100)");
        }
        this.edad = edad;
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

    public void setPassword(String password) {
        if (password.length() < 3) {
            throw new IllegalArgumentException("La password es demasiado corta (3 caracteres al menos)");
        }
        this.password = password;
    }
    public void setId(Integer id){
        this.id = id;
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