/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.23 : Database - food
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`food` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `food`;

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `customerid` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

/*Table structure for table `t_food` */

DROP TABLE IF EXISTS `t_food`;

CREATE TABLE `t_food` (
  `foodid` int(11) NOT NULL AUTO_INCREMENT,
  `foodname` varchar(40) NOT NULL,
  `unitprice` double DEFAULT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_food` */

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `orderid` int(30) NOT NULL AUTO_INCREMENT,
  `food` int(11) DEFAULT NULL,
  `foodnum` int(2) DEFAULT NULL,
  `customer` int(30) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `food` (`food`),
  KEY `customer` (`customer`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`food`) REFERENCES `t_food` (`foodid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`customer`) REFERENCES `t_customer` (`customerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
