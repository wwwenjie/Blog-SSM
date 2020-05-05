-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 25, 2020 at 02:21 AM
-- Server version: 5.7.26
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '博文ID',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '发表用户ID',
  `article_title` tinytext NOT NULL COMMENT '博文标题',
  `article_content` longtext COMMENT '博文内容',
  `article_image` varchar(255) DEFAULT NULL COMMENT '博文图片',
  `article_views` int(10) UNSIGNED NOT NULL COMMENT '浏览量',
  `article_comment_count` int(10) UNSIGNED NOT NULL COMMENT '评论总数',
  `article_date` datetime NOT NULL COMMENT '发表时间',
  `article_last_modify_date` datetime NOT NULL COMMENT '最近一次修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `article_category`
--

DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category` (
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '文章ID',
  `category_id` int(10) UNSIGNED NOT NULL COMMENT '分类ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `article_label`
--

DROP TABLE IF EXISTS `article_label`;
CREATE TABLE `article_label` (
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '文章ID',
  `label_id` int(10) UNSIGNED NOT NULL COMMENT '标签ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(10) UNSIGNED NOT NULL COMMENT '分类ID',
  `category_name` varchar(50) NOT NULL COMMENT '分类名称',
  `category_alias` varchar(15) DEFAULT NULL COMMENT '分类别名',
  `category_description` tinytext COMMENT '分类描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(10) UNSIGNED NOT NULL COMMENT '评论ID',
  `user_id` int(10) UNSIGNED DEFAULT NULL COMMENT '发表用户ID',
  `user_name` varchar(20) DEFAULT 'Anonymity' COMMENT '发表用户名',
  `user_ip` varchar(20) NOT NULL COMMENT '用户IP',
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '评论博文ID',
  `comment_date` datetime DEFAULT NULL COMMENT '评论日期',
  `comment_content` text NOT NULL COMMENT '评论内容',
  `parent_comment_id` int(10) UNSIGNED DEFAULT NULL COMMENT '父评论ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `label_id` int(10) UNSIGNED NOT NULL COMMENT '标签ID',
  `label_name` varchar(20) NOT NULL COMMENT '标签名称',
  `label_alias` varchar(20) DEFAULT NULL COMMENT '标签别名',
  `label_description` tinytext COMMENT '标签描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `option`
--

DROP TABLE IF EXISTS `option`;
CREATE TABLE `option` (
  `option_id` int(10) UNSIGNED NOT NULL COMMENT '选项ID',
  `option_name` varchar(190) NOT NULL DEFAULT '' COMMENT '选项名',
  `option_value` longtext NOT NULL COMMENT '选项值',
  `option_enable` varchar(10) NOT NULL DEFAULT 'yes' COMMENT '选项状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `option`
--

INSERT INTO `option` (`option_id`, `option_name`, `option_value`, `option_enable`) VALUES
(1, 'siteurl', 'https://github.com/wwwenjie/Blog', 'yes'),
(2, 'blogname', 'Blog', 'yes'),
(3, 'blogdescription', 'Life is too short to waste a second', 'yes'),
(4, 'users_can_register', '1', 'yes'),
(5, 'admin_email', 'admin', 'yes'),
(6, 'mailserver_url', 'mail.example.com', 'yes'),
(7, 'mailserver_login', 'login@example.com', 'yes'),
(8, 'mailserver_pass', 'password', 'yes'),
(9, 'mailserver_port', '110', 'yes'),
(10, 'default_category', '1', 'yes'),
(11, 'default_comment_status', 'open', 'yes'),
(12, 'posts_per_page', '10', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `user_name` varchar(20) DEFAULT 'Anonymity' COMMENT '用户名',
  `user_email` varchar(30) NOT NULL COMMENT '用户邮箱',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_profile_photo` varchar(255) DEFAULT NULL COMMENT '用户头像',
--   奇怪的字段开始
  `user_gender` varchar(20) DEFAULT NULL COMMENT '用户性别',
  `user_hobby` longtext DEFAULT NULL COMMENT '用户爱好',
  `user_bday` datetime DEFAULT NULL COMMENT '用户生日',
--   奇怪的字段结束
  `user_registration_date` datetime NOT NULL COMMENT '注册时间',
  `user_ip` varchar(20) NOT NULL COMMENT '用户注册IP'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`article_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `article_category`
--
ALTER TABLE `article_category`
  ADD PRIMARY KEY (`article_id`,`category_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `article_label`
--
ALTER TABLE `article_label`
  ADD PRIMARY KEY (`article_id`,`label_id`),
  ADD KEY `label_id` (`label_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`),
  ADD KEY `category_name` (`category_name`),
  ADD KEY `category_alias` (`category_alias`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `article_id` (`article_id`),
  ADD KEY `comment_date` (`comment_date`),
  ADD KEY `parent_comment_id` (`parent_comment_id`);

--
-- Indexes for table `label`
--
ALTER TABLE `label`
  ADD PRIMARY KEY (`label_id`),
  ADD KEY `label_name` (`label_name`),
  ADD KEY `label_alias` (`label_alias`);

--
-- Indexes for table `option`
--
ALTER TABLE `option`
  ADD PRIMARY KEY (`option_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_name` (`user_name`),
  ADD UNIQUE KEY `user_email` (`user_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `article_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '博文ID';

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类ID';

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论ID';

--
-- AUTO_INCREMENT for table `label`
--
ALTER TABLE `label`
  MODIFY `label_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签ID';

--
-- AUTO_INCREMENT for table `option`
--
ALTER TABLE `option`
  MODIFY `option_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选项ID', AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID';

--
-- Constraints for dumped tables
--

--
-- Constraints for table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `articles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
