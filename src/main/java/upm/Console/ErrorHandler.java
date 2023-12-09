package upm.Console;

import upm.DependencyInjector;

public class ErrorHandler {
    private final CommandLineInterface commandLineInterface;
    private final View view;

    public ErrorHandler(CommandLineInterface commandLineInterface, View view) {
        this.commandLineInterface = commandLineInterface;
        this.view = view;
        this.view.showBold("App Gestión de Planes Sociales (GPS). " + "UPM.PROYECTO.POO");
    }

    public void handlesErrors(DependencyInjector dependencyInjector) {
        boolean exit = false;
        while (!exit) {
            try {
                exit = this.commandLineInterface.runCommands(dependencyInjector);
            } catch (Exception e) {
                this.view.showError("> ERROR (" + e.getClass().getSimpleName() + ") >>> " + e.getMessage());
            }
        }
        this.view.showBold("Hasta pronto!");
    }
}
