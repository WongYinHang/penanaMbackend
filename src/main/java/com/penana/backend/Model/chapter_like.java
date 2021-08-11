package com.penana.backend.Model;

import java.sql.Date;

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
@Table(name = "chapter_like")
public class chapter_like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "chapter_id")
    private int chapter_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "modified_by")
    private String modified_by;

    @Column(name = "modify_time")
    private Date comment_count;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "mark_deleted")
    private String mark_deleted;

}
