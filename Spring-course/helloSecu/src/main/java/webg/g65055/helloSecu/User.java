package webg.g65055.helloSecu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user_")
public class User {
    @Id
    private String username;
    private String password;
    private boolean enabled;
}
