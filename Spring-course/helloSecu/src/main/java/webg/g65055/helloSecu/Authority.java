package webg.g65055.helloSecu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Authority {
    @Id
    private long id;
    private String username;
    private String authority;
}