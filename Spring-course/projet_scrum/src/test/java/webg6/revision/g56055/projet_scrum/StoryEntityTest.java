package webg6.revision.g56055.projet_scrum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.constraints.Min;
import webg6.revision.g56055.projet_scrum.model.Sprint;
import webg6.revision.g56055.projet_scrum.model.Story;

@SpringBootTest
public class StoryEntityTest {
    @Autowired
    private BeanValidationUtil<Story> validator;

    @Test
    void checkStoryIsValid() {
        Story story = new Story(1, "ValidStory", 1, new Sprint());
        validator.assertIsValid(story);
    }

    @Test 
    void checkEstimateMoreThanZero() {
        Story story = new Story(1, "ValidStory", 0, new Sprint());
        validator.assertHasError(story,"estimate", Min.class);
    }
}
