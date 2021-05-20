package com.example.MyBookShopApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@ToString
@Entity
@Table(name = "authors")
public class Author implements Comparable<Author>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;

    @OneToMany
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private List<Book> bookList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(first_name, author.first_name)
                && Objects.equals(last_name, author.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name);
    }

    @Override
    public int compareTo(Author o) {
        int rsl = first_name.compareTo(o.first_name);
        return rsl == 0 ? last_name.compareTo(o.last_name) : rsl;
    }
}
