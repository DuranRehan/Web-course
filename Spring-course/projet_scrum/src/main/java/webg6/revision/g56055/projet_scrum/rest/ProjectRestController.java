package webg6.revision.g56055.projet_scrum.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webg6.revision.g56055.projet_scrum.business.ScrumService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    ScrumService service;

    @GetMapping("/projects_active{pattern}")
    public List<Object[]> getProjectsActive(@RequestParam String  pattern) {
        return service.getProjectsActiveByPattern(pattern);
    }
}
