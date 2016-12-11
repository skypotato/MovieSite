GRANT ALL PRIVILEGES ON *.*  TO 'javaDB'@'localhost 'IDENTIFIED BY 'javaDB' WITH GRANT OPTION;
show databases;
DROP database movie_db;
CREATE database movie_db;
use movie_db;
DROP TABLE tblMember;
CREATE TABLE `tblMember` (
  `id` VARCHAR(20) NOT NULL,
  `pass` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT tblMember(id,pass,name,phone) VALUES('admin','admin','관리자','01011111111');

DROP TABLE theater;
CREATE TABLE `theater` (
  `theaterNum` int (20) NOT NULL,
  `totalSeat` int (20) NOT NULL,
  PRIMARY KEY (`theaterNum`)
);
DROP TABLE seat;
CREATE TABLE `seat` (
  `seatNum` int (20) NOT NULL,
  `theaterNum` int (20) NOT NULL,
  `state` int(20) NOT NULL default 0,
  FOREIGN KEY (theaterNum) references theater(theaterNum),
  PRIMARY KEY (`seat_id`,`theaterNum`)
);
DROP TABLE time_info;
CREATE TABLE `time_info` (
  `time_id` int (20) NOT NULL auto_increment,
  `movieCd` int (20) NOT NULL,
  `movieNm` VARCHAR(20) NOT NULL,
  `theaterNum` int (20) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `startTime` VARCHAR(20) NOT NULL,
  `endTime` VARCHAR(20) NOT NULL,
  FOREIGN KEY (theaterNum) references theater(theaterNum),
  PRIMARY KEY (`time_id`)
);