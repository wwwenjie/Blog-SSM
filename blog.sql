-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 02, 2020 at 08:10 PM
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
  `article_category` varchar(255) NOT NULL DEFAULT '未分类',
  `article_title` tinytext NOT NULL COMMENT '博文标题',
  `article_content` longtext COMMENT '博文内容',
  `article_image` varchar(255) DEFAULT NULL COMMENT '博文图片',
  `article_views` int(10) UNSIGNED NOT NULL DEFAULT '0' COMMENT '浏览量',
  `article_comment_count` int(10) UNSIGNED NOT NULL DEFAULT '0' COMMENT '评论总数',
  `article_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发表时间',
  `article_last_modify_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最近一次修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`article_id`, `user_id`, `article_category`, `article_title`, `article_content`, `article_image`, `article_views`, `article_comment_count`, `article_date`, `article_last_modify_date`) VALUES
(2, 1, '介绍', '项目介绍', '<h3>插入一些有意义的数据</h3>\n<p>本次项目使用 Vue + Spring SSM 完成</p>\n<p>强烈推荐富文本编辑器 Tinymce</p>\n<p>根据需求，所有蓝色需求均已完成</p>\n<p>博客前端使用 Vuetify 组件库，博客首页使用 Vuetify 的 Blog 模板，后代管理系统未使用模板</p>\n<p>博客后端采用 Restful 风格设计，所有请求都视为资源，例如：用户登陆是请求 tokens，获取博客是请求 articles，获取单个博客请求 articles/{id} 。</p>\n<p>博客后端使用 JWT 进行授权，可以通过 JWT 中的 payload 获取身份，并且无需 cookie，持久化等操作。</p>\n<p>后端使用 MVC 拦截器和 Spring AOP 分别实现 权限验证，日志服务。</p>\n<p>博客系统采用前后端分离的开发模式，更加利于专注前/后端开发。</p>', NULL, 0, 0, '2020-06-01 02:45:12', '2020-06-01 02:45:12'),
(3, 1, '未分类', '富文本编辑器', '<p>博客内容使用 tinymce 存储，它是一个很不错的富文本编辑器。</p>\n<h1>大标题</h1>\n<h5>H5标题</h5>\n<p><span style=\"background-color: #e03e2d;\">给你的文本上背景色</span></p>\n<p style=\"text-align: center;\"><span style=\"background-color: #e03e2d;\">居中</span></p>\n<ol>\n<li>列表</li>\n<li>1</li>\n</ol>\n<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n<tbody>\n<tr>\n<td style=\"width: 33.3333%;\">\n<p>表格</p>\n</td>\n<td style=\"width: 33.3333%;\">轻松插入</td>\n<td style=\"width: 33.3333%;\">不依赖 MarkDown</td>\n</tr>\n<tr>\n<td style=\"width: 33.3333%;\">&nbsp;</td>\n<td style=\"width: 33.3333%;\">&nbsp;</td>\n<td style=\"width: 33.3333%;\">&nbsp;</td>\n</tr>\n</tbody>\n</table>\n<p>16:34:32 插入现在的时间</p>\n<p><span style=\"font-family: \'comic sans ms\', sans-serif;\">And change a font</span></p>\n<p><span style=\"color: #e03e2d;\">change text color</span></p>\n<p>官网链接&nbsp;<a title=\"https://www.tiny.cloud/\" href=\"https://www.tiny.cloud/\"><em> https://www.tiny.cloud/</em></a></p>', NULL, 0, 0, '2020-06-01 02:47:19', '2020-06-01 02:47:19'),
(4, 1, '未分类', '文章生成器', '<div>可是，即使是这样，文章生成器的出现仍然代表了一定的意义。 拉罗什夫科说过一句富有哲理的话，取得成就时坚持不懈，要比遭到失败时顽强不屈更重要。我希望诸位也能好好地体会这句话。 生活中，若文章生成器出现了，我们就不得不考虑它出现了的事实。 这种事实对本人来说意义重大，相信对这个世界也是有一定意义的。 总结的来说， 本人也是经过了深思熟虑，在每个日日夜夜思考这个问题。 迈克尔&middot;F&middot;斯特利说过一句富有哲理的话，最具挑战性的挑战莫过于提升自我。这似乎解答了我的疑惑。 我们不得不面对一个非常尴尬的事实，那就是， 乌申斯基曾经说过，学习是劳动，是充满思想的劳动。这不禁令我深思。 要想清楚，文章生成器，到底是一种怎么样的存在。 一般来说， 文章生成器，发生了会如何，不发生又会如何。 一般来讲，我们都必须务必慎重的考虑考虑。 了解清楚文章生成器到底是一种怎么样的存在，是解决一切问题的关键。 那么， 所谓文章生成器，关键是文章生成器需要如何写。 我们都知道，只要有意义，那么就必须慎重考虑。 就我个人来说，文章生成器对我的意义，不能不说非常重大。 伏尔泰曾经说过，坚持意志伟大的事业需要始终不渝的精神。这似乎解答了我的疑惑。 一般来说。</div>\n<div>　　我们都知道，只要有意义，那么就必须慎重考虑。 现在，解决文章生成器的问题，是非常非常重要的。 所以， 佚名说过一句富有哲理的话，感激每一个新的挑战，因为它会锻造你的意志和品格。这句话语虽然很短，但令我浮想联翩。 所谓文章生成器，关键是文章生成器需要如何写。 我们都知道，只要有意义，那么就必须慎重考虑。 我们一般认为，抓住了问题的关键，其他一切则会迎刃而解。 就我个人来说，文章生成器对我的意义，不能不说非常重大。 这种事实对本人来说意义重大，相信对这个世界也是有一定意义的。 康德曾经提到过，既然我已经踏上这条道路，那么，任何东西都不应妨碍我沿着这条路走下去。这启发了我， 文章生成器的发生，到底需要如何做到，不文章生成器的发生，又会如何产生。 从这个角度来看， 而这些并不是完全重要，更加重要的问题是， 一般来讲，我们都必须务必慎重的考虑考虑。 经过上述讨论， 一般来讲，我们都必须务必慎重的考虑考虑。 对我个人而言，文章生成器不仅仅是一个重大的事件，还可能会改变我的人生。 文章生成器，到底应该如何实现。 所谓文章生成器，关键是文章生成器需要如何写。 对我个人而言，文章生成器不仅仅是一个重大的事件，还可能会改变我的人生。 现在，解决文章生成器的问题，是非常非常重要的。 所以， 那么， 文章生成器，发生了会如何，不发生又会如何。 文章生成器的发生，到底需要如何做到，不文章生成器的发生，又会如何产生。 所谓文章生成器，关键是文章生成器需要如何写。 总结的来说， 冯学峰曾经说过，当一个人用工作去迎接光明，光明很快就会来照耀着他。我希望诸位也能好好地体会这句话。 了解清楚文章生成器到底是一种怎么样的存在，是解决一切问题的关键。 每个人都不得不面对这些问题。 在面对这种问题时， 经过上述讨论， 一般来讲，我们都必须务必慎重的考虑考虑。 拉罗什夫科说过一句富有哲理的话，取得成就时坚持不懈，要比遭到失败时顽强不屈更重要。这句话语虽然很短，但令我浮想联翩。 对我个人而言，文章生成器不仅仅是一个重大的事件，还可能会改变我的人生。 那么， 就我个人来说，文章生成器对我的意义，不能不说非常重大。 所谓文章生成器，关键是文章生成器需要如何写。 总结的来说， 文章生成器，发生了会如何，不发生又会如何。 一般来说， 而这些并不是完全重要，更加重要的问题是， 富兰克林在不经意间这样说过，你热爱生命吗？那么别浪费时间，因为时间是组成生命的材料。我希望诸位也能好好地体会这句话。 这样看来， 文章生成器因何而发生？ 黑塞曾经提到过，有勇气承担命运这才是英雄好汉。这启发了我。</div>', NULL, 0, 0, '2020-06-01 02:47:21', '2020-06-01 02:47:21'),
(5, 1, '未分类', '第三个。。', '<p>　　而这些并不是完全重要，更加重要的问题是， 这样看来， 从这个角度来看， 对我个人而言，第三个。。不仅仅是一个重大的事件，还可能会改变我的人生。 那么， 总结的来说， 第三个。。的发生，到底需要如何做到，不第三个。。的发生，又会如何产生。 我们不得不面对一个非常尴尬的事实，那就是， 问题的关键究竟为何？ 而这些并不是完全重要，更加重要的问题是， 经过上述讨论， 所谓第三个。。，关键是第三个。。需要如何写。 从这个角度来看， 现在，解决第三个。。的问题，是非常非常重要的。 所以， 第三个。。，到底应该如何实现。 我认为， 第三个。。的发生，到底需要如何做到，不第三个。。的发生，又会如何产生。 经过上述讨论， 对我个人而言，第三个。。不仅仅是一个重大的事件，还可能会改变我的人生。 莎士比亚曾经说过，意志命运往往背道而驰，决心到最后会全部推倒。这启发了我， 就我个人来说，第三个。。对我的意义，不能不说非常重大。 从这个角度来看， 一般来说， 这种事实对本人来说意义重大，相信对这个世界也是有一定意义的。 既然如何， 第三个。。，到底应该如何实现。 所谓第三个。。，关键是第三个。。需要如何写。 既然如何， 第三个。。，发生了会如何，不发生又会如何。 经过上述讨论， 所谓第三个。。，关键是第三个。。需要如何写。 一般来讲，我们都必须务必慎重的考虑考虑。 一般来说， 那么， 带着这些问题，我们来审视一下第三个。。。 现在，解决第三个。。的问题，是非常非常重要的。 所以， 我们都知道，只要有意义，那么就必须慎重考虑。 第三个。。的发生，到底需要如何做到，不第三个。。的发生，又会如何产生。 这种事实对本人来说意义重大，相信对这个世界也是有一定意义的。 富兰克林说过一句富有哲理的话，读书是易事，思索是难事，但两者缺一，便全无用处。这启发了我， 经过上述讨论， 伏尔泰说过一句富有哲理的话，不经巨大的困难，不会有伟大的事业。这不禁令我深思。</p>', NULL, 0, 0, '2020-06-01 02:47:21', '2020-06-01 02:47:21'),
(6, 1, '未分类', '更多文章生成', '<p>　　叔本华曾经说过，意志是一个强壮的盲人，倚靠在明眼的跛子肩上。这启发了我， 我认为， 现在，解决更多文章生成的问题，是非常非常重要的。 所以， 在这种困难的抉择下，本人思来想去，寝食难安。 本人也是经过了深思熟虑，在每个日日夜夜思考这个问题。 现在，解决更多文章生成的问题，是非常非常重要的。 所以， 问题的关键究竟为何？ 对我个人而言，更多文章生成不仅仅是一个重大的事件，还可能会改变我的人生。 这种事实对本人来说意义重大，相信对这个世界也是有一定意义的。 了解清楚更多文章生成到底是一种怎么样的存在，是解决一切问题的关键。 带着这些问题，我们来审视一下更多文章生成。 每个人都不得不面对这些问题。 在面对这种问题时， 那么， 更多文章生成的发生，到底需要如何做到，不更多文章生成的发生，又会如何产生。 一般来说， 我们一般认为，抓住了问题的关键，其他一切则会迎刃而解。 本人也是经过了深思熟虑，在每个日日夜夜思考这个问题。 我们一般认为，抓住了问题的关键，其他一切则会迎刃而解。 培根说过一句富有哲理的话，深窥自己的心，而后发觉一切的奇迹在你自己。这句话语虽然很短，但令我浮想联翩。 带着这些问题，我们来审视一下更多文章生成。 从这个角度来看， 我们不得不面对一个非常尴尬的事实，那就是， 西班牙说过一句富有哲理的话，自知之明是最难得的知识。这不禁令我深思。 了解清楚更多文章生成到底是一种怎么样的存在，是解决一切问题的关键。 我们一般认为，抓住了问题的关键，其他一切则会迎刃而解。 博曾经说过，一次失败，只是证明我们成功的决心还够坚强。 维这启发了我， 经过上述讨论， 而这些并不是完全重要，更加重要的问题是。</p>', NULL, 0, 0, '2020-06-01 02:47:32', '2020-06-01 02:47:32'),
(7, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:32', '2020-06-01 02:47:32'),
(8, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:32', '2020-06-01 02:47:32'),
(9, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:32', '2020-06-01 02:47:32'),
(10, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:32', '2020-06-01 02:47:32'),
(13, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:33', '2020-06-01 02:47:33'),
(14, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:33', '2020-06-01 02:47:33'),
(15, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:33', '2020-06-01 02:47:33'),
(16, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:33', '2020-06-01 02:47:33'),
(17, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:33', '2020-06-01 02:47:33'),
(18, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:33', '2020-06-01 02:47:33'),
(19, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:33', '2020-06-01 02:47:33'),
(20, 1, '未分类', '22', '<p>22</p>', NULL, 0, 0, '2020-06-01 02:47:34', '2020-06-01 02:47:34'),
(21, 1, '123', '123', '<p>123</p>', NULL, 0, 0, '2020-06-01 03:19:15', '2020-06-01 03:19:15'),
(22, 1, '123', '12345654', NULL, NULL, 0, 0, '2020-06-01 03:19:49', '2020-06-01 03:19:49'),
(23, 1, '简介', '博客标题', '<p>博客内容使用 tinymce 存储，它是一个很不错的富文本编辑器。</p>\n<h1>大标题</h1>\n<h5>H5标题</h5>\n<p><span style=\"background-color: #e03e2d;\">给你的文本上背景色</span></p>\n<p style=\"text-align: center;\"><span style=\"background-color: #e03e2d;\">居中</span></p>\n<ol>\n<li>列表</li>\n<li>1</li>\n</ol>\n<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n<tbody>\n<tr>\n<td style=\"width: 33.3333%;\">\n<p>表格</p>\n</td>\n<td style=\"width: 33.3333%;\">轻松插入</td>\n<td style=\"width: 33.3333%;\">不依赖 MarkDown</td>\n</tr>\n<tr>\n<td style=\"width: 33.3333%;\">&nbsp;</td>\n<td style=\"width: 33.3333%;\">&nbsp;</td>\n<td style=\"width: 33.3333%;\">&nbsp;</td>\n</tr>\n</tbody>\n</table>\n<p>16:34:32 插入现在的时间</p>\n<p><span style=\"font-family: \'comic sans ms\', sans-serif;\">And change a font</span></p>\n<p><span style=\"color: #e03e2d;\">change text color</span></p>\n<p>官网链接&nbsp;<a title=\"https://www.tiny.cloud/\" href=\"https://www.tiny.cloud/\"><em> https://www.tiny.cloud/</em></a></p>', NULL, 0, 0, '2020-06-01 08:37:32', '2020-06-01 08:37:32'),
(24, 2, '', 'uid2的博客', '<p>这是博主写的，没有管理员权限</p>', NULL, 0, 0, '2020-06-01 09:23:58', '2020-06-01 09:23:58');

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

--
-- Dumping data for table `authority`
--

INSERT INTO `authority` (`auth_id`, `name`, `url`) VALUES
(1, '管理员', NULL);

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
  `user_id` int(10) UNSIGNED DEFAULT '0' COMMENT '发表用户ID',
  `user_name` varchar(20) DEFAULT 'Anonymity' COMMENT '发表用户名',
  `user_ip` varchar(20) NOT NULL COMMENT '用户IP',
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '评论博文ID',
  `comment_date` datetime DEFAULT NULL COMMENT '评论日期',
  `comment_content` text NOT NULL COMMENT '评论内容',
  `parent_comment_id` int(10) UNSIGNED DEFAULT NULL COMMENT '父评论ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`comment_id`, `user_id`, `user_name`, `user_ip`, `article_id`, `comment_date`, `comment_content`, `parent_comment_id`) VALUES
(3, 1, '13453', '127.0.0.1', 2, NULL, '3153', NULL),
(5, 1, '123', '127.0.0.1', 2, NULL, '123', NULL),
(6, 1, '123', '127.0.0.1', 2, '2020-06-01 16:04:53', '123', NULL),
(7, 1, '12.', '127.0.0.1', 9, '2020-06-01 16:06:13', '123', NULL),
(8, 1, 'test', '127.0.0.1', 3, '2020-06-01 16:28:33', 'test', NULL),
(9, 1, 'test', '127.0.0.1', 5, '2020-06-01 16:29:11', 'test', NULL),
(10, 2, 'uid2', '127.0.0.1', 2, '2020-06-01 17:23:02', '222', NULL),
(11, 2, 'Anonymity', '127.0.0.1', 24, '2020-06-01 20:39:18', '评论测试', NULL),
(12, 1, '123', '0:0:0:0:0:0:0:1', 10, '2020-06-02 18:05:44', '123', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `action`, `user`, `ip`, `date`) VALUES
(1, 'countTotalUser', 'admin', '127.0.0.1', NULL),
(2, 'login', '用户邮箱：admin用户密码：admin', '127.0.0.1', NULL),
(3, 'countTotalUser', 'admin', '127.0.0.1', NULL),
(4, 'countTotalUser', 'admin', '127.0.0.1', NULL),
(5, 'countTotalUser', 'admin', '127.0.0.1', NULL),
(6, 'login', '用户邮箱：admin, 用户密码：admin', '127.0.0.1', '2020-06-02 08:52:14'),
(7, 'countTotalUser', 'admin', '127.0.0.1', '2020-06-02 08:52:14'),
(8, 'updateArticle', 'admin 博文ID: 2', '127.0.0.1', '2020-06-02 09:04:43'),
(9, 'countTotalUser', 'admin', '127.0.0.1', '2020-06-02 09:04:45'),
(10, 'getAllUser', 'admin', '127.0.0.1', '2020-06-02 09:06:38'),
(11, 'creatUser', 'admin', '127.0.0.1', '2020-06-02 09:06:45'),
(12, 'getAllUser', 'admin', '127.0.0.1', '2020-06-02 09:06:46'),
(13, 'getAllUser', 'admin', '127.0.0.1', '2020-06-02 09:07:05'),
(14, 'getAllUser', 'admin', '127.0.0.1', '2020-06-02 09:07:07'),
(15, 'getAllUser', 'admin', '127.0.0.1', '2020-06-02 09:07:22'),
(16, 'updateArticle', 'admin 博文ID: 2', '127.0.0.1', '2020-06-02 09:24:31'),
(17, 'login', '用户邮箱：12, 用户密码：12', '127.0.0.1', '2020-06-02 09:27:52'),
(18, 'login', '用户邮箱：admin, 用户密码：admin', '127.0.0.1', '2020-06-02 09:28:08'),
(19, 'login', '用户邮箱：admin, 用户密码：admin', '127.0.0.1', '2020-06-02 09:46:11'),
(20, 'login', '用户邮箱：admin, 用户密码：admin', '127.0.0.1', '2020-06-02 09:53:07'),
(21, 'deleteArticle', '用户名: admin 博文ID: 12', '127.0.0.1', '2020-06-02 09:53:14'),
(22, 'login', '用户邮箱：12, 用户密码：12', '127.0.0.1', '2020-06-02 09:54:01'),
(23, 'login', '用户邮箱：admin, 用户密码：admin', '127.0.0.1', '2020-06-02 09:54:19'),
(24, 'login', '用户邮箱: admin, 用户密码: admin', '0:0:0:0:0:0:0:1', '2020-06-02 10:05:27'),
(25, 'login', '用户邮箱: admin, 用户密码: admin', '0:0:0:0:0:0:0:1', '2020-06-02 10:11:07'),
(26, 'updateArticle', '用户名: admin, 博文ID: 2', '0:0:0:0:0:0:0:1', '2020-06-02 10:11:41'),
(27, 'updateArticle', '用户名: admin, 博文ID: 3', '0:0:0:0:0:0:0:1', '2020-06-02 10:13:02'),
(28, 'updateArticle', '用户名: admin, 博文ID: 4', '0:0:0:0:0:0:0:1', '2020-06-02 10:13:35'),
(29, 'updateArticle', '用户名: admin, 博文ID: 5', '0:0:0:0:0:0:0:1', '2020-06-02 10:14:31'),
(30, 'updateArticle', '用户名: admin, 博文ID: 6', '0:0:0:0:0:0:0:1', '2020-06-02 10:15:07'),
(31, 'updateArticle', '用户名: admin, 博文ID: 3', '0:0:0:0:0:0:0:1', '2020-06-02 10:15:49'),
(32, 'updateArticle', '用户名: admin, 博文ID: 6', '0:0:0:0:0:0:0:1', '2020-06-02 10:16:34');

-- --------------------------------------------------------

--
-- Table structure for table `option`
--

CREATE TABLE `option` (
  `option_id` int(10) UNSIGNED NOT NULL COMMENT '选项ID',
  `option_name` varchar(190) NOT NULL DEFAULT '' COMMENT '选项名',
  `option_value` varchar(255) NOT NULL COMMENT '选项值',
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
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `auth_id` int(10) UNSIGNED NOT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`user_id`, `auth_id`) VALUES
(1, 1);

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
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_password`, `user_profile_photo`, `user_gender`, `user_registration_date`, `user_ip`) VALUES
(1, 'admin', 'admin', 'admin', NULL, NULL, '2020-05-27 17:21:58', '0:0:0:0:0:0:0:1'),
(2, '666', '666', '666', NULL, NULL, '2020-05-27 17:22:21', '0:0:0:0:0:0:0:1'),
(10, '10', '10', '10', NULL, NULL, '2020-05-27 17:22:42', '0:0:0:0:0:0:0:1'),
(12, '12', '12', '12', NULL, NULL, '2020-05-27 17:22:50', '0:0:0:0:0:0:0:1'),
(14, '14', '14', '14', NULL, NULL, '2020-05-27 17:23:00', '0:0:0:0:0:0:0:1'),
(15, '15', '15', '15', NULL, NULL, '2020-05-27 17:23:04', '0:0:0:0:0:0:0:1'),
(16, '16', '16', '16', NULL, NULL, '2020-05-27 17:23:07', '0:0:0:0:0:0:0:1'),
(17, '17', '17', '17', NULL, NULL, '2020-05-27 17:23:11', '0:0:0:0:0:0:0:1'),
(18, '18', '18', '18', NULL, NULL, '2020-05-27 17:23:16', '0:0:0:0:0:0:0:1'),
(19, '19', '19', '19', NULL, NULL, '2020-05-27 17:23:21', '0:0:0:0:0:0:0:1'),
(20, '20', '20', '20', NULL, NULL, '2020-05-27 17:23:26', '0:0:0:0:0:0:0:1'),
(21, '21', '21', '21', NULL, NULL, '2020-05-27 17:23:46', '0:0:0:0:0:0:0:1'),
(22, '22', '22', '22', NULL, NULL, '2020-05-27 17:23:49', '0:0:0:0:0:0:0:1'),
(24, '123', '12355', '123', NULL, '男', '2020-05-28 14:35:39', '127.0.0.1'),
(25, '2222', '2222', '2222', NULL, '', '2020-05-28 16:30:53', '127.0.0.1'),
(27, 'sa\'d', 'sad', 'ss', NULL, '', '2020-05-28 17:12:16', '127.0.0.1'),
(29, '修改刚刚的新用户', '1111', '2222', NULL, '女', '2020-05-28 17:18:55', '127.0.0.1'),
(30, '123123', '123123', '123123', NULL, '123213', '2020-06-02 17:06:46', '127.0.0.1');

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
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `article_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '博文ID', AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类ID';

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论ID', AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `option`
--
ALTER TABLE `option`
  MODIFY `option_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选项ID', AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID', AUTO_INCREMENT=31;

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
