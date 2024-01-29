package quijano.apirest.Book;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import quijano.apirest.User.User;
import quijano.apirest.User.UserRepository;
import quijano.apirest.UserBook.UserBook;
import quijano.apirest.UserBook.UserBookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBookRepository userBookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book createBook(String bookTitle, LocalDateTime date, String username){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            Book existingBook = bookRepository.findByTitle(bookTitle);
            if(existingBook != null){
                UserBook userBook = new UserBook(user, existingBook, date);
                userBookRepository.save(userBook);
                user.addUserBook(userBook);
            } else {
                Book book = new Book();
                book.setTitle(bookTitle);
                bookRepository.save(book);
                UserBook userBook = new UserBook(user, book, date);
                userBookRepository.save(userBook);
                user.addUserBook(userBook);
            }         
        }
        return null;
    }

    public Long deleteBook(Book book, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        UserBook userBook = userBookRepository.findByUserIdAndBookTitle(user.getId(), book.getTitle());
        if(userBook != null){
            userBookRepository.delete(userBook);
        }
        return 1L;
    }
}
