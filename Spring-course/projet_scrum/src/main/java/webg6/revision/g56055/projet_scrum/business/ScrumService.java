package webg6.revision.g56055.projet_scrum.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webg6.revision.g56055.projet_scrum.model.Project;
import webg6.revision.g56055.projet_scrum.model.ProjectRepository;

@Service
public class ScrumService {
    @Autowired
    ProjectRepository projectRepository;
    
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Object[]> getProjectsActiveByPattern(String pattern) {
        return projectRepository.findProjectsActiveByPattern(pattern);
    }
}
