package com.example.MyBookShopApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@ToString
public class Book implements Comparable<Book>{

    private int id;
    private String author;
    private String title;
    private String priceOld;
    private String price;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(author, book.author)
                && Objects.equals(title, book.title)
                && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, price);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }
}
