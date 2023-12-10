package upm.DataTest.RepositoryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.User;
import upm.Data.Repositories.Repositories_Map.UserRepository;
import upm.Data.Repositories.UserRepositoryInterface;
import upm.DependencyInjector;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {

    private final UserRepositoryInterface userRepository = DependencyInjector   .getDependencyInjector().getUserRepositoryInterface();


    @Test
    void testCreateAndRead() {
        Optional<User> user = this.userRepository.read(1);
        assertTrue(user.isPresent());
        assertEquals("hugo", user.get().getNombreUsuario());
    }

    @Test
    public void findByMobileSuccess() {
        Optional<User> result = userRepository.findByMobile(629054242);
        assertTrue(result.isPresent());
    }

    @Test
    public void findByMobileNotExist() {
        Optional<User> result = userRepository.findByMobile(26255453);
        assertTrue(result.isEmpty());
    }

    @Test
    public void findByNameSuccess() {
        Optional<User> result = userRepository.findByName("Alejandro");
        assertTrue(result.isPresent());
    }

    @Test
    public void findByNameNotExist() {
        Optional<User> result = userRepository.findByName("Santi");
        assertTrue(result.isEmpty());
    }


}
