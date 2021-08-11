package com.penana.backend.Model;

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
@Table(name = "chapter_count")
public class chapter_count {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "chapter_id")
    private int chapter_id;

    @Column(name = "view_count")
    private int view_count;

    @Column(name = "like_count")
    private int like_count;

    @Column(name = "comment_count")
    private int comment_count;
}
