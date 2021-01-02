package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(unique=true)
    private String username;
    private String nom;
    private String prenom;
    private String password;
    private Date birthday;
    private String description;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="friend",
    joinColumns=@JoinColumn(name="person_id"),
    inverseJoinColumns=@JoinColumn(name="friend_id")
    )
    private List<UserEntity> friends;

    @JsonIgnore
    @ManyToMany()
    @JoinTable(name="friend",
    joinColumns=@JoinColumn(name="friend_id"),
    inverseJoinColumns=@JoinColumn(name="person_id")
    )
    private List<UserEntity> friendOf;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="request",
    joinColumns=@JoinColumn(name="requested_id"),
    inverseJoinColumns=@JoinColumn(name="requester_id")
    )
    private List<UserEntity> requestFrom;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="request",
    joinColumns=@JoinColumn(name="requester_id"),
    inverseJoinColumns=@JoinColumn(name="requested_id")
    )
    private List<UserEntity> requestTo;


    public UserEntity(){}

}
