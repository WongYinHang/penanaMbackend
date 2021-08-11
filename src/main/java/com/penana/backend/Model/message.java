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
@Table(name = "message")
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_to")
    private int user_to;

    @Column(name = "user_from")
    private int user_from;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @Column(name = "message_count")
    private int message_count;

    @Column(name = "content_id")
    private int content_id;

    @Column(name = "status")
    private String status;

    @Column(name = "sent_date")
    private Date sent_date;

    @Column(name = "modify_time")
    private Date modify_time;
}
