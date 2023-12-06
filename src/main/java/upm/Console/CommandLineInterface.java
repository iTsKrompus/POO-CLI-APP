package upm.Console;

import upm.Data.Models.User;
import upm.Services.ActividadServices;
import upm.Services.PlanServices;
import upm.Services.UserServices;

import java.util.Scanner;

public class CommandLineInterface {
    private final View view;
    private final UserServices userServices;
    private final ActividadServices actividadServices;
    private final PlanServices planServices;

    public CommandLineInterface(View view, PlanServices planServices, UserServices userServices, ActividadServices actividadServices){
        this.view = view;
        this.actividadServices = actividadServices;
        this.userServices = userServices;
        this.planServices = planServices;
    }

    public void help() {
        for (CommandNames commandNames : CommandNames.values()){
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
                this.userLogin(scanner);
                break;
            case USER_LOGOUT:
                this.help();
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
    private void createUser(Scanner scanner){
        String [] values = scanner.next().split(";");
        if (values.length != 3) {
            throw new IllegalArgumentException(CommandNames.CREATE_USER.getHelp());
        }
        User createdUser = this.userServices.create(new User(values[0], Integer.valueOf(values[1]), Integer.valueOf(values[2]), values[3]));
        this.view.show(createdUser.toString());
    }
    }

