package webg5.hellorest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class HelloRest {
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "Inconnu") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") String name) {
        return "Hello," + name + "!";
    }

    @PostMapping("/hello")
    public String helloPost(String name) {
        return "Hello, " + name + " !";
    }
}
