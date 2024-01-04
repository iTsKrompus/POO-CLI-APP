package upm.Data.Repositories;

import upm.Data.Models.Actividad;
import upm.Data.Models.ActividadesTipos.ActividadCine;
import upm.Data.Models.ActividadesTipos.ActividadGenerica;
import upm.Data.Models.ActividadesTipos.ActividadTeatro;
import upm.Data.Models.Plan;
import upm.Data.Models.User;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppSeeder {
    private final PlanRepositoryInterface planRepositoryInterface;
    private final UserRepositoryInterface userRepositoryInterface;
    private final ActividadRepositoryInterface actividadRepositoryInterface;


    public AppSeeder(PlanRepositoryInterface planRepositoryInterface, UserRepositoryInterface userRepositoryInterface, ActividadRepositoryInterface actividadRepositoryInterface) {
        this.actividadRepositoryInterface = actividadRepositoryInterface;
        this.userRepositoryInterface = userRepositoryInterface;
        this.planRepositoryInterface = planRepositoryInterface;
    }

    public void seed() {
        User[] users = {
                new User("hugo", 19, 676357373, "123"),
                new User("pablo", 33, 747987496, "987"),
                new User("Emilio", 79, 637945824, "111"),
                new User("Alejandro", 57, 629054242, "123")
        };
        for (User usersCreated : users) {
            userRepositoryInterface.create(usersCreated);
        }
        Actividad[] actividades = {
                new ActividadTeatro("teatro", "ruisenol", "Obra maestra", Duration.ofMinutes(125), 15.99, 20),
                new ActividadCine("cine", "Quedada para interestellar", "Mejor peli de la historia en callao", Duration.ofMinutes(200), 8.99, 12),
                new ActividadGenerica("generica", "fiesta en la calle corazon de maria", "El viernes a las 5 de la tarde", Duration.ofMinutes(60), 20.00, 0)
        };
        for (Actividad actividadCreated : actividades) {
            actividadRepositoryInterface.create(actividadCreated);
        }
        Plan[] planes = {
                new Plan("Tarde Increible", LocalDate.of(2023, 05, 12), LocalTime.of(17, 50), "Encuentro en marques de vadillo", 0),
                new Plan("Villaverde party", LocalDate.of(2024, 12, 10), LocalTime.of(10, 30), "puente de vallecas", 0),
                new Plan("Bamboreal", LocalDate.of(2026, 12, 10), LocalTime.of(19, 30), "italia torre de pizza", 1)
        };
        planes[0].setOwnerName("pablo");

        planes[1].setOwnerName("hugo");
        planes[1].addActividad(actividades[2]);
        planes[1].addActividad(actividades[1]);

        planes[2].setOwnerName("hugo");
        for (Plan planCreated : planes) {
            planRepositoryInterface.create(planCreated);
        }
    }
}
