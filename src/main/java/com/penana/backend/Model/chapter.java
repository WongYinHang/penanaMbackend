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
@Table(name = "chapter")
public class chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "story_id")
    private Integer story_id;

    @Column(name = "chapter")
    private Integer chapter;

    @Column(name = "name")
    private String name;

    @Column(name = "chapter_pic")
    private String chapter_pic;

    @Column(name = "word_count")
    private String word_count;

    @Column(name = "main_chapter_id")
    private Integer main_chapter_id;

    @Column(name = "video_url")
    private String video_url;

    @Column(name = "modified_by")
    private Integer modified_by;

    @Column(name = "modify_time")
    private Date modify_time;

    @Column(name = "created_by")
    private Integer created_by;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "scheduled_time")
    private Date scheduled_time;

    @Column(name = "publish_time")
    private Date publish_time;

    @Column(name = "status")
    private String status;

    @Column(name = "paid_content")
    private Integer paid_content;

    @Column(name = "tier")
    private Integer tier;

    @Column(name = "price")
    private Integer price;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "bounty_awarded")
    private Integer bounty_awarded;

}
