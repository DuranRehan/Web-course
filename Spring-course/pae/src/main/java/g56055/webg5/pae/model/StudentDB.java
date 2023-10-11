package g56055.webg5.pae.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentDB extends CrudRepository<Student, Integer> {

    @Query("SELECT s.name FROM Student s")
    List<String> getAllStudentName();

    @Query("SELECT s.matricule, s.name FROM Student s")
    List<Object[]> getAllStudentMatriculeAndName();

    @Query("SELECT s.name,c.credits FROM Student s JOIN s.courses c")
    List<Object[]> getAllStudentNameAndCourseCredit();

    @Query("SELECT s.name,c.credits FROM Student s JOIN s.courses c WHERE c.credits > :credit")
    List<Object[]> getAllStudentNameAndCourseCreditGreaterThan(int credit);

    List<Student> findByNameContainingIgnoreCase(String name);
}
