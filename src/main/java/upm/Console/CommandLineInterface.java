package upm.Console;

import upm.Data.Models.Actividad;
import upm.Data.Models.ActividadesTipos.ActividadCine;
import upm.Data.Models.ActividadesTipos.ActividadGenerica;
import upm.Data.Models.ActividadesTipos.ActividadTeatro;
import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.DependencyInjector;
import upm.InvalidObjectException;
import upm.Services.ActividadServices;
import upm.Services.PlanServices;
import upm.Services.UserServices;
import upm.UserContainer;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    public boolean runCommands(DependencyInjector dependencyInjector) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[:,\\r\\n]");
        boolean exit = false;
        UserContainer userContainer = new UserContainer();
        while (!exit) {
            exit = runCommand(scanner, dependencyInjector.getUserContainer());
        }
        return true;
    }

    private boolean runCommand(Scanner scanner, UserContainer userContainer) {
        this.view.showCommand();
        CommandNames command = CommandNames.fromValue(scanner.next());
        boolean exit = false;
        switch (command) {
            case CREATE_USER:
                this.createUser(scanner);
                break;
            case CREATE_ACTIVIDAD:
                this.createActividad(scanner, userContainer.getUser());
                break;
            case LIST_2HOURS_ACTIVIDADES:
                this.listTwoHoursDurationActivities(userContainer.getUser());
                break;
            case LIST_MAX_COST_10_ACTIVIDADES:
                this.activitiesTenEuroMaxCost(userContainer.getUser());
                break;
            case ACTIVITIES_PER_TYPE:
                this.activitiesPerType(scanner, userContainer.getUser());
                break;
            case CREATE_PLAN:
                this.createPlan(scanner, userContainer.getUser());
                break;
            case DELETE_PLAN:
                this.deletePlan(scanner, userContainer.getUser());
                break;
            case USER_LOGIN:
                userContainer.setUser(userLogin(scanner));
                break;
            case USER_LOGOUT:
                userLogout(userContainer.getUser());
                userContainer.cleanUser();
                break;
            case PLANS_LIST:
                listPlanes(userContainer.getUser());
                break;
            case JOIN_PLAN:
                joinPlan(userContainer.getUser(), scanner);
                break;
            case LEFT_PLAN:
                leftPlan(userContainer.getUser(), scanner);
                break;
            case SUBSCRIBED_PLANS_LIST:
                subscribedPlanList(userContainer.getUser());
                break;
            case ADD_ACTIVIDAD_TO_PLAN:
                addActivityToPlan(scanner, userContainer.getUser());
                break;
            case CHECK_PLAN_COST:
                checkPlanCost(scanner, userContainer.getUser());
                break;
            case RATE_PLAN:
                this.ratePlan(scanner, userContainer.getUser());
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

    private void createActividad(Scanner scanner, Optional<User> activeUser) {
        checkLoginStatus(activeUser);
        this.view.show("Introduzca los datos de la actividad a crear(tipo;nombre;descripcion;duracion;coste;aforo): ");
        String[] datos = scanner.next().split(";");
        if (datos.length != 6) {
            throw new IllegalArgumentException(CommandNames.CREATE_ACTIVIDAD.getHelp());
        }
        Actividad createdActividad;
        switch (datos[0]) {
            case "teatro":
                createdActividad = actividadServices.create(new ActividadTeatro(datos[0], datos[1], datos[2], Duration.ofMinutes(Integer.parseInt(datos[3])), Double.valueOf(datos[4]), Integer.valueOf(datos[5])));
                break;
            case "cine":
                createdActividad = actividadServices.create(new ActividadCine(datos[0], datos[1], datos[2], Duration.ofMinutes(Integer.parseInt(datos[3])), Double.valueOf(datos[4]), Integer.valueOf(datos[5])));
                break;
            case "generica":
                createdActividad = actividadServices.create(new ActividadGenerica(datos[0], datos[1], datos[2], Duration.ofMinutes(Integer.parseInt(datos[3])), Double.valueOf(datos[4]), Integer.valueOf(datos[5])));
                break;
            default:
                throw new IllegalArgumentException("Tipo de actividad no valido: " + datos[0]);
        }
        this.view.show(createdActividad.toString());
    }


    private void createPlan(Scanner scanner, Optional<User> activeUser) {
        checkLoginStatus(activeUser);
        this.view.show("Introduzca los datos del plan a crear(nombre;fecha (yyyy-MM-dd);hora (HH:mm);lugarEncuentro;aforo): ");

        scanner.nextLine();
        String[] datos = scanner.nextLine().split(";");

        if (datos.length != 5) {
            throw new InvalidValuesException(CommandNames.CREATE_PLAN.getHelp());
        }

        Plan createdPlan = planServices.create(new Plan(datos[0], LocalDate.parse(datos[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.parse(datos[2], DateTimeFormatter.ofPattern("HH:mm")), datos[3], Integer.valueOf(datos[4])));
        createdPlan.setOwnerName(activeUser.get().getNombreUsuario());

        this.view.show(createdPlan.toString());
    }

    private void addActivityToPlan(Scanner scanner, Optional<User> activeUser) {
        checkLoginStatus(activeUser);
        String[] datos = scanner.next().split(";");
        if (datos.length != 2) {
            throw new InvalidValuesException(CommandNames.ADD_ACTIVIDAD_TO_PLAN.getHelp());
        }
        Integer[] ids = new Integer[]{Integer.parseInt(datos[0]), Integer.parseInt(datos[1])};
        planServices.addActivity(ids, activeUser.get());
        view.show("La actividad ha sido agregada correctamente al plan!");
    }

    private void deletePlan(Scanner scanner, Optional<User> activeUser) {
        Integer datos = scanner.nextInt();
        planServices.delete(datos, activeUser.get());
        view.show("El plan ha sido borrado correctamente!");
    }

    private User userLogin(Scanner scanner) {

        String[] datos = scanner.next().split(";");
        if (datos.length != 2) {
            throw new InvalidValuesException(CommandNames.USER_LOGIN.getHelp());
        }
        User userName = userServices.login(datos[0], datos[1]);
        view.showBold("Bienvenido " + datos[0] + "!");
        return userName;

    }

    private void userLogout(Optional<User> activeUser) {
        checkLoginStatus(activeUser);
        view.showBold("Adios " + activeUser.get().getNombreUsuario());
    }

    private void listPlanes(Optional<User> activeUser) {
        checkLoginStatus(activeUser);
        this.planServices.listar();
    }

    private void checkLoginStatus(Optional<User> activeUser) {
        if (activeUser.isEmpty()) {
            throw new InvalidObjectException("Primero debe iniciar sesion para poder realizar alguna accion");
        }
    }

    private void joinPlan(Optional<User> user, Scanner scanner) {
        checkLoginStatus(user);
        this.view.show("Introduzca el id del plan al que quiere unirse ");
        Integer id = scanner.nextInt();
        planServices.joinPlanById(user.get(), id);
        view.showBold("El usuario " + user.get().getNombreUsuario() + " se ha unido correctamente al plan!");
    }

    private void leftPlan(Optional<User> user, Scanner scanner) {
        checkLoginStatus(user);
        this.view.show("Introduzca el id del plan que quiere abandonar");
        Integer id = scanner.nextInt();
        planServices.leftById(user.get(), id);
        view.showBold("El usuario " + user.get().getNombreUsuario() + " ha abandonado el plan correctamente");

    }

    private void subscribedPlanList(Optional<User> user) {
        checkLoginStatus(user);
        this.view.show("Planes a los que esta subscrito: ");
        List<Plan> planes = planServices.listarSubscritos(user.get().getNombreUsuario());

    }

    private void checkPlanCost(Scanner scanner, Optional<User> user) {
        checkLoginStatus(user);
        Integer datos = scanner.nextInt();
        this.view.show("Coste total del plan con id " + datos + ": " + planServices.checkTotalCost(datos, user.get()));

    }

    private void listTwoHoursDurationActivities(Optional<User> user) {
        checkLoginStatus(user);
        List<Actividad> actividades = this.actividadServices.listarDuracionDosHoras();
        showLists(actividades);

    }

    private void activitiesTenEuroMaxCost(Optional<User> user) {
        checkLoginStatus(user);
        List<Actividad> actividades = this.actividadServices.listarMaxCosteDiez();
        showLists(actividades);
    }

    private void activitiesPerType(Scanner scanner, Optional<User> user) {
        checkLoginStatus(user);
        view.showBold("Tipo de actividad: ");
        List<Actividad> actividades = actividadServices.listarTipo(scanner.next());
        showLists(actividades);
    }

    private void showLists(List<Actividad> actividades) {
        ShowObject<Actividad> results = new ShowObject<Actividad>(view);
        results.showListInformation(actividades);
    }

    private void ratePlan(Scanner scanner, Optional<User> activeUser) {
        checkLoginStatus(activeUser);

        view.show("Cual plan quiere valorar ? ");
        Integer id = scanner.nextInt();
        this.planServices.rate(id);

        view.show("Que puntuacion le quiere dar? ");
        Float rate = scanner.nextFloat();
        activeUser.get().setPuntuaciones(userServices.ratePlan(activeUser.get().getPuntuaciones(), id, rate));
    }

}


