package quijano.apirest.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import quijano.apirest.UserBook.UserBook;

public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(String title);
    Long deleteByTitle(String title);
    Page<Book> findByUserBooks(UserBook userBook, Pageable pageable);
}
