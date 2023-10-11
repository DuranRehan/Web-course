package webg5.hellorest;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hellojson")
public class HelloRestJSON {

    @GetMapping
    public Info hello() {
        return new Info("Hello, World!", new Date());
    }

}
