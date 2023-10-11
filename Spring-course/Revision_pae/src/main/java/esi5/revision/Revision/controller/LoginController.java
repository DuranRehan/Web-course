package esi5.revision.Revision.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import esi5.revision.Revision.business.PaeService;

@Controller
public class LoginController {
    @Autowired
    PaeService paeService;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/login/details")
    public String loginDetails(Principal principal) {
        if (principal == null) {
            return "login/login";
        }
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/students";
        } else if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
            // check if student exists in database

            int number = principal.getName().matches("(\\d+)") ? Integer.parseInt(principal.getName()) : -1;
            if (number != -1 && paeService.getStudentByUsername(number) == number) {
                return "redirect:/student/detail?id=" + number;
            } else {
                return "redirect:/login";
            }

        }
        return "login/login";

    }
}
