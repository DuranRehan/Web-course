package webg5.hellorest;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Info {
    private String message;
    private Date date;
}
