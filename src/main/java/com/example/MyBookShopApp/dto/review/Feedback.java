package com.example.MyBookShopApp.dto.review;

import com.example.MyBookShopApp.dto.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "reviews_id", referencedColumnName = "id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @JoinColumn(name = "date")
    private Date date;

    @JoinColumn(name = "rating")
    private int rating;
}
