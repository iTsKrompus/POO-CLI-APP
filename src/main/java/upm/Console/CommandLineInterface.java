package upm.Console;

import upm.Data.Models.Actividad;
import upm.Data.Models.ActividadesTipos.ActividadCine;
import upm.Data.Models.ActividadesTipos.ActividadGenerica;
import upm.Data.Models.ActividadesTipos.ActividadTeatro;
import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.Services.ActividadServices;
import upm.Services.PlanServices;
import upm.Services.UserServices;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Scanner;

public class CommandLineInterface {
    private final View view;
    private final UserServices userServices;
    private final ActividadServices actividadServices;
    private final PlanServices planServices;

    public CommandLineInterface(View view, PlanServices planServices, UserServices userServices, ActividadServices actividadServices) {
        this.view = view;
        this.actividadServices = actividadServices;
        this.userServices = userServices;
        this.planServices = planServices;
    }

    public void help() {
        for (CommandNames commandNames : CommandNames.values()) {
            view.show(commandNames.getHelp());
        }
    }

    public boolean runCommands() {
        Scanner scanner = new Scanner(System.in).useDelimiter("[:,\\r\\n]");
        boolean exit = false;
        while (!exit) {
            exit = runCommand(scanner);
        }
        return true;
    }

    private boolean runCommand(Scanner scanner) {
        this.view.showCommand();
        CommandNames command = CommandNames.fromValue(scanner.next());
        boolean exit = false;
        Optional<User> activeUser = Optional.empty();
        switch (command) {
            case CREATE_USER:
                this.createUser(scanner);
                break;
            case CREATE_ACTIVIDAD:
                this.createActividad(scanner);
                break;
            case CREATE_PLAN:
                this.createPlan(scanner);
                break;
            case USER_LOGIN:
                activeUser = userLogin(scanner);
                break;
            case USER_LOGOUT:
                this.userLogout(activeUser);
                break;
            case HELP:
                this.help();
                break;
            case EXIT:
                exit = true;
                break;
        }
        return exit;
    }

    private void createUser(Scanner scanner) {
        String[] datos = scanner.next().split(";");
        if (datos.length != 4) {
            throw new IllegalArgumentException(CommandNames.CREATE_USER.getHelp());
        }
        User createdUser = this.userServices.create(new User(datos[0], Integer.valueOf(datos[1]), Integer.valueOf(datos[2]), datos[3]));
        this.view.show(createdUser.toString());
    }

    private void createActividad(Scanner scanner) {
        Actividad createdActividad;

        String[] datos = scanner.next().split(";");
        if (datos.length != 5 && datos.length != 6) {
            throw new IllegalArgumentException(CommandNames.CREATE_ACTIVIDAD.getHelp());
        }
        if (datos[0].equals("teatro")) {
            createdActividad = actividadServices.create(new ActividadTeatro(datos[0], datos[1], datos[2], Duration.ofMinutes(Integer.parseInt(datos[3])), Double.valueOf(datos[4]), Integer.valueOf(datos[5])));
        } else if (datos[0].equals("cine")) {
            createdActividad = actividadServices.create(new ActividadCine(datos[0], datos[1], datos[2], Duration.ofMinutes(Integer.parseInt(datos[3])), Double.valueOf(datos[4]), Integer.valueOf(datos[5])));
        } else if (datos[0].equals("generico")) {
            createdActividad = actividadServices.create(new ActividadGenerica(datos[0], datos[1], datos[2], Duration.ofMinutes(Integer.parseInt(datos[3])), Double.valueOf(datos[4]), Integer.valueOf(datos[5])));
        } else {
            createdActividad = actividadServices.create(new ActividadGenerica(datos[0], datos[1], datos[2], Duration.ofMinutes(Integer.parseInt(datos[3])), Double.valueOf(datos[4]), Integer.valueOf(datos[5])));

        }
        this.view.show(createdActividad.toString());
    }

    private void createPlan(Scanner scanner) {
        String[] datos = scanner.next().split(";");
        if (datos.length != 7) {
            throw new IllegalArgumentException(CommandNames.CREATE_PLAN.getHelp());
        }
        Plan createdPlan = planServices.create(new Plan(datos[0], LocalDate.parse(datos[1]), LocalTime.parse(datos[2]), datos[3], Integer.parseInt(datos[4])));
        this.view.show(createdPlan.toString());
    }

    private Optional<User> userLogin(Scanner scanner) {
        try {
            String[] datos = scanner.next().split(";");
            if (datos.length != 2) {
                throw new IllegalArgumentException(CommandNames.USER_LOGIN.getHelp());
            }
            User userName = userServices.login(datos[0], datos[1]);
            return Optional.of(userName);

        } catch (IllegalArgumentException exception){
            return Optional.empty();
        }
    }
    private void userLogout(Optional<User> userName){
        if (userName.isEmpty()){
            throw new IllegalArgumentException("No puede cerrar sesión si no la ha iniciado primero");
        }
        userName = Optional.empty();
    }
}


