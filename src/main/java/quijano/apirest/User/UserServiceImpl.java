package quijano.apirest.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import quijano.apirest.Book.Book;
import quijano.apirest.UserBook.UserBookService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBookService userBookService;

    @Override
    public Page<Book> getUserBooks(String username, Pageable pageable) {
        User user = userRepository.findByUsername(username).orElseThrow();
        Page<Book> userBooks = userBookService.getBooksByUser(user, pageable);

        return userBooks;
    }
}

