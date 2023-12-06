package quijano.apirest.User;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quijano.apirest.Book.Book;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<Book> getUserBooks(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return user.getBooks();
    }
}
