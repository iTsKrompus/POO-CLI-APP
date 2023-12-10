package upm.DataTest.RepositoryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.User;
import upm.Data.Repositories.Repositories_Map.UserRepository;
import upm.Data.Repositories.UserRepositoryInterface;
import upm.DependencyInjector;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {

    private final UserRepositoryInterface userRepository = DependencyInjector   .getDependencyInjector().getUserRepositoryInterface();
    private User user;



    @Test
    public void isMobileUnicTestNo() {
        Optional<User> result = userRepository.findByMobile(629054242);
        assertTrue(result.isPresent());
    }

    @Test
    public void isMobileUnicTestYes() {
        Optional<User> result = userRepository.findByMobile(629054242);
        assertTrue(result.isEmpty());
    }

    @Test
    public void isNameUnicNo() {
        Optional<User> result = userRepository.findByName("Hugo");
        assertTrue(result.isPresent());
    }

    @Test
    public void isNameUnicYes() {
        Optional<User> result = userRepository.findByName("Santi");
        assertTrue(result.isEmpty());
    }
}
