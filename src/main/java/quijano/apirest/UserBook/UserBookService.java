package quijano.apirest.UserBook;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import quijano.apirest.User.User;

public interface UserBookService {
    
    public Page<UserBookResponse> getBooksByUser(User user, Pageable pageable);

}
