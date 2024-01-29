package quijano.apirest.UserBook;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quijano.apirest.User.User;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long>{
    UserBook findByUserIdAndBookTitle(Long id, String bookTitle);
    Page<UserBook> findByUser(User user, Pageable pageable);
}
