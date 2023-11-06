package upm.DataTest.RepositoryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.Data.Models.User;
import upm.Data.Repositories.Repositories_Map.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {

    private UserRepository userRepository;
    private User user;

    @BeforeEach
    void before() {
        userRepository = new UserRepository();
        user = new User("Hugo", 57, 629054242, "123");
        userRepository.create(user);
    }

    @Test
    public void isMobileUnicTestNo() {
        Optional<User> result = userRepository.isMobileUnic(629054242);
        assertTrue(result.isPresent());
    }

    @Test
    public void isMobileUnicTestYes() {
        Optional<User> result = userRepository.isMobileUnic(629054242);
        assertTrue(result.isEmpty());
    }

    @Test
    public void isNameUnicNo() {
        Optional<User> result = userRepository.isNameUnic("Hugo");
        assertTrue(result.isPresent());
    }

    @Test
    public void isNameUnicYes() {
        Optional<User> result = userRepository.isNameUnic("Santi");
        assertTrue(result.isEmpty());
    }
}
