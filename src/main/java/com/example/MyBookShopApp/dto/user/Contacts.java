package com.example.MyBookShopApp.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "users_contact")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @JoinColumn(name = "approved")
    private int approved;

    @JoinColumn(name = "code")
    private String code;

    @JoinColumn(name = "code_trials")
    private int codeTrials;

    @JoinColumn(name = "code_time")
    private Date codeTime;

    @JoinColumn(name = "contact")
    private String contact;
}
