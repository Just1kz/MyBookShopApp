package com.example.MyBookShopApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "genres_id", referencedColumnName = "id")
    private Genre parentId;

    @JoinColumn(name = "slag")
    private String slag;

    @JoinColumn(name = "name")
    private String name;
}
