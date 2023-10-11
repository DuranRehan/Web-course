package webg6.revision.g56055.projet_scrum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webg6.revision.g56055.projet_scrum.business.ScrumService;
import webg6.revision.g56055.projet_scrum.model.Project;

@Controller
public class ProjectController {
    @Autowired
    ScrumService scrumService;

    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("projects", scrumService.getAllProjects());
        model.addAttribute("project", new Project());
        return "project";
    }

    @GetMapping("/project/addStory")
    public String addProject(Model model) {
        model.addAttribute("project", new Project());
        return "addStory";
    }
}
