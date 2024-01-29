package quijano.apirest.UserBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import quijano.apirest.Book.Book;
import quijano.apirest.User.User;

@Service
public class UserBookServiceImpl implements UserBookService{
    @Autowired
    private UserBookRepository userBookRepository;

    public Page<Book> getBooksByUser(User user, Pageable pageable) {
        return userBookRepository.findByUser(user, pageable)
                                  .map(UserBook::getBook);
    }

}
