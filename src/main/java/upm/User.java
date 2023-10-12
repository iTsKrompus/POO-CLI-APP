package upm;

public class User {
    private final String nombre_usuario;
    private final int edad;
    private final int telefono;


    public User(String nombre_usuario, int edad, int telefono) {
        this.nombre_usuario = nombre_usuario;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public int getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }

}
