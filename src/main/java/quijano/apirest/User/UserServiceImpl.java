package quijano.apirest.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import quijano.apirest.Book.Book;
import quijano.apirest.Book.BookRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getUserBooks(String username, Pageable pageable) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return bookRepository.findByUsers(user, pageable);
    }
}
