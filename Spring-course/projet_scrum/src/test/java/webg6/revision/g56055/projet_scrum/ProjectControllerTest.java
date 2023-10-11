package webg6.revision.g56055.projet_scrum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {
    // navigateur virtuel
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIfProjectShow() throws Exception {
        mockMvc.perform(get("/project")) // GET /project
                .andExpect(status().isOk()) // HTTP 200
                .andExpect(view().name("project"))
                .andExpect(model().attributeExists("projects"))
                .andExpect(model().attributeExists("project"))
                .andExpect(content().string(Matchers.containsString("Project")) // <h1>Project</h1>

                );
    }

}
