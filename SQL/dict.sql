/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.7.27-log : Database - lazy_notes
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lazy_notes` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lazy_notes`;

/*Table structure for table `dict` */

DROP TABLE IF EXISTS `dict`;

CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `name` varchar(255) NOT NULL COMMENT '数据字典名称',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `dict` */

insert  into `dict`(`id`,`deleted`,`name`,`remark`) values (1,0,'操作结果','操作结果');

/*Table structure for table `dict_detail` */

DROP TABLE IF EXISTS `dict_detail`;

CREATE TABLE `dict_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `dict_id` int(11) NOT NULL COMMENT '数据字典id',
  `key` varchar(255) NOT NULL COMMENT '唯一key',
  `value` varchar(255) NOT NULL COMMENT '值',
  `label` varchar(255) NOT NULL COMMENT '标签',
  `sort` int(4) NOT NULL DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `dict_detail` */

insert  into `dict_detail`(`id`,`deleted`,`dict_id`,`key`,`value`,`label`,`sort`) values (1,0,1,'success','1','成功',1),(2,0,1,'fail','2','失败',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
