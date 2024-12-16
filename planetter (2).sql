-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- ホスト: localhost:3306
-- 生成日時: 2024-12-16 06:01:22
-- サーバのバージョン： 5.7.24
-- PHP のバージョン: 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `planetter`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `account`
--

CREATE TABLE `account` (
  `name` varchar(16) NOT NULL,
  `pass` varchar(16) NOT NULL,
  `stardust` int(8) NOT NULL,
  `nowPlanet` varchar(16) NOT NULL,
  `x` int(2) NOT NULL,
  `y` int(2) NOT NULL,
  `direction` int(1) NOT NULL,
  `stomach` int(16) NOT NULL DEFAULT '100',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `killCount` int(11) DEFAULT '0',
  `tweetCount` int(11) DEFAULT '0',
  `pageCount` int(11) DEFAULT '0',
  `eatCount` int(11) NOT NULL DEFAULT '0',
  `walkCount` int(11) NOT NULL DEFAULT '0',
  `planetCount` int(11) NOT NULL DEFAULT '0',
  `dsasseCount` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `account`
--

INSERT INTO `account` (`name`, `pass`, `stardust`, `nowPlanet`, `x`, `y`, `direction`, `stomach`, `date`, `killCount`, `tweetCount`, `pageCount`, `eatCount`, `walkCount`, `planetCount`, `dsasseCount`) VALUES
('neko', '1234', 10012, 'beginerPlanet', 3, 0, 1, 100, '2024-12-11 21:08:50', 0, 0, 0, 0, 0, 0, 1),
('okweo1234', '1234', 10000, 'beginerPlanet', 4, 0, 1, 100, '2024-12-11 21:08:50', 0, 0, 0, 0, 0, 0, 0),
('papa', '1234', 3000, 'tatake', 3, 3, 2, 100, '2024-12-11 21:08:50', 0, 0, 0, 0, 0, 0, 0),
('rara', 'rara', 10000, 'beginerPlanet', 5, 3, 3, 100, '2024-12-11 22:03:29', 0, 0, 0, 0, 0, 0, 0),
('rasera', 'rasera', 10000, 'beginerPlanet', 0, 1, 3, 100, '2024-12-11 21:08:50', 0, 0, 0, 0, 0, 0, 0),
('saki', 'saki', 10000, 'beginerPlanet', 2, 5, 1, 100, '2024-12-11 22:01:42', 0, 0, 0, 0, 0, 0, 0),
('sasaki', 'sasaki', 19988, 'beginerPlanet', 9, 12, 2, 126, '2024-12-11 21:51:59', 0, 0, 0, 0, 0, 0, 0),
('tester', 'tester', 10000, 'beginersPlanet', 5, 1, 1, 100, '2024-12-12 04:08:01', 0, 0, 0, 0, 0, 0, 0),
('totakeke', '1234', 3000, 'tatake', 3, 3, 2, 100, '2024-12-11 21:08:50', 0, 0, 0, 0, 0, 0, 0),
('yoshiko', 'yoshiko', 10000, 'beginerPlanet', 8, 5, 0, 100, '2024-12-11 21:08:50', 0, 0, 0, 0, 0, 0, 0),
('あかね', 'あかね', 5999, 'ひ', 1, 0, 1, 93, '2024-12-15 13:24:23', 0, 0, 0, 0, 0, 1, 0),
('おっきいねこ', 'おっきいねこ', 4000, 'だけ', 2, 0, 3, 98, '2024-12-15 13:26:57', 0, 0, 0, 0, 0, 1, 0),
('ちさ', 'ちさ', 10000, 'BeginersPlanet', 6, 1, 3, 100, '2024-12-12 19:39:18', 0, 0, 0, 0, 0, 0, 0),
('ちな', 'ちな', 10000, 'BeginersPlanet', 8, 7, 3, 100, '2024-12-13 20:57:41', 0, 0, 0, 0, 0, 0, 0),
('はみがき', 'はみがき', 113660, 'BeginersPlanet', 2, 6, 3, 999, '2024-12-15 18:16:34', 3, 2, 1, 0, 17, 0, 0),
('まほ', 'まほ', 162773, 'BeginersPlanet', 4, 5, 3, 1767, '2024-12-15 18:20:20', 6, 1, 1, 0, 35, 0, 0),
('ゆうか', 'ゆうか', 133063, 'BeginersPlanet', 0, 2, 1, 1253, '2024-12-15 18:23:29', 3, 2, 0, 0, 55, 1, 0),
('らら', 'らら', 49997, 'BeginersPlanet', 1, 6, 3, 455, '2024-12-15 18:18:03', 1, 0, 0, 0, 11, 0, 0),
('れ', 'れ', 10000, 'BeginersPlanet', 5, 1, 3, 100, '2024-12-14 08:07:09', 0, 0, 0, 0, 0, 0, 0),
('佐々木', '佐々木', 110000, 'BeginersPlanet', 0, 7, 0, 1062, '2024-12-12 17:29:57', 0, 0, 0, 0, 0, 0, 0),
('味がしない', '味がしない', 4000, '味がしない星', 1, 0, 3, 66, '2024-12-15 13:49:18', 0, 0, 0, 0, 0, 1, 0),
('梅田', '梅田', 7796, 'osasimi', 2, 0, 0, 178, '2024-12-15 15:06:20', 0, 0, 0, 0, 0, 2, 1),
('水色ヨッシー', '水色ヨッシー', 10000, 'BeginersPlanet', 2, 9, 3, 100, '2024-12-12 20:10:24', 0, 0, 0, 0, 0, 0, 0),
('西沢', '西沢', 3999, 'ゼッケン', 2, 2, 0, 100, '2024-12-15 13:48:21', 0, 0, 0, 0, 0, 1, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `name` varchar(16) NOT NULL,
  `criater` varchar(16) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tileid` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `page`
--

CREATE TABLE `page` (
  `id` int(11) NOT NULL,
  `name` varchar(16) NOT NULL DEFAULT '名前つけ忘れた!',
  `criater` varchar(16) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tileid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `page`
--

INSERT INTO `page` (`id`, `name`, `criater`, `date`, `tileid`) VALUES
(5, 'a', 'yosiz', '2024-12-14 00:48:33', 23),
(6, 'ki', 'るる', '2024-12-14 00:55:13', 24),
(7, 'たのしいぺーじ', 'れ', '2024-12-14 08:07:38', 26),
(8, 'へろ', '佐々木', '2024-12-14 08:41:36', 27),
(9, 'page', '佐々木', '2024-12-14 08:42:20', 28),
(10, 'てけてけのぺーじ★', '佐々木', '2024-12-14 08:45:37', 29),
(11, 'あｓｄ', '佐々木', '2024-12-14 08:59:49', 13),
(12, '', '佐々木', '2024-12-14 17:05:22', 21),
(13, 'てけ', 'らら', '2024-12-14 17:11:37', 30),
(14, 'tanosii!', 'るる', '2024-12-14 17:29:23', 34),
(15, 'へろのぺーじ', 'るる', '2024-12-14 17:30:15', 25),
(16, 'え？', 'sasaki', '2024-12-14 18:16:05', 35),
(17, 'じょ', 'じょん', '2024-12-14 20:30:33', 16),
(18, 'たのしいぺーじ', 'sasaki', '2024-12-15 09:27:40', 37),
(19, 'ねころぶ', '爆速', '2024-12-15 12:33:36', 40),
(21, '', '梅田', '2024-12-15 15:11:31', 45),
(22, 'は', '梅田', '2024-12-15 15:11:43', 46),
(23, 'てけ', 'おけまる', '2024-12-15 17:07:30', 53),
(24, 'てけ', 'おけまる', '2024-12-15 17:07:30', 53),
(25, 'は', 'さくら', '2024-12-15 17:08:38', 54),
(26, 'さかな', 'さくら', '2024-12-15 17:16:43', 55),
(27, 'は', 'あかぎ', '2024-12-15 17:31:39', 56),
(29, 'たのしかった', 'はみがき', '2024-12-15 18:17:50', 66),
(30, 'りこ', 'まほ', '2024-12-15 18:21:14', 67),
(31, 'てけ', 'はなび', '2024-12-15 18:22:28', 68);

-- --------------------------------------------------------

--
-- テーブルの構造 `planet`
--

CREATE TABLE `planet` (
  `name` varchar(16) NOT NULL,
  `xsize` int(2) NOT NULL,
  `ysize` int(2) NOT NULL,
  `criater` varchar(16) NOT NULL,
  `x` int(3) NOT NULL,
  `y` int(3) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nameDisplay` int(1) NOT NULL DEFAULT '0',
  `stealth` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `planet`
--

INSERT INTO `planet` (`name`, `xsize`, `ysize`, `criater`, `x`, `y`, `date`, `nameDisplay`, `stealth`) VALUES
('', 3, 3, 'みけ', -4, 2, '2024-12-15 12:14:59', 0, 0),
('beginerplanet', 20, 20, 'master', 9, 9, '2024-12-11 22:23:49', 0, 0),
('BeginersPlanet', 10, 10, 'master', 0, 0, '2024-12-11 21:09:40', 0, 0),
('hebe', 3, 3, 'りり', -14, 0, '2024-12-15 16:46:49', 0, 0),
('ie', 3, 3, 'りり', -15, 5, '2024-12-15 16:46:27', 0, 0),
('osasimi', 3, 3, '梅田', -8, -3, '2024-12-15 15:10:28', 0, 0),
('osiruko', 3, 3, 'りり', -19, -1, '2024-12-15 16:47:20', 0, 0),
('Test', 4, 4, 'Master', 2, -2, '2024-12-11 21:09:40', 0, 0),
('tikyuu', 3, 3, 'りり', -10, 5, '2024-12-15 16:46:10', 0, 0),
('waru', 3, 3, 'りり', -24, -2, '2024-12-15 16:47:46', 0, 0),
('きりん', 3, 3, 'ゆうか', -13, -2, '2024-12-15 18:28:23', 0, 0),
('さかな！', 3, 3, 'みけ', -4, 1, '2024-12-15 12:25:26', 0, 0),
('さかな！さかな！', 3, 3, 'みけ', 2, 3, '2024-12-15 12:29:51', 0, 0),
('じょ', 3, 3, '夜', 1, -1, '2024-12-15 12:31:31', 0, 0),
('だけ', 3, 3, 'おっきいねこ', 0, -2, '2024-12-15 13:40:48', 0, 0),
('てけどｎ', 4, 2, '梅田', -3, -5, '2024-12-15 15:08:39', 0, 0),
('なかよし', 3, 3, 'はーちゃん', 1, 3, '2024-12-15 17:59:29', 0, 0),
('はあやい', 3, 3, '爆速', -5, -5, '2024-12-15 12:33:13', 0, 0),
('ひ', 2, 2, 'あかね', -2, 4, '2024-12-15 13:24:45', 0, 0),
('ぽに', 1, 1, '爆速', -10, -6, '2024-12-15 12:34:11', 0, 0),
('まるた', 3, 3, 'りり', -5, 0, '2024-12-15 16:45:44', 0, 0),
('ものの', 3, 3, 'もの', -2, -2, '2024-12-15 12:30:15', 0, 0),
('ゼッケン', 3, 3, '西沢', -15, -5, '2024-12-15 13:48:49', 0, 0),
('味がしない星', 5, 1, '味がしない', 5, 0, '2024-12-15 13:49:49', 0, 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `tile`
--

CREATE TABLE `tile` (
  `id` int(11) NOT NULL,
  `type` varchar(16) NOT NULL,
  `planet` varchar(16) NOT NULL,
  `x` int(2) NOT NULL,
  `y` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `tile`
--

INSERT INTO `tile` (`id`, `type`, `planet`, `x`, `y`) VALUES
(13, 'page', 'BeginersPlanet', 4, 7),
(14, 'tweet', 'BeginersPlanet', 4, 8),
(16, 'page', 'BeginersPlanet', 9, 1),
(17, 'tweet', 'BeginersPlanet', 4, 4),
(18, 'tweet', 'BeginersPlanet', 5, 9),
(19, 'tweet', 'beginersPlanet', 4, 3),
(20, 'tweet', 'BeginersPlanet', 6, 6),
(21, 'page', 'BeginersPlanet', 0, 7),
(23, 'page', 'BeginersPlanet', 9, 7),
(24, 'page', 'BeginersPlanet', 1, 6),
(25, 'page', 'BeginersPlanet', 8, 9),
(26, 'page', 'BeginersPlanet', 5, 1),
(27, 'page', 'BeginersPlanet', 8, 3),
(28, 'page', 'BeginersPlanet', 7, 3),
(29, 'page', 'BeginersPlanet', 1, 4),
(30, 'page', 'beginersPlanet', 5, 5),
(33, 'tweet', 'BeginersPlanet', 6, 3),
(34, 'page', 'BeginersPlanet', 1, 9),
(35, 'page', 'beginerPlanet', 19, 17),
(36, 'tweet', 'beginerPlanet', 1, 9),
(37, 'page', 'beginerPlanet', 9, 9),
(38, 'tweet', 'beginerPlanet', 12, 8),
(39, 'tweet', 'beginerPlanet', 9, 11),
(40, 'page', 'はあやい', 0, 0),
(41, 'tweet', 'ひ', 0, 1),
(42, 'tweet', 'ゼッケン', 2, 2),
(45, 'page', 'osasimi', 2, 1),
(46, 'page', 'osasimi', 2, 0),
(47, 'tweet', 'まるた', 2, 2),
(48, 'tweet', 'tikyuu', 2, 1),
(49, 'tweet', 'ie', 2, 0),
(50, 'tweet', 'hebe', 0, 0),
(51, 'tweet', 'osiruko', 0, 1),
(52, 'tweet', 'waru', 1, 1),
(53, 'page', 'BeginersPlanet', 1, 8),
(54, 'page', 'BeginersPlanet', 0, 6),
(55, 'page', 'BeginersPlanet', 3, 8),
(56, 'page', 'BeginersPlanet', 9, 9),
(57, 'tweet', 'BeginersPlanet', 9, 4),
(58, 'tweet', 'BeginersPlanet', 0, 9),
(59, 'tweet', 'なかよし', 0, 2),
(60, 'tweet', 'さかな！さかな！', 1, 2),
(66, 'page', 'BeginersPlanet', 2, 6),
(67, 'page', 'BeginersPlanet', 3, 1),
(68, 'page', 'BeginersPlanet', 9, 0),
(69, 'tweet', 'きりん', 2, 1),
(70, 'tweet', 'BeginersPlanet', 0, 2);

-- --------------------------------------------------------

--
-- テーブルの構造 `tweet`
--

CREATE TABLE `tweet` (
  `id` int(11) NOT NULL,
  `value` varchar(64) NOT NULL DEFAULT '空っぽで投稿しちゃった！',
  `criater` varchar(16) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pageId` int(11) DEFAULT NULL,
  `tileId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `tweet`
--

INSERT INTO `tweet` (`id`, `value`, `criater`, `date`, `pageId`, `tileId`) VALUES
(18, 'はみがき\r\n', 'ちな', '2024-12-13 20:57:54', 11, 13),
(19, 'もぐもぐたべる！もぐ！', 'ちな', '2024-12-13 20:58:07', NULL, 14),
(21, 'あじゃ', 'がんぐろ', '2024-12-13 21:22:32', 17, 16),
(22, 'ちょりっす', 'ギャル', '2024-12-13 21:24:27', NULL, 17),
(23, 'よろしく', 'じゃがりこ', '2024-12-13 22:02:30', NULL, 18),
(24, '来春', 'らら', '2024-12-13 22:16:17', NULL, 19),
(25, 'ねこ', 'かば', '2024-12-13 23:43:24', NULL, 20),
(26, 'あ', 'ロバ', '2024-12-13 23:50:55', 12, 21),
(28, 'a', 'yosiz', '2024-12-14 00:48:30', 5, 23),
(29, 'ki', 'るる', '2024-12-14 00:55:09', 6, 24),
(30, 'へろ', 'やや', '2024-12-14 07:56:11', 15, 25),
(31, 'たのしかった', 'れ', '2024-12-14 08:07:30', 7, 26),
(33, 'たのしかった', '佐々木', '2024-12-14 08:41:40', 8, NULL),
(34, 'たのしかった', '佐々木', '2024-12-14 08:41:45', 8, NULL),
(35, 'weet', '佐々木', '2024-12-14 08:42:16', 9, 28),
(36, 'たのしくなかった', '佐々木', '2024-12-14 08:43:03', 8, NULL),
(37, '少したのしかった。', '佐々木', '2024-12-14 08:43:09', 8, NULL),
(38, 'うれしかった。', '佐々木', '2024-12-14 08:43:17', 8, NULL),
(39, 'にょろ', '佐々木', '2024-12-14 08:44:34', 8, NULL),
(40, 'にゃ', '佐々木', '2024-12-14 08:44:38', 8, NULL),
(41, 'じゃばすじゃった', '佐々木', '2024-12-14 08:44:44', 8, NULL),
(42, 'かなしかった', '佐々木', '2024-12-14 08:44:49', 8, NULL),
(43, 'ふへ', '佐々木', '2024-12-14 08:44:58', 8, NULL),
(44, 'てけ', '佐々木', '2024-12-14 08:45:26', 10, 29),
(45, 'てけ', '佐々木', '2024-12-14 08:45:40', 10, NULL),
(46, 'てけ', '佐々木', '2024-12-14 08:45:42', 10, NULL),
(47, 'たけ', '佐々木', '2024-12-14 08:45:44', 10, NULL),
(48, 'たけ', '佐々木', '2024-12-14 08:45:46', 10, NULL),
(49, 'たけ', '佐々木', '2024-12-14 08:45:49', 10, NULL),
(50, 'たけ', '佐々木', '2024-12-14 08:45:52', 10, NULL),
(51, 'ま', '佐々木', '2024-12-14 08:57:31', 10, NULL),
(52, 'へろ', '佐々木', '2024-12-14 08:58:21', 6, NULL),
(53, 'あｓｄっだ', '佐々木', '2024-12-14 09:00:01', 11, NULL),
(54, 'たのしあった。', '佐々木', '2024-12-14 09:00:24', 7, NULL),
(55, '鉄', '佐々木', '2024-12-14 16:15:42', 9, NULL),
(56, 'てつかつ', '佐々木', '2024-12-14 16:15:45', 9, NULL),
(57, '猫', '佐々木', '2024-12-14 17:05:25', 12, NULL),
(58, 'na', 'おけこ', '2024-12-14 17:26:31', 9, NULL),
(59, 'へろ', 'おけこ', '2024-12-14 17:26:45', NULL, 33),
(60, 'たのしいぺーじ', 'るる', '2024-12-14 17:29:19', 14, 34),
(61, 'tanoii', 'るる', '2024-12-14 17:29:27', 14, NULL),
(62, 'たのい', 'るる', '2024-12-14 17:29:31', 14, NULL),
(63, 'かな', 'るる', '2024-12-14 17:29:35', 14, NULL),
(64, 'し', 'るる', '2024-12-14 17:29:38', 14, NULL),
(65, 'は', 'るる', '2024-12-14 17:29:40', 14, NULL),
(66, 'は', 'るる', '2024-12-14 17:29:43', 14, NULL),
(67, 'へ', 'るる', '2024-12-14 17:29:45', 14, NULL),
(68, 'へろってする。', 'るる', '2024-12-14 17:30:23', 15, NULL),
(69, 'あせかき', 'るる', '2024-12-14 17:30:46', 11, NULL),
(70, 'は', 'sasaki', '2024-12-14 18:16:00', 16, 35),
(71, 'あ。', 'sasaki', '2024-12-14 18:16:08', 16, NULL),
(72, 'う', 'sasaki', '2024-12-14 18:16:13', 16, NULL),
(73, 'てけ', 'sasaki', '2024-12-14 18:18:04', NULL, 36),
(74, 'たのしいぺーじ', 'らら', '2024-12-14 18:18:21', 13, NULL),
(75, 'たけ', 'らら', '2024-12-14 18:18:24', 13, NULL),
(76, 'じぇ', 'じょん', '2024-12-14 20:30:42', 17, NULL),
(77, 'たのしいぺーじ', 'sasaki', '2024-12-15 09:27:37', 18, 37),
(78, 'たけ', 'sasaki', '2024-12-15 09:27:43', 18, NULL),
(79, 'へろ', 'sasaki', '2024-12-15 09:27:45', 18, NULL),
(80, 'たけ', 'sasaki', '2024-12-15 09:27:48', 18, NULL),
(81, 'は', 'sasaki', '2024-12-15 09:27:49', 18, NULL),
(82, 'たのしかった', 'sasaki', '2024-12-15 09:27:51', 18, NULL),
(83, 'てけ', 'sasaki', '2024-12-15 09:28:04', NULL, 38),
(84, 'にゃ', 'sasaki', '2024-12-15 09:29:01', NULL, 39),
(85, 'ねる', '爆速', '2024-12-15 12:33:25', 19, 40),
(86, 'ねころんだ', '爆速', '2024-12-15 12:33:41', 19, NULL),
(87, 'へろ', 'あかね', '2024-12-15 13:24:52', NULL, 41),
(88, 'ぜっけんだ！', '西沢', '2024-12-15 13:49:01', NULL, 42),
(89, 'たのしかった', '梅田', '2024-12-15 15:06:59', NULL, 43),
(91, 'たのしかった', '梅田', '2024-12-15 15:07:15', 20, NULL),
(92, 'たすけて！', '梅田', '2024-12-15 15:10:41', 21, 45),
(93, 'てけ', '梅田', '2024-12-15 15:11:36', 21, NULL),
(94, 'は', '梅田', '2024-12-15 15:11:40', 22, 46),
(95, 'たけ', 'りり', '2024-12-15 16:45:52', NULL, 47),
(96, '1', 'りり', '2024-12-15 16:46:15', NULL, 48),
(97, 'へろ', 'りり', '2024-12-15 16:46:38', NULL, 49),
(98, 'hebe', 'りり', '2024-12-15 16:46:54', NULL, 50),
(99, 'たのしいぺーじ', 'りり', '2024-12-15 16:47:24', NULL, 51),
(100, 'たのしかった', 'りり', '2024-12-15 16:47:52', NULL, 52),
(101, 'ohayu', 'りり', '2024-12-15 16:49:25', 6, NULL),
(102, 'pppppppppppppppppppppppppppppppppp', 'りり', '2024-12-15 16:49:35', 6, NULL),
(103, 'ぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱ', 'りり', '2024-12-15 16:49:46', 6, NULL),
(104, 'へろ', 'おけまる', '2024-12-15 17:07:28', 24, 53),
(105, 'たけ', 'おけまる', '2024-12-15 17:07:34', 23, NULL),
(106, 'たけ', 'おけまる', '2024-12-15 17:07:36', 23, NULL),
(107, 'は', 'さくら', '2024-12-15 17:08:36', 25, 54),
(108, 'よしあき', 'さくら', '2024-12-15 17:10:59', 5, NULL),
(109, 'はなこ', 'さくら', '2024-12-15 17:11:02', 5, NULL),
(110, 'ひらめ', 'さくら', '2024-12-15 17:16:39', 26, 55),
(111, 'ひらめ', 'さくら', '2024-12-15 17:16:46', 26, NULL),
(112, 'たいやき', 'さくら', '2024-12-15 17:16:52', 26, NULL),
(113, 'は', 'あかぎ', '2024-12-15 17:31:36', 27, 56),
(114, 'は', 'あかぎ', '2024-12-15 17:31:41', 27, NULL),
(115, '素手配さん種のこえ', 'あかぎ', '2024-12-15 17:31:50', 27, NULL),
(116, 'たくさんころした', 'はーちゃん', '2024-12-15 17:55:33', NULL, 57),
(117, 'あ', 'はーちゃん', '2024-12-15 17:55:40', 10, NULL),
(118, 'てけ', 'はーちゃん', '2024-12-15 17:55:45', 10, NULL),
(119, 'てけ', 'はーちゃん', '2024-12-15 17:55:54', 10, NULL),
(120, '武田', 'はーちゃん', '2024-12-15 17:57:10', 10, NULL),
(121, '吉川', 'はーちゃん', '2024-12-15 17:57:31', 10, NULL),
(122, '武久', 'はーちゃん', '2024-12-15 17:57:39', 10, NULL),
(123, 'たのし', 'はーちゃん', '2024-12-15 17:59:13', NULL, 58),
(124, 'なかがよい', 'はーちゃん', '2024-12-15 17:59:35', NULL, 59),
(125, 'おさかな', 'はーちゃん', '2024-12-15 17:59:56', NULL, 60),
(126, 'へろ', 'つーちゃん', '2024-12-15 18:15:36', NULL, 61),
(127, 'たのしいぺーじ', 'つーちゃん', '2024-12-15 18:15:40', NULL, 62),
(129, '', 'つーちゃん', '2024-12-15 18:15:50', 28, NULL),
(130, 'へろ', 'つーちゃん', '2024-12-15 18:15:53', 28, NULL),
(131, 'たけ', 'つーちゃん', '2024-12-15 18:16:00', NULL, 64),
(132, 'へろ', 'つーちゃん', '2024-12-15 18:16:04', NULL, 65),
(133, 'たのしかった', 'はみがき', '2024-12-15 18:17:48', 29, 66),
(134, 'たのしいぺーじ', 'はみがき', '2024-12-15 18:17:52', 29, NULL),
(135, 'じゃが', 'まほ', '2024-12-15 18:21:10', 30, 67),
(136, 'たけ', 'はなび', '2024-12-15 18:22:26', 31, 68),
(137, 'たけ', 'はなび', '2024-12-15 18:22:30', 31, NULL),
(138, 'Ou', 'ゆうか', '2024-12-15 18:30:40', NULL, 69),
(139, 'やばい！', 'ゆうか', '2024-12-15 18:31:18', NULL, 70);

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`name`);

--
-- テーブルのインデックス `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `page`
--
ALTER TABLE `page`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `planet`
--
ALTER TABLE `planet`
  ADD PRIMARY KEY (`name`);

--
-- テーブルのインデックス `tile`
--
ALTER TABLE `tile`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `tweet`
--
ALTER TABLE `tweet`
  ADD PRIMARY KEY (`id`);

--
-- ダンプしたテーブルの AUTO_INCREMENT
--

--
-- テーブルの AUTO_INCREMENT `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- テーブルの AUTO_INCREMENT `page`
--
ALTER TABLE `page`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- テーブルの AUTO_INCREMENT `tile`
--
ALTER TABLE `tile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- テーブルの AUTO_INCREMENT `tweet`
--
ALTER TABLE `tweet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
