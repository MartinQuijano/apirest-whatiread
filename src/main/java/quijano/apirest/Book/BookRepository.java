package quijano.apirest.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(String title);
    Long deleteByTitle(String title);
}
