package quijano.apirest.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import quijano.apirest.User.User;
import quijano.apirest.User.UserRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book createBook(Book book, String username){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.getBooks().add(book);
            userRepository.save(user);
        }

        return bookRepository.save(book);
    }

    public Long deleteBook(Book book, String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        System.out.println("Deleting book with title: " + book.title);
        Book bookToDelete = bookRepository.findByTitle(book.title);
        System.out.println("Deleting book: " + bookToDelete);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.getBooks().remove(bookToDelete);
            userRepository.save(user);
        }

        return bookRepository.deleteByTitle(book.title);
    }
}
