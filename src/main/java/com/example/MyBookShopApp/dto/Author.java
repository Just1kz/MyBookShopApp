package com.example.MyBookShopApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@ToString
public class Author implements Comparable<Author>{

    private int id;
    private String firstName;
    private String lastName;
    private String category;

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
}
