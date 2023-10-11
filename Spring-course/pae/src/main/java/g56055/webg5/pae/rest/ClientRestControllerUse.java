package g56055.webg5.pae.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import g56055.webg5.pae.model.Course;

public class ClientRestControllerUse {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/courses/all";
        ResponseEntity<Course[]> response = restTemplate.getForEntity(url, Course[].class);
        Course[] courses = response.getBody();
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}