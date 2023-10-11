package be.he2b.quizz.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionSiteTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWelcomePage() throws Exception {
        mockMvc.perform(get("/")) // L’url à tester
                .andExpect(status().isOk()) // La page est retournée
                .andExpect(view().name("home")) // Générée à partir du template welcome
                // Elle contient le texte attendu
                .andExpect(content().string(Matchers.containsString("Traversant une dizaine de pays, le Danube est le plus long fleuve dEurope"))); 
    }
}
