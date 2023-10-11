package webg.g56055.helloTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserByName() {
        String name = "MCD";
        User user = new User("ValidLogin", name);
        Mockito.when(userRepository.findByName(name)).thenReturn(user);
        User found = userService.getUserByName(name);
        assertEquals(found.getName(), name);
    }
}
