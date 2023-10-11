package webg.g56055.HelloJPA;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Hello implements CommandLineRunner {
    @Autowired
    private UserDB userDB;

    @Override
    public void run(String... args) {
        log.info(userDB.findAll().toString());
    }
}
