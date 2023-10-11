package webg6.revision.g56055.projet_scrum;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import webg6.revision.g56055.projet_scrum.model.Project;
import webg6.revision.g56055.projet_scrum.model.Sprint;

@SpringBootTest
public class ProjectEntityTest {

    @Autowired
    private BeanValidationUtil<Project> validator;

    @Test
    void checkProjectIsValid() {
        List<Sprint> sprints = List.of(new Sprint());
        Project project = new Project("ValidProject", true, sprints);
        validator.assertIsValid(project);
    }
}
