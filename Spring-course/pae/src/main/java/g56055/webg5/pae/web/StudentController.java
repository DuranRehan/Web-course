package g56055.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g56055.webg5.pae.business.PAE;
import g56055.webg5.pae.model.Student;
import jakarta.validation.Valid;

@Controller
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    PAE PAE;

    @GetMapping("/students")
    public String students(Model model) {
        //PAE.queryRequestTest();
        model.addAttribute("allstudents", PAE.getStudent());
        model.addAttribute("student", new Student());
        return "student";
    }

    @GetMapping("/student/detail")
    public String details_course(@RequestParam int id, Model model) {
        model.addAttribute("student", PAE.getStudent(id));
        return "details_student";
    }

    @PostMapping("/students")
    public String add_course(@Valid Student student, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("allstudents", PAE.getStudent());
            return "student";
        }
        System.out.println(errors.getErrorCount());
        PAE.addStudent(student);
        model.addAttribute("student", new Student());
        return "redirect:/students";
    }

    @PostMapping("/students/detail/add_course_to_student")
    public String addCourseToStudent(@RequestParam int studentId, @RequestParam String courseId, Model model) {
        PAE.registerStudentCourse(studentId, courseId);
        return "redirect:/student/detail?id=" + studentId;
    }
    @PostMapping("/students/filter")
    public String filterStudent(@RequestParam String filter_name, Model model) {
        model.addAttribute("allstudents", PAE.filterStudent(filter_name));
        model.addAttribute("student", new Student());
        return "student";
    }
}
