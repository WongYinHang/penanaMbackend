-- CREATE TABLE `activity` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `owner_type` smallint(5) UNSIGNED DEFAULT NULL,
--   `owner_id` int(11) UNSIGNED DEFAULT NULL,
--   `subject_type` smallint(5) UNSIGNED DEFAULT NULL,
--   `subject_id` int(11) UNSIGNED DEFAULT NULL,
--   `activity_type` smallint(5) UNSIGNED DEFAULT NULL,
--   `object_type` smallint(5) UNSIGNED DEFAULT NULL,
--   `object_id` int(11) UNSIGNED DEFAULT NULL,
--   `object_id2` int(11) UNSIGNED DEFAULT NULL,
--   `object_id3` int(11) UNSIGNED DEFAULT NULL,
--   `like_count` int(11) UNSIGNED DEFAULT 0,
--   `source_id` int(11) UNSIGNED DEFAULT NULL,
--   `created_by` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `show_on_homepage` tinyint(3) DEFAULT 1,
--   `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT 'unread',
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `chapter`


-- CREATE TABLE `chapter` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `story_id` int(11) UNSIGNED DEFAULT NULL,
--   `chapter` smallint(5) UNSIGNED DEFAULT NULL,
--   `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `chapter_pic` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `word_count` mediumint(8) UNSIGNED DEFAULT 0,
--   `main_chapter_id` int(11) UNSIGNED DEFAULT NULL,
--   `video_url` varchar(127) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `modified_by` int(11) UNSIGNED DEFAULT NULL,
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
--   `created_by` int(11) UNSIGNED NOT NULL,
--   `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `scheduled_time` timestamp NULL DEFAULT NULL,
--   `publish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT 'active',
--   `paid_content` tinyint(3) DEFAULT 0,
--   `tier` smallint(5) UNSIGNED NOT NULL DEFAULT 1,
--   `price` int(11) UNSIGNED DEFAULT 0,
--   `ranking` smallint(5) UNSIGNED DEFAULT 0,
--   `bounty_awarded` int(11) UNSIGNED DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `chapter_count`


-- CREATE TABLE `chapter_count` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `chapter_id` int(11) UNSIGNED NOT NULL DEFAULT 0,
--   `view_count` int(11) UNSIGNED DEFAULT 0,
--   `like_count` int(11) UNSIGNED DEFAULT 0,
--   `comment_count` int(11) UNSIGNED DEFAULT 0
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `chapter_like`


-- CREATE TABLE `chapter_like` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `chapter_id` int(11) UNSIGNED DEFAULT NULL,
--   `user_id` int(11) UNSIGNED DEFAULT NULL,
--   `modified_by` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
--   `created_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `mark_deleted` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'N'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `comment`


-- CREATE TABLE `comment` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `parent_id` int(11) UNSIGNED DEFAULT NULL,
--   `story_id` int(11) UNSIGNED DEFAULT NULL,
--   `chapter` smallint(5) UNSIGNED DEFAULT NULL,
--   `chapter_id` int(11) UNSIGNED DEFAULT NULL,
--   `user_id` int(11) UNSIGNED DEFAULT NULL,
--   `comment` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
--   `featured` tinyint(3) DEFAULT 0,
--   `transaction_id` int(11) UNSIGNED DEFAULT NULL,
--   `currency` char(3) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'hkd',
--   `amount` int(11) UNSIGNED DEFAULT NULL,
--   `use_coins` int(11) DEFAULT NULL,
--   `post_time` timestamp NOT NULL DEFAULT current_timestamp(),
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
--   `modified_by` int(11) UNSIGNED DEFAULT NULL,
--   `STATUS` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `content`


-- CREATE TABLE `content` (
--   `chapter_id` int(11) UNSIGNED NOT NULL DEFAULT 0,
--   `content` mediumtext CHARACTER SET utf8mb4 DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `message`


-- CREATE TABLE `message` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `user_to` int(11) UNSIGNED NOT NULL,
--   `user_from` int(11) UNSIGNED NOT NULL,
--   `subject` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
--   `message` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
--   `message_count` int(11) UNSIGNED DEFAULT NULL,
--   `content_id` int(11) UNSIGNED DEFAULT NULL,
--   `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
--   `sent_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `notification`


-- CREATE TABLE `notification` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `user_id` int(11) UNSIGNED NOT NULL,
--   `type` smallint(5) UNSIGNED NOT NULL,
--   `source_id` int(11) NOT NULL,
--   `source_id2` int(11) DEFAULT NULL,
--   `source_id3` int(11) DEFAULT 0,
--   `source_id4` int(11) DEFAULT 0,
--   `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `created_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `story_all`


-- CREATE TABLE `story_all` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `title` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
--   `genre_sid` smallint(5) UNSIGNED DEFAULT 39,
--   `subgenre1` smallint(5) UNSIGNED DEFAULT NULL,
--   `subgenre2` smallint(5) UNSIGNED DEFAULT NULL,
--   `language_sid` smallint(5) UNSIGNED DEFAULT NULL,
--   `country_sid` smallint(5) UNSIGNED DEFAULT NULL,
--   `total_chapter` int(11) UNSIGNED DEFAULT NULL,
--   `total_draft` int(11) UNSIGNED DEFAULT 0,
--   `total_word_count` int(11) UNSIGNED DEFAULT 0,
--   `total_writer_count` int(11) UNSIGNED DEFAULT 1,
--   `bookmark_count` int(11) UNSIGNED DEFAULT 0,
--   `book_cover` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `rating` varchar(2) COLLATE utf8_unicode_ci DEFAULT 'G',
--   `cont_rating` tinyint(3) NOT NULL DEFAULT 0,
--   `completed` tinyint(3) DEFAULT 0,
--   `popularity` int(11) NOT NULL DEFAULT 0,
--   `featured` smallint(5) UNSIGNED DEFAULT 0,
--   `report` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `paid_book` smallint(5) UNSIGNED DEFAULT 0,
--   `subscription_lock` smallint(5) UNSIGNED NOT NULL DEFAULT 0,
--   `preview` mediumint(8) UNSIGNED DEFAULT 100,
--   `currency` char(3) COLLATE utf8_unicode_ci DEFAULT 'hkd',
--   `pay_entirebook` tinyint(3) DEFAULT 0,
--   `price` int(11) UNSIGNED DEFAULT 0,
--   `price_original` int(11) UNSIGNED DEFAULT 0,
--   `pay_perchapter` tinyint(3) DEFAULT 0,
--   `coin_perchapter` int(11) UNSIGNED DEFAULT 0,
--   `allows_sponsors` tinyint(3) DEFAULT 0,
--   `allows_suggestions` tinyint(3) DEFAULT 0,
--   `allows_download` tinyint(3) DEFAULT 1,
--   `allows_upload_file` smallint(5) UNSIGNED DEFAULT 0,
--   `collaborative` tinyint(3) DEFAULT 0,
--   `allows_betareader` tinyint(3) DEFAULT 0,
--   `allows_ideacon` tinyint(3) DEFAULT 0,
--   `allows_cowriter` tinyint(3) DEFAULT 0,
--   `max_writer` tinyint(3) DEFAULT 5,
--   `story_type` char(1) COLLATE utf8_unicode_ci DEFAULT 'S',
--   `contest_type` smallint(5) UNSIGNED DEFAULT 3,
--   `bounty_mode` tinyint(3) DEFAULT 0,
--   `private_story` tinyint(3) DEFAULT 0,
--   `show_chapter_image` tinyint(3) DEFAULT 1,
--   `society_id` int(11) UNSIGNED DEFAULT NULL,
--   `ranked_by_creator` smallint(5) UNSIGNED DEFAULT 0,
--   `ranked` tinyint(3) DEFAULT 0,
--   `next_release_date` date DEFAULT NULL,
--   `modified_by` int(11) UNSIGNED DEFAULT NULL,
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
--   `last_update` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `created_by` int(11) UNSIGNED NOT NULL,
--   `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT 'active'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `story_bookmark`


-- CREATE TABLE `story_bookmark` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `user_id` int(11) UNSIGNED DEFAULT NULL,
--   `story_id` int(11) UNSIGNED DEFAULT NULL,
--   `chapter` smallint(5) UNSIGNED DEFAULT 0,
--   `percent` decimal(4,3) DEFAULT 0.000,
--   `pinned` smallint(5) UNSIGNED DEFAULT 0,
--   `notification` smallint(5) UNSIGNED DEFAULT 1,
--   `modified_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
--   `created_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `last_visit` timestamp NOT NULL DEFAULT current_timestamp(),
--   `mark_deleted` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'N'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `story_tag`


-- CREATE TABLE `story_tag` (
--   `id` int(11) NOT NULL,
--   `story_id` int(11) UNSIGNED NOT NULL,
--   `tag_id` int(11) NOT NULL,
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
--   `mark_deleted` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'N'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `tags`


-- CREATE TABLE `tags` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `tag_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
--   `story_count` int(11) UNSIGNED DEFAULT NULL,
--   `sensitive_word` tinyint(3) DEFAULT 0,
--   `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `user`


-- CREATE TABLE `user` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `username` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `role` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `display_name` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `story_count` int(11) UNSIGNED DEFAULT 0,
--   `follower_count` int(11) UNSIGNED DEFAULT 0,
--   `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
--   `email` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
--   `ip_address` varchar(39) COLLATE utf8_unicode_ci DEFAULT '',
--   `profile_picture` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `activation_code` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `pw_reset_code` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `cookie_key` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `premium_level` smallint(5) UNSIGNED NOT NULL DEFAULT 0,
--   `premium_expire` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `facebook_id` bigint(20) UNSIGNED DEFAULT NULL,
--   `language_sid` smallint(5) UNSIGNED DEFAULT NULL,
--   `country_sid` smallint(5) UNSIGNED DEFAULT NULL,
--   `story_language` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `story_max_rating` varchar(2) COLLATE utf8_unicode_ci DEFAULT '13',
--   `reg_site` varchar(10) COLLATE utf8_unicode_ci DEFAULT 'web',
--   `coin_balance` int(11) NOT NULL DEFAULT 0,
--   `modified_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
--   `created_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
--   `mark_deleted` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'N',
--   `last_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `user_follow`


-- CREATE TABLE `user_follow` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `user_id` int(11) UNSIGNED DEFAULT NULL,
--   `followed_id` int(11) UNSIGNED DEFAULT NULL,
--   `created_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
--   `mark_deleted` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'N'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------------------------


-- 資料表結構 `user_profile`


-- CREATE TABLE `user_profile` (
--   `user_id` int(11) UNSIGNED NOT NULL,
--   `gender` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `biography` text COLLATE utf8_unicode_ci DEFAULT NULL,
--   `date_of_birth` date DEFAULT NULL,
--   `country_sid` smallint(5) UNSIGNED DEFAULT NULL,
--   `education_sid` tinyint(3) DEFAULT NULL,
--   `best_desc_sid` tinyint(3) DEFAULT NULL,
--   `best_desc_sid_2` tinyint(3) DEFAULT NULL,
--   `best_desc_sid_3` tinyint(3) DEFAULT NULL,
--   `modified_by` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
--   `modify_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- 資料表結構 `post`

-- CREATE TABLE `post` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `post_id` int(11) UNSIGNED DEFAULT NULL,
--   `user_id` int(11) UNSIGNED DEFAULT NULL,
--   `content` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
--   `post_time` timestamp NOT NULL DEFAULT current_timestamp(),
--   `post_img` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- 資料表結構 `post_comment`

-- CREATE TABLE `post` (
--   `id` int(11) UNSIGNED NOT NULL,
--   `post_id` int(11) UNSIGNED DEFAULT NULL,
--   `parent_id` int(11) UNSIGNED DEFAULT NULL,
--   `user_id` int(11) UNSIGNED DEFAULT NULL,
--   `comment` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
--   `post_time` timestamp NOT NULL DEFAULT current_timestamp(),
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;