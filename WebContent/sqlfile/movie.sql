GRANT ALL PRIVILEGES ON *.*  TO 'javaDB'@'localhost 'IDENTIFIED BY 'javaDB' WITH GRANT OPTION;
show databases;
drop database movie_db;
create database movie_db;
use movie_db;
CREATE TABLE `tblMember` (
  `id` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);