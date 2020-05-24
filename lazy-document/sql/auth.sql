
CREATE DATABASE `auth` ;

USE `auth`;

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` int(11) NOT NULL COMMENT '菜单ID',
  `uuid` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_id` int(11) NOT NULL,
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_id` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记(0--正常 1--删除)',
  `version` int(1) NOT NULL DEFAULT '1',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `permission` varchar(64) NOT NULL COMMENT '资源权限标识',
  `parent_id` int(11) NOT NULL COMMENT '父菜单ID',
  `modeule_name` varchar(64) NOT NULL COMMENT '模块名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

/*Data for the table `sys_resource` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_time` datetime NOT NULL,
  `create_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_id` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '1',
  `role_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `role_name` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `role_code` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_idx1_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='系统角色表';

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uuid` varchar(64) NOT NULL COMMENT '通用唯一识别码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `created_id` int(11) NOT NULL COMMENT '创建者id',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_id` int(11) NOT NULL COMMENT '更新者id',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `resource_id` int(11) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_resource` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uuid` varchar(64) NOT NULL COMMENT '通用唯一识别码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_id` int(11) NOT NULL COMMENT '创建者id',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_id` int(11) NOT NULL COMMENT '更新者id',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `version` int(4) NOT NULL DEFAULT '1' COMMENT '版本号',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nick_name` varchar(255) NOT NULL COMMENT '昵称',
  `avatar_path` varchar(255) NOT NULL COMMENT '头像',
  `enabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否生效',
  PRIMARY KEY (`id`),
  KEY `主键` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`uuid`,`create_time`,`create_id`,`update_time`,`update_id`,`deleted`,`version`,`username`,`password`,`nick_name`,`avatar_path`,`enabled`) values (1,'84f1a7717bde430e9cf85291122b88f5','2020-05-17 03:35:36',1,'2020-05-17 03:35:36',1,0,0,'sysAdmin','$2a$10$6OnsvtaSLlrYIWPD56nrdeGh.BPER7SVHLAcJwXpPcdtYCDJ7vjSa','超级管理员','',1),(2,'839143fd2ae7488e8eb70119be947caa','2020-05-17 03:52:29',1,'2020-05-17 03:52:29',1,0,0,'zhuwj','$2a$10$9PG3xPIXtuvDIFCCK7ACR.9C2ESIYD2d5ZzCWwVfGuV1/8wQ1KTSm','普通用户','',1);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uuid` varchar(64) NOT NULL COMMENT '通用唯一识别码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `created_id` int(11) NOT NULL COMMENT '创建者id',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_id` int(11) NOT NULL COMMENT '更新者id',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关系表用户角色';

/*Data for the table `sys_user_role` */

/*Table structure for table `t_base` */

DROP TABLE IF EXISTS `t_base`;

CREATE TABLE `t_base` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uuid` varchar(64) NOT NULL COMMENT '通用唯一识别码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `created_id` int(11) NOT NULL COMMENT '创建者id',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_id` int(11) NOT NULL COMMENT '更新者id',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_base` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
