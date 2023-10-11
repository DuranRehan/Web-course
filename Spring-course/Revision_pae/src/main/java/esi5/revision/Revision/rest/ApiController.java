package esi5.revision.Revision.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import esi5.revision.Revision.business.PaeService;
import esi5.revision.Revision.model.AnnualProgram;
import esi5.revision.Revision.model.Section;
import esi5.revision.Revision.model.Student;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pae/")
public class ApiController {
    @Autowired
    private PaeService paeService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return (List<Student>) paeService.getAllStudents();
    }

    @GetMapping("/students/criteria")
    public List<Student> getAllStudentsWithCriteria(@RequestParam(required = false,defaultValue = "0") int number,
            @RequestParam(required = false) String name, @RequestParam(required = false,defaultValue = "0") int bloc,
            @RequestParam(required = false) Section section) {
        return (List<Student>) paeService.getAllStudentsWithCriteria(number, name, bloc, section);
    }

    @GetMapping("/students/detail/{id}")
    public AnnualProgram getStudentById(@PathVariable int id) {
        return paeService.getAnnualProgramByStudentId(id);
    }
}
