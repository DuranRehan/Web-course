package webg.g56055.HelloJPA;

import org.springframework.data.repository.CrudRepository;

public interface UserDB extends CrudRepository<Users, String> {
    
}
