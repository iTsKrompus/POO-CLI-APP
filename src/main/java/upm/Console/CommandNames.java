package upm.Console;

public enum CommandNames {

    CREATE_USER("create-user", "<userName> ; <edad> ; <telefono> ; <contrasena> Parametros a introducir para  crear un usuario"),
    USER_LOGIN("login", "<userName> ; <contrasena> Credenciales para iniciar sesion"),
    USER_LOGOUT("logout", "Cierra la sesion"),
    CREATE_ACTIVIDAD("create-activity", "<tipo> ; <nombre> ; <descripcion de la actividad> ; <duracion(minutos)> ; <coste> ; <aforo(0 para ilimitado)> Parametros a introducir para crear una actividad"),
    CREATE_PLAN("create-plan", "<nombre del plan> ; <fecha de inicio> ; <hora de comienzo> ; <lugar de encuentro> ; <aforo(0 para que no haya maximo)>");

    private final String name;
    private final String help;


    CommandNames(String name, String help) {
        this.name = name;
        this.help = help;
    }

    public static CommandNames fromValue(String name) {
        for (CommandNames command : CommandNames.values()) {
            if (command.getName().equals(name)) {
                return command;
            }
        }
        throw new UnsupportedOperationException("Comando '" + name + "' no existe.");
    }

    public String getName() {
        return name;
    }

    public String getHelp() {
        return help;
    }
}
