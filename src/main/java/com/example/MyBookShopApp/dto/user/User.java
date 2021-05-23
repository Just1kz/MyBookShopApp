package com.example.MyBookShopApp.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "hash")
    private String hash;

    @JoinColumn(name = "reg_time")
    private Date regTime;

    @JoinColumn(name = "balance")
    private int balance;

    @JoinColumn(name = "name")
    private String name;
}
