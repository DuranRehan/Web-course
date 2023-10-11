package g56055.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.Errors;

import g56055.webg5.pae.business.PAE;
import g56055.webg5.pae.model.Course;
import jakarta.validation.Valid;

@Controller
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    PAE PAE;

    @GetMapping("/courses")
    public String courses(Model model) {
       // PAE.RequestDerived();
        model.addAttribute("allcourses", PAE.getCourse());
        model.addAttribute("course", new Course());
        return "courses";
    }

    @GetMapping("/courses/detail")
    public String details_course(@RequestParam String id, Model model) {
        model.addAttribute("course", PAE.getCourse(id));
        return "details_course";
    }

    @PostMapping("/courses")
    public String add_course(@Valid Course course, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("allcourses", PAE.getCourse());
            return "courses";
        }
        System.out.println(errors.getErrorCount());
        PAE.addCourse(course);
        model.addAttribute("course", new Course());
        return "redirect:/courses";
    }
    @PostMapping("/courses/detail/add_student_to_course")
    public String add_studentToCourse(@RequestParam String courseId, @RequestParam int studentId, Model model) {
        PAE.registerStudentCourse(studentId,courseId);
        return "redirect:/courses/detail?id=" + courseId;
    }

    @GetMapping("/courses/mono")
    public String mono_course(Model model) {
        return "courses_vuejs";
    }

}
