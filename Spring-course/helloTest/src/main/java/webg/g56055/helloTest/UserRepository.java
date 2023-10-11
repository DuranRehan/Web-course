package webg.g56055.helloTest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByName(String name);

    @Query("select u FROM User u WHERE length(u.login)>12")
    public List<User> findByLongLogin();
}
