-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2019 at 02:48 PM
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

--
-- Dumping data for table `cricket_games`
--

INSERT INTO `cricket_games` (`ID`, `GameCode`, `TeamOne`, `TeamTwo`, `Date`, `status`) VALUES
('1', 'CFR', 'Falcon Women Team', 'Rolland Women Team', '2019-01-31', 1),
('2', 'CNT', 'Nayagara Women Team', 'Telco Women Team', '2019-01-20', 1),
('~N{~T^(ME6', 'SET', 'Senarathgoda Team', 'Ehaliyagoda Team', '2019-02-24', 1);

--
-- Dumping data for table `games_col_details`
--

INSERT INTO `games_col_details` (`ID`, `colCode`, `value`, `no`) VALUES
('1', 'CFR01', 'Falcon Women Team', 1),
('1', 'CFR01', 'sdfsdffdgf', 2),
('1', 'CFR01', 'sdfdsgsfgsdf', 3),
('1', 'CFR01', 'sdasdasd', 4),
('1', 'CFR01', '12131dsadasd', 5),
('1', 'CFR01', 'asdasdasd', 6),
('1', 'CFR02', 'undefined', 1);

--
-- Dumping data for table `game_deatils`
--

INSERT INTO `game_deatils` (`ID`, `GameCode`, `Value`, `Vissiblity`) VALUES
('1', 'CFR01', 'Match Winner', 1),
('1', 'CFR02', 'Best Player', 1);
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
