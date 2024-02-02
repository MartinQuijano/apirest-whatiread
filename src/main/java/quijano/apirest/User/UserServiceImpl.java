package quijano.apirest.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import quijano.apirest.UserBook.UserBookResponse;
import quijano.apirest.UserBook.UserBookService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBookService userBookService;

    @Override
    public Page<UserBookResponse> getUserBooks(String username, Pageable pageable) {
        User user = userRepository.findByUsername(username).orElseThrow();
        Page<UserBookResponse> userBooks = userBookService.getBooksByUser(user, pageable);

        return userBooks;
    }
}

