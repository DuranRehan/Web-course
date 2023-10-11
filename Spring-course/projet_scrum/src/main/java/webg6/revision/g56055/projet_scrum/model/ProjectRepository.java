package webg6.revision.g56055.projet_scrum.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, String> {

    @Query("SELECT p.name FROM Project p WHERE p.active = true AND SUBSTRING(p.name, 1, 1) LIKE %:pattern% GROUP BY p.name")
    public List<Object[]> findProjectsActiveByPattern(String pattern);
}
