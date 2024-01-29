package quijano.apirest.UserBook;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import quijano.apirest.Book.Book;
import quijano.apirest.User.User;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude="user")
public class UserBook {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH} )
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH} )
    @JoinColumn(name = "book_id")
    Book book;

    LocalDateTime date;

    
    public User getUser() {
        return user;
    }
    
    
    public Book getBook() {
        return book;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public UserBook(User user, Book book, LocalDateTime date){
        this.user = user;
        this.book = book;
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserBook [id=" + id + ",user_id=" + user.getId() + ",book=" + book +",date=" + date + "]";
    }
}
