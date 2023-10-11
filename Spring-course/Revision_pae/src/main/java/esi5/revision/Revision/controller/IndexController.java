package esi5.revision.Revision.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import esi5.revision.Revision.business.PaeService;
import esi5.revision.Revision.model.Section;
import esi5.revision.Revision.model.Student;

@Controller
public class IndexController {
    @Autowired
    PaeService paeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", paeService.getAllStudents());
        model.addAttribute("student", new Student());
        return "students";

    }

    @GetMapping("/student/detail")
    public String studentDetail(Model model ,Principal principal, @RequestParam int id) {
        if (principal == null) {
            return "login/login";
        }
        int number = principal.getName().matches("(\\d+)") ? Integer.parseInt(principal.getName()) : -1;
        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_STUDENT")) && number != -1 && id != number){
            id = number;
        }
        model.addAttribute("student", paeService.getStudentById(id));
        model.addAttribute("annualProg", paeService.getAnnualProgramByStudentId(id));
        return "details_student";
    }


    @PostMapping("/students")
    public String getStudentsListWith(Model model, @RequestParam Section section, @RequestParam int bloc,
            @RequestParam int number, @RequestParam String name) {
        List<Student> students = (List<Student>) paeService.getAllStudentsWithCriteria(number, name, bloc, section);
        model.addAttribute("students",students);
        model.addAttribute("student", new Student());
        return "students";

    }
}
