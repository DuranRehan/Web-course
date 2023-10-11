package g56055.webg5.pae.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseDB extends CrudRepository<Course, String> {

    List<Course> findByCreditsGreaterThanEqual(int credits);
    List<Course> findByIdLike(String id);
}
