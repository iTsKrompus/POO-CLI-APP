package upm.Console;

import upm.Services.ActividadServices;
import upm.Services.PlanServices;
import upm.Services.UserServices;

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

}
