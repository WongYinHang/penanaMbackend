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
@Table(name = "story_all")
public class story_all {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre_sid")
    private Integer genre_sid;

    @Column(name = "subgenre1")
    private Integer subgenre1;

    @Column(name = "subgenre2")
    private Integer subgenre2;

    @Column(name = "language_sid")
    private Integer language_sid;

    @Column(name = "country_sid")
    private Integer country_sid;

    @Column(name = "total_chapter")
    private Integer total_chapter;

    @Column(name = "total_draft")
    private Integer total_draft;

    @Column(name = "total_word_count")
    private Integer total_word_count;

    @Column(name = "total_writer_count")
    private Integer total_writer_count;

    @Column(name = "bookmark_count")
    private Integer bookmark_count;

    @Column(name = "book_cover")
    private String book_cover;

    @Column(name = "rating")
    private String rating;

    @Column(name = "cont_rating")
    private Integer cont_rating;

    @Column(name = "completed")
    private Integer completed;

    @Column(name = "popularity")
    private Integer popularity;

    @Column(name = "featured")
    private Integer featured;

    @Column(name = "report")
    private String report;

    @Column(name = "paid_book")
    private Integer paid_book;

    @Column(name = "subscription_lock")
    private Integer subscription_lock;

    @Column(name = "preview")
    private Integer preview;

    @Column(name = "currency")
    private String currency;

    @Column(name = "pay_entirebook")
    private Integer pay_entirebook;

    @Column(name = "price")
    private Integer price;

    @Column(name = "price_original")
    private Integer price_original;

    @Column(name = "pay_perchapter")
    private Integer pay_perchapter;

    @Column(name = "coin_perchapter")
    private Integer coin_perchapter;

    @Column(name = "allows_sponsors")
    private Integer allows_sponsors;

    @Column(name = "allows_suggestions")
    private Integer allows_suggestions;

    @Column(name = "allows_download")
    private Integer allows_download;

    @Column(name = "allows_upload_file")
    private Integer allows_upload_file;

    @Column(name = "collaborative")
    private Integer collaborative;

    @Column(name = "allows_betareader")
    private Integer allows_betareader;

    @Column(name = "allows_ideacon")
    private Integer allows_ideacon;

    @Column(name = "allows_cowriter")
    private Integer allows_cowriter;

    @Column(name = "max_writer")
    private Integer max_writer;

    @Column(name = "story_type")
    private String story_type;

    @Column(name = "contest_type")
    private Integer contest_type;

    @Column(name = "bounty_mode")
    private Integer bounty_mode;

    @Column(name = "private_story")
    private Integer private_story;

    @Column(name = "show_chapter_image")
    private Integer show_chapter_image;

    @Column(name = "society_id")
    private Integer society_id;

    @Column(name = "ranked_by_creator")
    private Integer ranked_by_creator;

    @Column(name = "ranked")
    private Integer ranked;

    @Column(name = "next_release_date")
    private Date next_release_date;

    @Column(name = "modified_by")
    private Integer modified_by;

    @Column(name = "modify_time")
    private Date modify_time;

    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "created_by")
    private Integer created_by;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "end_time")
    private Date end_time;

    @Column(name = "status")
    private String status;

    @Column(name = "genresid")
    private Integer genresid;
}
