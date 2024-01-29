package quijano.apirest.User;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AddBookRequest {

    private String title;
    private LocalDateTime date;

}