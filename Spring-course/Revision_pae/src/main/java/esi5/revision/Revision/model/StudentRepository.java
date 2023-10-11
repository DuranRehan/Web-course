package esi5.revision.Revision.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByNumber(int number);

    List<Student> findByNumberOrNameContainingOrSectionOrBloc(int number, String name, Section section, int bloc);
}