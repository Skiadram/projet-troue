package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post")
public class PostEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private String text;
    private int user_id;
    private boolean private_post;

    public PostEntity(){}

}
