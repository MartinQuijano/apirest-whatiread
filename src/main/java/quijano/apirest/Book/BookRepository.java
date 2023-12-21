package quijano.apirest.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import quijano.apirest.User.User;

public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(String title);
    Long deleteByTitle(String title);
    Page<Book> findByUsers(User user, Pageable pageable);
}
