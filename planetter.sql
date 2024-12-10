-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 10, 2024 at 11:37 AM
-- Server version: 5.7.24
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `planetter`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `name` varchar(16) NOT NULL,
  `pass` varchar(16) NOT NULL,
  `stardust` int(8) NOT NULL,
  `nowPlanet` varchar(16) NOT NULL,
  `x` int(2) NOT NULL,
  `y` int(2) NOT NULL,
  `direction` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`name`, `pass`, `stardust`, `nowPlanet`, `x`, `y`, `direction`) VALUES
('neko', '1234', 10000, 'beginerPlanet', 3, 0, 1),
('papa', '1234', 3000, 'tatake', 3, 3, 2),
('rasera', 'rasera', 10000, 'beginerPlanet', 0, 1, 3),
('totakeke', '1234', 3000, 'tatake', 3, 3, 2),
('yoshida', '1234', 10000, 'beginerPlanet', 0, 9, 2),
('yoshiko', 'yoshiko', 10000, 'beginerPlanet', 8, 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `object`
--

CREATE TABLE `object` (
  `type` varchar(16) NOT NULL,
  `planet` varchar(16) NOT NULL,
  `x` int(2) NOT NULL,
  `y` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `planet`
--

CREATE TABLE `planet` (
  `name` varchar(16) NOT NULL,
  `xsize` int(2) NOT NULL,
  `ysize` int(2) NOT NULL,
  `criater` varchar(16) NOT NULL,
  `x` int(3) NOT NULL,
  `y` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `planet`
--

INSERT INTO `planet` (`name`, `xsize`, `ysize`, `criater`, `x`, `y`) VALUES
('BeginerPlanet', 10, 10, 'manager', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `planet`
--
ALTER TABLE `planet`
  ADD PRIMARY KEY (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
