-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2019 at 02:46 PM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cricket`
--

-- --------------------------------------------------------

--
-- Table structure for table `cricket_games`
--

DROP TABLE IF EXISTS `cricket_games`;
CREATE TABLE IF NOT EXISTS `cricket_games` (
  `ID` varchar(10) NOT NULL,
  `GameCode` varchar(3) NOT NULL,
  `TeamOne` varchar(50) NOT NULL,
  `TeamTwo` varchar(50) NOT NULL,
  `Date` varchar(10) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `games_col_details`
--

DROP TABLE IF EXISTS `games_col_details`;
CREATE TABLE IF NOT EXISTS `games_col_details` (
  `ID` varchar(10) NOT NULL,
  `colCode` varchar(5) NOT NULL,
  `value` varchar(500) NOT NULL,
  `no` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `game_deatils`
--

DROP TABLE IF EXISTS `game_deatils`;
CREATE TABLE IF NOT EXISTS `game_deatils` (
  `ID` varchar(10) NOT NULL,
  `GameCode` varchar(5) NOT NULL,
  `Value` varchar(100) NOT NULL,
  `Vissiblity` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cricket_games`
--
ALTER TABLE `cricket_games`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `GameCode` (`GameCode`,`Date`);

--
-- Indexes for table `games_col_details`
--
ALTER TABLE `games_col_details`
  ADD UNIQUE KEY `ID` (`ID`,`colCode`,`no`);

--
-- Indexes for table `game_deatils`
--
ALTER TABLE `game_deatils`
  ADD PRIMARY KEY (`ID`,`GameCode`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `games_col_details`
--
ALTER TABLE `games_col_details`
  ADD CONSTRAINT `FK_details_col` FOREIGN KEY (`ID`, `colCode`) REFERENCES `game_deatils` (`ID`, `GameCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `game_deatils`
--
ALTER TABLE `game_deatils`
  ADD CONSTRAINT `FK_games_details` FOREIGN KEY (`ID`) REFERENCES `cricket_games` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
