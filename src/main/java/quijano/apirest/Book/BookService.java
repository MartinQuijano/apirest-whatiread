package quijano.apirest.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface BookService {
    public Book createBook(String bookTitle, LocalDateTime date, String username);

    public List<Book> getAllBooks();

    public Long deleteBook(Book book, String username);
}
