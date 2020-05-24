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

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  `name` varchar(128) NOT NULL COMMENT '附件名称',
  `original_name` varchar(128) NOT NULL COMMENT '原附件名称',
  `path` varchar(255) NOT NULL COMMENT '附件路径',
  `size` bigint(20) NOT NULL COMMENT '文件大小KB',
  `module_code` varchar(32) NOT NULL COMMENT '模块标识',
  `source_code` varchar(32) NOT NULL COMMENT '来源标识',
  `url` varchar(255) DEFAULT NULL COMMENT '访问url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='基础表';

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`gmt_create`,`create_id`,`gmt_modified`,`modified_id`,`is_deleted`,`version`,`name`,`original_name`,`path`,`size`,`module_code`,`source_code`,`url`) values (1,'2020-05-24 10:04:40',1,NULL,NULL,0,1,'下载.jpg','','/data/file/下载-1590314680212.jpg',36936,'1','1',NULL),(2,'2020-05-24 10:11:26',1,NULL,NULL,0,1,'下载.jpg','','/data/file/下载-1590315086191.jpg',36936,'1','1',NULL),(3,'2020-05-24 10:12:35',1,NULL,NULL,0,1,'下载.jpg','','/data/file/下载-1590315155148.jpg',36936,'1','1',NULL),(4,'2020-05-24 10:12:52',1,NULL,NULL,0,1,'下载.jpg','','/data/file/下载-1590315172238.jpg',36936,'1','1',NULL),(5,'2020-05-24 10:13:47',1,NULL,NULL,0,1,'下载.jpg','','/data/file/下载-1590315227323.jpg',36936,'1','1',NULL),(6,'2020-05-24 10:17:54',1,NULL,NULL,0,1,'下载.jpg','','H:/file/下载-1590315473739.jpg',36936,'1','1',NULL),(7,'2020-05-24 10:19:59',1,NULL,NULL,0,1,'下载.jpg','','H:/file/下载-1590315598788.jpg',36936,'1','1',NULL),(8,'2020-05-24 10:20:50',1,NULL,NULL,0,1,'下载.jpg','','H:/data/下载-1590315650276.jpg',36936,'1','1',NULL),(9,'2020-05-24 10:21:44',1,NULL,NULL,0,1,'下载.jpg','','H:/data/下载-1590315685527.jpg',36936,'1','1',NULL),(10,'2020-05-24 11:33:52',1,NULL,NULL,0,1,'e15f8ad238aa4e108cae259389f2dbf2.jpg','下载.jpg','D:\\file\\20200524\\',36936,'1','1',NULL);

/*Table structure for table `dict` */

DROP TABLE IF EXISTS `dict`;

CREATE TABLE `dict` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  `name` varchar(64) NOT NULL COMMENT '数据字典名称',
  `code` varchar(64) NOT NULL COMMENT '数据字典唯一标识',
  `remark` varchar(255) NOT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础表';

/*Data for the table `dict` */

/*Table structure for table `dict_detail` */

DROP TABLE IF EXISTS `dict_detail`;

CREATE TABLE `dict_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  `dict_id` bigint(20) NOT NULL COMMENT '数据字典id',
  `key` varchar(64) NOT NULL COMMENT '数据字典详情唯一编号',
  `value` varchar(128) NOT NULL COMMENT '值',
  `label` varchar(128) NOT NULL COMMENT '标签名称',
  `sort` int(4) NOT NULL DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础表';

/*Data for the table `dict_detail` */

/*Table structure for table `generator_test` */

DROP TABLE IF EXISTS `generator_test`;

CREATE TABLE `generator_test` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  `name` varchar(64) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础表';

/*Data for the table `generator_test` */

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  `name` varchar(64) NOT NULL COMMENT '权限名称',
  `code` varchar(64) NOT NULL COMMENT '权限标识',
  `icon` varchar(64) NOT NULL COMMENT '菜单图片',
  `p_id` bigint(20) NOT NULL COMMENT '父级id',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `type` tinyint(1) NOT NULL COMMENT '类型：1 菜单 2 按钮 3 资源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `sys_resource` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `remark` varchar(255) NOT NULL COMMENT '备注信息',
  `code` varchar(32) NOT NULL COMMENT '角色code',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `resource_id` bigint(20) unsigned NOT NULL COMMENT '资源id',
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

/*Data for the table `sys_role_resource` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  `username` varchar(64) NOT NULL COMMENT '用户登入账号',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  `nick_name` varchar(128) NOT NULL COMMENT '昵称',
  `avatar` varchar(255) NOT NULL COMMENT '头像地址',
  `phone` char(11) NOT NULL COMMENT '电话号码',
  `latest_time` datetime DEFAULT NULL COMMENT '最新登入时间',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：1启用、0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`gmt_create`,`create_id`,`gmt_modified`,`modified_id`,`is_deleted`,`version`,`username`,`password`,`nick_name`,`avatar`,`phone`,`latest_time`,`is_enabled`) values (1,'2020-05-24 15:47:56',1,'2020-05-24 15:48:00',NULL,0,1,'sysAdmin','$2a$10$6OnsvtaSLlrYIWPD56nrdeGh.BPER7SVHLAcJwXpPcdtYCDJ7vjSa','sysAdmin','','12345678911',NULL,1);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

/*Data for the table `sys_user_role` */

/*Table structure for table `t_base` */

DROP TABLE IF EXISTS `t_base`;

CREATE TABLE `t_base` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_id` bigint(20) unsigned NOT NULL COMMENT '创建者用户id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `modified_id` bigint(20) unsigned DEFAULT NULL COMMENT '更新者用户id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础表';

/*Data for the table `t_base` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
