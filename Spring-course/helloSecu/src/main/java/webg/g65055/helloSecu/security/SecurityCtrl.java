package webg.g65055.helloSecu.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityCtrl {
    @GetMapping("/login")
    public String login() {
        return "security_form/login";
    }
}
