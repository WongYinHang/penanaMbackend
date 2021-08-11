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
@Table(name = "acitvity")
public class acitvity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "owner_type")
    private int owner_type;

    @Column(name = "owner_id")
    private int owner_id;

    @Column(name = "subject_type")
    private int subject_type;

    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "activity_type")
    private int activity_type;

    @Column(name = "object_type")
    private int object_type;

    @Column(name = "object_id")
    private int object_id;

    @Column(name = "object_id2")
    private int object_id2;

    @Column(name = "object_id3")
    private int object_id3;

    @Column(name = "like_count")
    private int like_count;

    @Column(name = "source_id")
    private int source_id;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "show_on_homepage")
    private int show_on_homepage;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "status")
    private String status;

    @Column(name = "modify_time")
    private Date modify_time;

}
