
CREATE DATABASE `dict`;

USE `dict`;



DROP TABLE IF EXISTS `dict`;

CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `name` varchar(255) NOT NULL COMMENT '数据字典名称',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


insert  into `dict`(`id`,`deleted`,`name`,`remark`) values (1,0,'操作结果','操作结果');


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


insert  into `dict_detail`(`id`,`deleted`,`dict_id`,`key`,`value`,`label`,`sort`) values (1,0,1,'success','1','成功',1),(2,0,1,'fail','2','失败',2);


