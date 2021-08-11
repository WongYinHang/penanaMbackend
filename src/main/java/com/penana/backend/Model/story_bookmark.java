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
@Table(name = "story_bookmark")
public class story_bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "story_id")
    private Integer story_id;

    @Column(name = "chapter")
    private Integer chapter;

    @Column(name = "percent")
    private Integer percent;

    @Column(name = "pinned")
    private Integer pinned;

    @Column(name = "notification")
    private Integer notification;

    @Column(name = "modified_by")
    private String modified_by;

    @Column(name = "modify_time")
    private Date modify_time;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "last_visit")
    private Date last_visit;

    @Column(name = "mark_deleted")
    private String mark_deleted;
}
