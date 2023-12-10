package upm.ServiceTest;

import org.junit.jupiter.api.Test;
import upm.Data.Models.Plan;
import upm.Data.Models.User;
import upm.Data.Repositories.PlanRepositoryInterface;
import upm.DependencyInjector;
import upm.Services.PlanServices;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

public class PlanServicesTest {

    private final PlanServices planServices = DependencyInjector.getDependencyInjector().getPlanServices();
    private final PlanRepositoryInterface planRepositoryInterface = DependencyInjector.getDependencyInjector().getPlanRepositoryInterface();

    @Test
    public void joinPlanCorrect(){
        Optional<Plan> plan =planRepositoryInterface.read(1);
        User user = new User("Aznar", 54, 637945824, "111");
        planServices.joinPlanById(user, 1);
        assertTrue(plan.get().getUserList().contains(user));
    }

    @Test
    public void checkIfPlanExistFalse (){
        Optional<Plan> plan =planRepositoryInterface.read(1);
        User user = new User("Aznar", 54, 637945824, "111");
        assertThrows(IllegalArgumentException.class, () -> {planServices.joinPlanById(user, 77);;
            throw new IllegalArgumentException("El id especificado no corresponde a ningun plan");
        });
    }

    @Test
    public void joinPlanAlreadyJoined (){
        Optional<Plan> plan =planRepositoryInterface.read(1);
        User user = new User("Aznar", 54, 637945824, "111");
        planServices.joinPlanById(user, 1);

        assertThrows(IllegalArgumentException.class, () -> {planServices.joinPlanById(user, 1);;
            throw new IllegalArgumentException("El usuario ya esta apuntado al plan con el id=");
        });

    }

    @Test
    public void  joinPlanFull(){
        Optional<Plan> plan =planRepositoryInterface.read(1);
        User user = new User("Aznar", 54, 637945824, "111");
        User user2 = new User("Pedro", 54, 6363463, "111");
        planServices.joinPlanById(user, 3);

        assertThrows(IllegalArgumentException.class, () -> {planServices.joinPlanById(user2, 3);;
            throw new IllegalArgumentException("No es posible unirse al plan dado que el aforo esta completo");
        });
    }

    }

