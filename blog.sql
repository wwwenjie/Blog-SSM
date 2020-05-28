-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 27, 2020 at 05:14 PM
-- Server version: 8.0.12
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
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `address_id` int(10) UNSIGNED NOT NULL COMMENT '地址ID',
  `address` varchar(255) DEFAULT NULL COMMENT '具体地址',
  `address_type` varchar(255) DEFAULT NULL COMMENT '地址类型',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '发表用户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

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

CREATE TABLE `article_category` (
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '文章ID',
  `category_id` int(10) UNSIGNED NOT NULL COMMENT '分类ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `authority`
--

CREATE TABLE `authority` (
  `auth_id` int(10) UNSIGNED NOT NULL COMMENT '权限ID',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(255) DEFAULT NULL COMMENT '允许的URL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

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
-- Table structure for table `option`
--

CREATE TABLE `option` (
  `option_id` int(10) UNSIGNED NOT NULL COMMENT '选项ID',
  `option_name` varchar(190) NOT NULL DEFAULT '' COMMENT '选项名',
  `option_value` longtext NOT NULL COMMENT '选项值',
  `option_enable` varchar(10) NOT NULL DEFAULT 'yes' COMMENT '选项状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `auth_id` int(10) UNSIGNED NOT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `user_name` varchar(20) DEFAULT 'Anonymity' COMMENT '用户名',
  `user_email` varchar(30) NOT NULL COMMENT '用户邮箱',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_profile_photo` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `user_gender` varchar(20) DEFAULT NULL COMMENT '用户性别',
  `user_registration_date` datetime NOT NULL COMMENT '注册时间',
  `user_ip` varchar(20) NOT NULL COMMENT '用户注册IP'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

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
-- Indexes for table `option`
--
ALTER TABLE `option`
  ADD PRIMARY KEY (`option_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_email` (`user_email`),
  ADD KEY `user_name` (`user_name`);

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
-- AUTO_INCREMENT for table `option`
--
ALTER TABLE `option`
  MODIFY `option_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选项ID';

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
