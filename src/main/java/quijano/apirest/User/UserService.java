package quijano.apirest.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import quijano.apirest.UserBook.UserBookResponse;

public interface UserService {
    
    public Page<UserBookResponse> getUserBooks(String username, Pageable pageable);
}
