package upm;

import upm.Console.CommandLineInterface;
import upm.Console.ErrorHandler;
import upm.Console.View;
import upm.Data.Repositories.ActividadRepositoryInterface;
import upm.Data.Repositories.AppSeeder;
import upm.Data.Repositories.PlanRepositoryInterface;
import upm.Data.Repositories.Repositories_Map.ActividadRepository;
import upm.Data.Repositories.Repositories_Map.PlanRepository;
import upm.Data.Repositories.Repositories_Map.UserRepository;
import upm.Data.Repositories.UserRepositoryInterface;
import upm.Services.ActividadServices;
import upm.Services.PlanServices;
import upm.Services.UserServices;

public class DependencyInjector {
    private static final DependencyInjector dependencyInjector = new DependencyInjector();
    private final ErrorHandler errorHandler;
    private final View view;
    private final CommandLineInterface commandLineInterface;
    private final UserRepositoryInterface userRepositoryInterface;
    private final ActividadRepositoryInterface actividadRepositoryInterface;
    private final PlanRepositoryInterface planRepositoryInterface;
    private final UserServices userServices;
    private final ActividadServices actividadServices;
    private final PlanServices planServices;
    private final UserContainer userContainer;
    private final AppSeeder appSeeder;

    private DependencyInjector() {
        this.view = new View();

        this.userRepositoryInterface = new UserRepository();
        this.actividadRepositoryInterface = new ActividadRepository();
        this.planRepositoryInterface = new PlanRepository();

        this.userServices = new UserServices(this.userRepositoryInterface, this.planRepositoryInterface);
        this.actividadServices = new ActividadServices(this.actividadRepositoryInterface);
        this.planServices = new PlanServices(this.planRepositoryInterface, this.actividadRepositoryInterface);

        this.commandLineInterface = new CommandLineInterface(this.view, this.planServices, this.userServices, this.actividadServices);

        this.errorHandler = new ErrorHandler(this.commandLineInterface, this.view);

        this.userContainer = new UserContainer();

        this.appSeeder = new AppSeeder(this.planRepositoryInterface, this.userRepositoryInterface, this.actividadRepositoryInterface);
        this.appSeeder.seed();
    }

    public static DependencyInjector getDependencyInjector() {
        return dependencyInjector;
    }

    public void run() {
        this.errorHandler.handlesErrors(dependencyInjector);
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public View getView() {
        return view;
    }

    public CommandLineInterface getCommandLineInterface() {
        return commandLineInterface;
    }

    public UserRepositoryInterface getUserRepositoryInterface() {
        return userRepositoryInterface;
    }

    public ActividadRepositoryInterface getActividadRepositoryInterface() {
        return actividadRepositoryInterface;
    }

    public PlanRepositoryInterface getPlanRepositoryInterface() {
        return planRepositoryInterface;
    }

    public UserServices getUserServices() {
        return userServices;
    }

    public ActividadServices getActividadServices() {
        return actividadServices;
    }

    public PlanServices getPlanServices() {
        return planServices;
    }

    public UserContainer getUserContainer() {
        return this.userContainer;
    }

    public AppSeeder getAppSeeder(){return  this.appSeeder; }
}
