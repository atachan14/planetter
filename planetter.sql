-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- ホスト: localhost:3306
-- 生成日時: 2024-12-12 13:26:34
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
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `account`
--

INSERT INTO `account` (`name`, `pass`, `stardust`, `nowPlanet`, `x`, `y`, `direction`, `stomach`, `date`) VALUES
('arishia', 'arishia', 10000, 'beginersPlanet', 1, 5, 0, 100, '2024-12-11 22:17:01'),
('asd', '1234', 10000, 'beginersPlanet', 2, 1, 0, 100, '2024-12-11 22:13:15'),
('neko', '1234', 10000, 'beginerPlanet', 3, 0, 1, 100, '2024-12-11 21:08:50'),
('okweo1234', '1234', 10000, 'beginerPlanet', 4, 0, 1, 100, '2024-12-11 21:08:50'),
('ooo', 'ooo', 10000, 'beginersPlanet', 0, 2, 0, 100, '2024-12-11 22:04:56'),
('papa', '1234', 3000, 'tatake', 3, 3, 2, 100, '2024-12-11 21:08:50'),
('rara', 'rara', 10000, 'beginerPlanet', 5, 3, 3, 100, '2024-12-11 22:03:29'),
('rasera', 'rasera', 10000, 'beginerPlanet', 0, 1, 3, 100, '2024-12-11 21:08:50'),
('saki', 'saki', 10000, 'beginerPlanet', 2, 5, 1, 100, '2024-12-11 22:01:42'),
('sasaki', 'sasaki', 10000, 'beginerPlanet', 0, 8, 1, 100, '2024-12-11 21:51:59'),
('tester', 'tester', 10000, 'beginersPlanet', 5, 1, 1, 100, '2024-12-12 04:08:01'),
('totakeke', '1234', 3000, 'tatake', 3, 3, 2, 100, '2024-12-11 21:08:50'),
('yoshida', '1234', 10000, 'beginerPlanet', 0, 9, 2, 100, '2024-12-11 21:08:50'),
('yoshiko', 'yoshiko', 10000, 'beginerPlanet', 8, 5, 0, 100, '2024-12-11 21:08:50');

-- --------------------------------------------------------

--
-- テーブルの構造 `page`
--

CREATE TABLE `page` (
  `id` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  `criater` int(11) NOT NULL,
  `date` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `planet`
--

INSERT INTO `planet` (`name`, `xsize`, `ysize`, `criater`, `x`, `y`, `date`) VALUES
('beginerplanet', 20, 20, 'master', 9, 9, '2024-12-11 22:23:49'),
('BeginersPlanet', 10, 10, 'master', 0, 0, '2024-12-11 21:09:40'),
('Test', 4, 4, 'Master', 2, -2, '2024-12-11 21:09:40');

-- --------------------------------------------------------

--
-- テーブルの構造 `tile`
--

CREATE TABLE `tile` (
  `id` int(11) NOT NULL,
  `type` varchar(16) NOT NULL,
  `objectID` int(11) NOT NULL,
  `planet` varchar(16) NOT NULL,
  `x` int(2) NOT NULL,
  `y` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `tweet`
--

CREATE TABLE `tweet` (
  `id` int(11) NOT NULL,
  `value` varchar(100) NOT NULL,
  `criater` varchar(16) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`name`);

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
-- テーブルの AUTO_INCREMENT `page`
--
ALTER TABLE `page`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- テーブルの AUTO_INCREMENT `tile`
--
ALTER TABLE `tile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- テーブルの AUTO_INCREMENT `tweet`
--
ALTER TABLE `tweet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
