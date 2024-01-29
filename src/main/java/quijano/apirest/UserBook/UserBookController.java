package quijano.apirest.UserBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quijano.apirest.Book.Book;
import quijano.apirest.User.User;
import quijano.apirest.User.UserRepository;

@RestController
@RequestMapping("/api/books")
public class UserBookController {
    @Autowired
    private UserBookService userBookService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<Page<Book>> getBooksByUser(
            @AuthenticationPrincipal UserDetails userDetails,
            @PageableDefault(size = 2/* , sort = {"id"}, direction = Sort.Direction.DESC */) Pageable pageable) {

        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        Page<Book> userBooks = userBookService.getBooksByUser(user, pageable);

        return new ResponseEntity<>(userBooks, HttpStatus.OK);
    }
}
