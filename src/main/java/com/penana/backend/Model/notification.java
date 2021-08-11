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
@Table(name = "notification")
public class notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "type")
    private int type;

    @Column(name = "source_id")
    private int source_id;

    @Column(name = "source_id2")
    private int source_id2;

    @Column(name = "source_id3")
    private int source_id3;

    @Column(name = "source_id4")
    private int source_id4;

    @Column(name = "status")
    private String status;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "modify_time")
    private Date modify_time;
}
