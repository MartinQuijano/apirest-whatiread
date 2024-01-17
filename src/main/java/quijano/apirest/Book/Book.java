package quijano.apirest.Book;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import quijano.apirest.User.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
@EqualsAndHashCode(exclude="users")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    @NotBlank
    String title;

    LocalDateTime date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "books")
    @JsonIgnore
    Set<User> users = new HashSet<>();

    @Override
    public String toString(){
        return "Book [id=" + id + ", title=" + title + ", date=" + date + "]";
    }
}
