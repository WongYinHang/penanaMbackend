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
@Table(name = "story_tag")
public class story_tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "story_id")
    private int story_id;

    @Column(name = "tag_id")
    private int tag_id;

    @Column(name = "modify_time")
    private Date modify_time;

    @Column(name = "mark_deleted")
    private String mark_deleted;
}
