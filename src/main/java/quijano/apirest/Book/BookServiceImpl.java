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

            Book existingBook = bookRepository.findByTitle(book.title);
            if(existingBook != null){
                System.out.println("The book already exists!");
                user.addBook(existingBook);
                return existingBook;
            } else {
                user.addBook(book);
            }
            
        }
        
        /* return bookRepository.save(book); */
        return null;
    }

    public Long deleteBook(Book book, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        user.removeBook(book.title);
        userRepository.save(user);
        return 1L;
    }
}
