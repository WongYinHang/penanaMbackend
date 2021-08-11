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
@Table(name = "user_profile")
public class user_profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "biography")
    private int biography;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "country_sid")
    private int country_sid;

    @Column(name = "education_sid")
    private int education_sid;

    @Column(name = "best_desc_sid")
    private int best_desc_sid;

    @Column(name = "best_desc_sid_2")
    private int best_desc_sid_2;

    @Column(name = "best_desc_sid_3")
    private int best_desc_sid_3;

    @Column(name = "modified_by")
    private String modified_by;

    @Column(name = "modify_time")
    private Date modify_time;
}
