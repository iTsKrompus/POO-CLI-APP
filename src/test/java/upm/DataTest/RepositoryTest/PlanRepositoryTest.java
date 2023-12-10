package upm.DataTest.RepositoryTest;

import org.junit.jupiter.api.Test;
import upm.Data.Repositories.PlanRepositoryInterface;
import upm.DependencyInjector;
import static org.junit.jupiter.api.Assertions.*;

public class PlanRepositoryTest {

    private final PlanRepositoryInterface planRepositoryInterface = DependencyInjector.getDependencyInjector().getPlanRepositoryInterface();

    @Test
    public void testReadExist (){

        assertTrue(planRepositoryInterface.read(1).isPresent());
    }

    @Test
    public void testReadNotExist (){

        assertTrue(planRepositoryInterface.read(5552).isEmpty());
    }

}
