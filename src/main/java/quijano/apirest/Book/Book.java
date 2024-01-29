package quijano.apirest.Book;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quijano.apirest.UserBook.UserBook;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @NotBlank
    String title;

    @OneToMany(mappedBy = "book", cascade = {CascadeType.ALL})
    Set<UserBook> userBooks = new HashSet<>();
    
    public Set<UserBook> getUserBooks() {
        return userBooks;
    }

    public void addUserBook(UserBook userBook){
        userBooks.add(userBook);
    }

    @Override
    public String toString(){
        return "Book [id=" + id + ", title=" + title + "]";
    }
}
