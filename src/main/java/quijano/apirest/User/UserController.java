package quijano.apirest.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;
import quijano.apirest.Book.Book;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    
    @GetMapping
    public String currentUserName(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails.getUsername();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/books")
    public Page<Book> getUserBooks(@AuthenticationPrincipal UserDetails userDetails, @PageableDefault(size = 5/* , sort = {"id"}, direction = Sort.Direction.DESC */) Pageable pageable){
        System.out.println(pageable);
        return userService.getUserBooks(userDetails.getUsername(), pageable);
    }
}
