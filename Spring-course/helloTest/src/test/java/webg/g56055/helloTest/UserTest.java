package webg.g56055.helloTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SpringBootTest
public class UserTest {
    @Autowired
    private BeanValidationUtil<User> validator;

    @Test
    public void loginValid() {
        User user = new User("ValidLogin", "Name");
        validator.assertIsValid(user);
    }

    @Test
    public void loginSizeLessThan6Error() {
        User user = new User("Login", "Name");
        validator.assertHasError(user, "login", Size.class);
    }

    @Test
    public void nameValid() {
        User user = new User("ValidLogin", "Name");
        validator.assertIsValid(user);
    }

    @Test
    public void nameBlankError() {
        User user = new User("ValidLogin", "");
        validator.assertHasError(user, "name", NotBlank.class);
    }
}
