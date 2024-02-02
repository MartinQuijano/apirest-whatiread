package quijano.apirest.UserBook;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserBookResponse {
    private String title;
    private LocalDateTime date;
}
