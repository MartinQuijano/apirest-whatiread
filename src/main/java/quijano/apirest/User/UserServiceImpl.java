package quijano.apirest.User;

import java.util.Optional;
import java.util.Set;

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

    public Long deleteBook(Book book, String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            Set<Book> userBooks = user.getBooks();
            System.out.println(userBooks);
            if (userBooks.contains(book)) {
                userBooks.remove(book);
                user.setBooks(userBooks);
                userRepository.save(user);
            }
        }

        /* return bookRepository.deleteByTitle(book.title); */
        return 1L;
        }
    }

