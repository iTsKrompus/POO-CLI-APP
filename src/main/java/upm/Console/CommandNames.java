package upm.Console;

public enum CommandNames {

    CREATE_USER("create-user", "                  <userName> ; <edad> ; <telefono> ; <contrasena> Parametros a introducir para  crear un usuario"),
    USER_LOGIN("login", "                        <userName> ; <contrasena> Credenciales para iniciar sesion"),
    USER_LOGOUT("logout", "                       Cierra la sesion"),
    CREATE_ACTIVIDAD("create-activity", "              <tipo de actividad (generica/cine/teatro)> ; <nombre> ; <descripcion de la actividad> ; <duracion(minutos)> ; <coste> ; <aforo(0 para ilimitado)> Parametros a introducir para crear una actividad"),
    LIST_2HOURS_ACTIVIDADES("list-two-hour-activities", "     Muestra las actividades que tengan una duracion igual o superior a las 2 horas"),
    LIST_MAX_COST_10_ACTIVIDADES("list-max-activity-cost-ten", "   Muestra las actividades que su coste no supere los 10€"),
    ACTIVITIES_PER_TYPE("activities-per-type", "          <tipo de actividad (generica/cine/teatro)>    Muestra las actividades disponibles del tipo introducido"),
    CREATE_PLAN("create-plan", "                  <nombre del plan> ; <fecha de inicio> ; <hora de comienzo> ; <lugar de encuentro> ; <aforo(0 para que no haya maximo)>"),
    DELETE_PLAN("delete-plan", "                  <nombre del plan>     Elimina un plan del que eres propietario introduciendo el id"),
    ADD_ACTIVIDAD_TO_PLAN("add-activity-to-plan", "         <idActivity> ; <idPlan>   Agrega una actividad a un plan ya existente"),
    PLANS_LIST("plans-list", "                   lista los planes existentes"),
    JOIN_PLAN("join-plan", "                    <planId>  Comando para unirse a un plan introduciendo su id"),
    LEFT_PLAN("left-plan", "                    <planId>   Comando para abandonar un plan introduciendo su id"),
    SUBSCRIBED_PLANS_LIST("subscribed-plans-list", "        muestra la lista de los planes a los que estas subscrito"),
    CHECK_PLAN_COST("check-plan-cost", "              <planId>     Muestra el coste total del plan con todas sus actividades"),
    RATE_PLAN("rate-plan", "                    <planId> <valoracion>    Permite puntuar planes a los usuarios"),
    HELP("help", "                         muestra la ayuda de todos los comandos disponibles"),
    EXIT("exit", "                         termina la lectura de comandos(termina la ejecuccion del programa)");

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
        return this.getName() + this.help;
    }
}
