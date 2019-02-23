DROP TABLE IF EXISTS `TEMP_CRICKET`;
CREATE TABLE IF NOT EXISTS `TEMP_CRICKET` (
  `ID` varchar(10) NOT NULL,
  `GameCode` varchar(3) NOT NULL,
  `TeamOne` varchar(50) NOT NULL,
  `TeamTwo` varchar(50) NOT NULL,
  `Date` varchar(10) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `TEMP_COL_DETAILS`;
CREATE TABLE IF NOT EXISTS `TEMP_COL_DETAILS` (
  `ID` varchar(10) NOT NULL,
  `colCode` varchar(5) NOT NULL,
  `value` varchar(500) NOT NULL,
  `no` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `TEMP_GAMES`;
CREATE TABLE IF NOT EXISTS `TEMP_GAMES` (
  `ID` varchar(10) NOT NULL,
  `GameCode` varchar(5) NOT NULL,
  `Value` varchar(100) NOT NULL,
  `Vissiblity` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- backuping data --

INSERT INTO `TEMP_CRICKET`(`ID`,`GameCode`,`TeamOne`,`TeamTwo`,`Date`,`status`)
   SELECT `ID`,`GameCode`,`TeamOne`,`TeamTwo`,`Date`,`status` FROM `cricket_games` WHERE status != 1;


INSERT INTO `TEMP_COL_DETAILS`(`ID`, `GameCode`, `Value`, `Vissiblity`)
    SELECT `ID`, `GameCode`, `Value`, `Vissiblity` FROM `game_deatils` WHERE `ID` IN (SELECT `ID` FROM `cricket_games` WHERE `ID` != 1);
    

INSERT INTO `TEMP_COL_DETAILS`(`ID`, `colCode`, `value`, `no`)
    SELECT `ID`, `colCode`, `value`, `no` FROM `games_col_details` WHERE `ID` IN (SELECT `ID` FROM `cricket_games` WHERE `ID` != 1)


 -- delete all backuped data --

DELETE FROM `games_col_details` WHERE `ID` IN (SELECT `ID` FROM `cricket_games` WHERE `status` != 1);

DELETE FROM `TEMP_COL_DETAILS` WHERE `ID` IN (SELECT `ID` FROM `cricket_games` WHERE `status` != 1);

DELETE FROM `cricket_games` WHERE `status` != 1;