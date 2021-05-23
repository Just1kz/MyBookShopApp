package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.dto.books.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "authors")
public class Author implements Comparable<Author>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "first_name")
    private String firstName;

    @JoinColumn(name = "last_name")
    private String lastName;

    @JoinColumn(name = "description")
    private String description;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName)
                && Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public int compareTo(Author o) {
        int rsl = firstName.compareTo(o.firstName);
        return rsl == 0 ? lastName.compareTo(o.lastName) : rsl;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }
}
