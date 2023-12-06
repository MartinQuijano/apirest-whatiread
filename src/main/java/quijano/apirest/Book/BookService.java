package quijano.apirest.Book;

import java.util.List;

public interface BookService {
    public Book createBook(Book book, String username);

    public List<Book> getAllBooks();

    public Long deleteBook(Book book, String username);
}
