package com.sda.traiangradinaru.webshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String login;


    private String email;


    @Column
    private String creationDate;
}
