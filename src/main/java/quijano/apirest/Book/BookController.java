package quijano.apirest.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quijano.apirest.User.AddBookRequest;

@RestController
@RequestMapping(value = "/api/v1/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public Book save(@RequestBody AddBookRequest bookRequest, @AuthenticationPrincipal UserDetails userDetails){
         return bookService.createBook(bookRequest.getTitle(), bookRequest.getDate(), userDetails.getUsername());
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping
    public Long delete(@RequestBody Book book, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println(book);
        return bookService.deleteBook(book, userDetails.getUsername());
    }
}
