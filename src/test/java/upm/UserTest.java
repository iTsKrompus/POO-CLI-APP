package upm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    @BeforeEach
    void before(){
        User user = new User("Hugo", 57, 6290336521L, "13");
    }


    @Test
    void testUser(){
        new User();
    }
}
