package com.sda.traiangradinaru.webshop.entities;

import javax.persistence.*;

@Entity
//@Table(uniqueConstraints = @UniqueConstraint())
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
