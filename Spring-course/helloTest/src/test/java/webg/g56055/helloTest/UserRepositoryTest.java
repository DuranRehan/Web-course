package webg.g56055.helloTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByName() {
        User user = new User("ValidLogin", "MCD");
        userRepository.save(user);
        User found = userRepository.findByName(user.getName());
        assertEquals(user, found);
    }

    @Test
    public void findByLongLogin() {
        User user1 = new User("ValidLogin", "MCD");
        User user2 = new User("VeryLongLogin", "MCD");
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> found = userRepository.findByLongLogin();
        assertEquals(1, found.size());
        assertEquals(user2, found.get(0));
    }
}