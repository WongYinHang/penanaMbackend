package com.penana.backend.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "post_comment")
public class post_comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "post_id")
    private Integer post_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "content")
    private String content;

    @Column(name = "post_time")
    private Date post_time;

    @Column(name = "post_img")
    private String post_img;

}
