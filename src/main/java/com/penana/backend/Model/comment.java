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
@Table(name = "comment")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "parent_id")
    private Integer parent_id;

    @Column(name = "story_id")
    private Integer story_id;

    @Column(name = "chapter")
    private Integer chapter;

    @Column(name = "chapter_id")
    private Integer chapter_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "featured")
    private Integer featured;

    @Column(name = "transaction_id")
    private Integer transaction_id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "use_coins")
    private Integer use_coins;

    @Column(name = "post_time")
    private Date post_time;

    @Column(name = "modify_time")
    private Date modify_time;

    @Column(name = "modified_by")
    private Integer modified_by;

    @Column(name = "STATUS")
    private String STATUS;
}
