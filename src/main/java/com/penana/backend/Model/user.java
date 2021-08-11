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
@Table(name = "user")
public class user {

    public user(Integer id, String Username, String Profile_picture) {
        this.id = id;
        this.username = Username;
        this.profile_picture = Profile_picture;
    };

    public user(Integer id, String Username, String Profile_picture, Integer Coin_balance) {
        this.id = id;
        this.username = Username;
        this.profile_picture = Profile_picture;
        this.coin_balance = Coin_balance;
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "display_name")
    private String display_name;

    @Column(name = "story_count")
    private Integer story_count;

    @Column(name = "follower_count")
    private Integer follower_count;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "ip_address")
    private String ip_address;

    @Column(name = "profile_picture")
    private String profile_picture;

    @Column(name = "activation_code")
    private String activation_code;

    @Column(name = "pw_reset_code")
    private String pw_reset_code;

    @Column(name = "cookie_key")
    private String cookie_key;

    @Column(name = "premium_level")
    private Integer premium_level;

    @Column(name = "premium_expire")
    private Date premium_expire;

    @Column(name = "facebook_id")
    private Integer facebook_id;

    @Column(name = "language_sid")
    private Integer language_sid;

    @Column(name = "country_sid")
    private Integer country_sid;

    @Column(name = "story_language")
    private String story_language;

    @Column(name = "story_max_rating")
    private String story_max_rating;

    @Column(name = "reg_site")
    private String reg_site;

    @Column(name = "coin_balance")
    private Integer coin_balance;

    @Column(name = "modified_by")
    private String modified_by;

    @Column(name = "modify_time")
    private Date modify_time;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "mark_deleted")
    private String mark_deleted;

    @Column(name = "last_login")
    private Date last_login;

    @Column(name = "show_subscribers")
    private Integer show_subscribers;

    @Column(name = "stripe_id")
    private Integer stripe_id;

    @Column(name = "role")
    private String role;
}

// public class user {

// public user(Integer id, String Username, String Profile_picture) {
// this.id = id;
// this.username = Username;
// this.profile_picture = Profile_picture;
// };

// public user(Integer id, String Username, String Profile_picture, Integer
// Coin_balance) {
// this.id = id;
// this.username = Username;
// this.profile_picture = Profile_picture;
// this.coin_balance = Coin_balance;
// };

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "id")
// private Integer id;

// @Column(name = "username", columnDefinition = "varchar(25) COLLATE
// utf8_unicode_ci NOT NULL DEFAULT ")
// private String username;

// @Column(name = "display_name", columnDefinition = "varchar(25) COLLATE
// utf8_unicode_ci NOT NULL DEFAULT''")
// private String display_name;

// @Column(name = "story_count", columnDefinition = "int(11) UNSIGNED DEFAULT
// 0")
// private Integer story_count;

// @Column(name = "follower_count", columnDefinition = "int(11) UNSIGNED DEFAULT
// 0")
// private Integer follower_count;

// @Column(name = "password", columnDefinition = "varchar(60) COLLATE
// utf8_unicode_ci DEFAULT NULL")
// private String password;

// @Column(name = "email", columnDefinition = "varchar(250) COLLATE
// utf8_unicode_ci NOT NULL'")
// private String email;

// @Column(name = "ip_address", columnDefinition = "varchar(39) COLLATE
// utf8_unicode_ci DEFAULT ''")
// private String ip_address;

// @Column(name = "profile_picture", columnDefinition = "varchar(60) COLLATE
// utf8_unicode_ci DEFAULT NULL")
// private String profile_picture;

// @Column(name = "activation_code", columnDefinition = "varchar(60) COLLATE
// utf8_unicode_ci DEFAULT NULL")
// private String activation_code;

// @Column(name = "pw_reset_code", columnDefinition = "varchar(60) COLLATE
// utf8_unicode_ci DEFAULT NULL")
// private String pw_reset_code;

// @Column(name = "cookie_key", columnDefinition = "varchar(60) COLLATE
// utf8_unicode_ci DEFAULT NULL")
// private String cookie_key;

// @Column(name = "premium_level", columnDefinition = "smallint(5) UNSIGNED NOT
// NULL DEFAULT 0")
// private Integer premium_level;

// @Column(name = "premium_expire", columnDefinition = "timestamp NOT NULL
// DEFAULT '0000-00-00 00:00:00'")
// private Date premium_expire;

// @Column(name = "facebook_id", columnDefinition = "bigint(20) UNSIGNED DEFAULT
// NULL")
// private Integer facebook_id;

// @Column(name = "language_sid", columnDefinition = "smallint(5) UNSIGNED
// DEFAULT NULL")
// private Integer language_sid;

// @Column(name = "country_sid", columnDefinition = "smallint(5) UNSIGNED
// DEFAULT NULL")
// private Integer country_sid;

// @Column(name = "story_language", columnDefinition = "varchar(128) COLLATE
// utf8_unicode_ci DEFAULT NULL")
// private String story_language;

// @Column(name = "story_max_rating", columnDefinition = "varchar(2) COLLATE
// utf8_unicode_ci DEFAULT '13'")
// private String story_max_rating;

// @Column(name = "reg_site", columnDefinition = "varchar(10) COLLATE
// utf8_unicode_ci DEFAULT 'web'")
// private String reg_site;

// @Column(name = "coin_balance", columnDefinition = "int(11) NOT NULL DEFAULT
// 0")
// private Integer coin_balance;

// @Column(name = "modified_by", columnDefinition = "varchar(25) COLLATE
// utf8_unicode_ci NOT NULL DEFAULT ''")
// private String modified_by;

// @Column(name = "modify_time", columnDefinition = "timestamp NOT NULL DEFAULT
// current_timestamp() ON UPDATE current_timestamp()")
// private Date modify_time;

// @Column(name = "created_by", columnDefinition = "varchar(25) COLLATE
// utf8_unicode_ci NOT NULL DEFAULT ''")
// private String created_by;

// @Column(name = "create_time", columnDefinition = "timestamp NOT NULL DEFAULT
// '0000-00-00 00:00:00'")
// private Date create_time;

// @Column(name = "mark_deleted", columnDefinition = "varchar(1) COLLATE
// utf8_unicode_ci DEFAULT 'N'")
// private String mark_deleted;

// @Column(name = "last_login", columnDefinition = "timestamp NOT NULL DEFAULT
// '0000-00-00 00:00:00'")
// private Date last_login;

// @Column(name = "show_subscribers", columnDefinition = "int(11) UNSIGNED
// DEFAULT 0")
// private Integer show_subscribers;

// @Column(name = "stripe_id", columnDefinition = "int(11) UNSIGNED DEFAULT
// NULL")
// private Integer stripe_id;

// @Column(name = "role", columnDefinition = "varchar(10)COLLATE utf8_unicode_ci
// DEFAULT ''")
// private String role;
// }