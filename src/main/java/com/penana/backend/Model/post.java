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
@Table(name = "post")
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "post_id")
    private Integer post_id;

    @Column(name = "parent_id")
    private Integer parent_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "post_time")
    private Date post_time;

}
