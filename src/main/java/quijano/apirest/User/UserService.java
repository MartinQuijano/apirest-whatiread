package quijano.apirest.User;

import java.util.Set;

import quijano.apirest.Book.Book;

public interface UserService {
    
    public Set<Book> getUserBooks(String username);
}
