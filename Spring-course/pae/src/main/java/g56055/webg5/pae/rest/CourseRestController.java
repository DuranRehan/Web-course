package g56055.webg5.pae.rest;


import g56055.webg5.pae.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import g56055.webg5.pae.business.PAE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/courses")
public class CourseRestController {
    @Autowired
    PAE pae;

    @GetMapping("/all")
    public Iterable<Course> courses() {
        return pae.getCourse();
    }
    @GetMapping
    public Course course(@RequestParam String id) {
        return pae.getCourse(id);
    }
}
