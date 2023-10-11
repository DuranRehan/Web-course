package webg.g65055.helloSecu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlleur {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "private";
    }
}
