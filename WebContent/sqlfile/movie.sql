GRANT ALL PRIVILEGES ON *.*  TO 'javaDB'@'localhost 'IDENTIFIED BY 'javaDB' WITH GRANT OPTION;
show databases;
DROP database movie_db;
CREATE database movie_db;
use movie_db;

DROP TABLE tiket_info;
DROP TABLE theater;
DROP TABLE tblMember;
DROP TABLE seat;
DROP TABLE time_info;

CREATE TABLE `tblMember` (
  `id` VARCHAR(20) NOT NULL,
  `pass` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `theater` (
  `theaterNum` int (20) NOT NULL,
  `totalSeat` int (20) NOT NULL,
  PRIMARY KEY (`theaterNum`)
);
CREATE TABLE `seat` (
  `rowChar` CHAR (1) NOT NULL,
  `columnNum` int (20) NOT NULL,
  `theaterNum` int (20) NOT NULL,
  `state` int(20) NOT NULL default 0,
  FOREIGN KEY (theaterNum) references theater(theaterNum),
  PRIMARY KEY (`rowChar`, `columnNum`,`theaterNum`)
);
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
CREATE TABLE `tiket_info`(
	`time_id` int(20) NOT NULL,
	`id` VARCHAR(20) NOT NULL,
    `seat_id` VARCHAR (100) NOT NULL,
    `theaterNum` int (20) NOT NULL,
    `movieNm` VARCHAR(100) NOT NULL,
    `startTime` VARCHAR(20) NOT NULL,
     PRIMARY KEY (`time_id`,`id`),
	 FOREIGN KEY (time_id) references time_info(time_id) ON UPDATE CASCADE ON DELETE CASCADE,
     FOREIGN KEY (id) references tblMember(id) ON UPDATE CASCADE ON DELETE CASCADE,
     FOREIGN KEY (theaterNum) references theater(theaterNum) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT tblMember(id,pass,name,phone) VALUES('admin','admin','관리자','01011111111');

insert theater(theaterNum,totalSeat) values('1','10');
insert theater(theaterNum,totalSeat) values('2','10');
insert theater(theaterNum,totalSeat) values('3','10');

insert seat (rowChar,columnNum,theaterNum) values ('A',1,1);
insert seat (rowChar,columnNum,theaterNum) values ('A',2,1);
insert seat (rowChar,columnNum,theaterNum) values ('A',3,1);
insert seat (rowChar,columnNum,theaterNum) values ('A',4,1);
insert seat (rowChar,columnNum,theaterNum) values ('A',5,1);
insert seat (rowChar,columnNum,theaterNum) values ('B',1,1);
insert seat (rowChar,columnNum,theaterNum) values ('B',2,1);
insert seat (rowChar,columnNum,theaterNum) values ('B',3,1);
insert seat (rowChar,columnNum,theaterNum) values ('B',4,1);
insert seat (rowChar,columnNum,theaterNum) values ('B',5,1);

insert seat (rowChar,columnNum,theaterNum) values ('A',1,2);
insert seat (rowChar,columnNum,theaterNum) values ('A',2,2);
insert seat (rowChar,columnNum,theaterNum) values ('A',3,2);
insert seat (rowChar,columnNum,theaterNum) values ('A',4,2);
insert seat (rowChar,columnNum,theaterNum) values ('A',5,2);
insert seat (rowChar,columnNum,theaterNum) values ('B',1,2);
insert seat (rowChar,columnNum,theaterNum) values ('B',2,2);
insert seat (rowChar,columnNum,theaterNum) values ('B',3,2);
insert seat (rowChar,columnNum,theaterNum) values ('B',4,2);
insert seat (rowChar,columnNum,theaterNum) values ('B',5,2);
