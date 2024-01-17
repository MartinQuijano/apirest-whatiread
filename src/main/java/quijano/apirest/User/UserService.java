package quijano.apirest.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import quijano.apirest.Book.Book;

public interface UserService {
    
    public Page<Book> getUserBooks(String username, Pageable pageable);
    public Long deleteBook(Book book, String username);
}
