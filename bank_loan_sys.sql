CREATE DATABASE IF NOT EXISTS bank_loan_sys default charset utf8 COLLATE utf8_general_ci;

USE bank_loan_sys;
drop TABLE if EXISTS `bank_info`;
CREATE TABLE IF NOT EXISTS `bank_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
 `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
 `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
 `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='银行管理员';


drop TABLE if EXISTS `school_info`;
CREATE TABLE IF NOT EXISTS `school_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
 `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
 `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
 `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学校管理员';


drop TABLE if EXISTS `student_info`;
CREATE TABLE IF NOT EXISTS `student_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `name` varchar(255) DEFAULT NULL COMMENT '学号',
 `pass_word` varchar(255) DEFAULT NULL COMMENT '登录密码',
 `school_id` int(11) DEFAULT NULL COMMENT '所属学校',
 `is_black` int(11) DEFAULT NULL COMMENT '是否黑名单',
 `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
 `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
 `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生';


drop TABLE if EXISTS `load_apply_info`;
CREATE TABLE IF NOT EXISTS `load_apply_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `stu_id` int(11) DEFAULT NULL COMMENT '学生学号',
 `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
 `id_number` varchar(255) DEFAULT NULL COMMENT '身份证号',
 `idnumber_img1` varchar(255) DEFAULT NULL COMMENT '身份证正面',
 `idnumber_img2` varchar(255) DEFAULT NULL COMMENT '身份证反面',
 `cel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
 `pca` varchar(255) DEFAULT NULL COMMENT '现所在区域',
 `address` varchar(255) DEFAULT NULL COMMENT '现居地址',
 `money_amount` int(11) DEFAULT NULL COMMENT '欲贷金额（元）',
 `reason` varchar(255) DEFAULT NULL COMMENT '贷款原因',
 `prove_file` varchar(255) DEFAULT NULL COMMENT '相关证明',
 `redate` varchar(255) DEFAULT NULL COMMENT '还款日期',
 `reamount` int(11) DEFAULT NULL COMMENT '还款金额',
 `rest_amount` int(11) DEFAULT NULL COMMENT '剩余金额',
 `school_check_status` int(11) DEFAULT NULL COMMENT '学校审核状态',
 `school_check_remark` varchar(255) DEFAULT NULL COMMENT '学校审核备注',
 `bank_check_status` int(11) DEFAULT NULL COMMENT '银行审核状态',
 `bank_check_remark` varchar(255) DEFAULT NULL COMMENT '银行审核备注',
 `scool_id` int(11) DEFAULT NULL COMMENT '所属学校',
 `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
 `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
 `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='贷款申请';


drop TABLE if EXISTS `remoney_info`;
CREATE TABLE IF NOT EXISTS `remoney_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `amount` int(11) DEFAULT NULL COMMENT '还款金额',
 `apply_id` int(11) DEFAULT NULL COMMENT '申请',
 `user_id` int(11) DEFAULT NULL COMMENT '学生',
 `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
 `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
 `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='还款记录';



INSERT INTO `bank_loan_sys`.`bank_info` (`id`,`create_time`,`name`,`pass_word`,`is_delete`,`update_time`)  VALUES('1','2019-04-09 00:53:19','login1','123','0','2019-04-12 22:53:19');
INSERT INTO `bank_loan_sys`.`school_info` (`id`,`create_time`,`name`,`pass_word`,`is_delete`,`update_time`)  VALUES('1','2019-04-05 04:53:24','login1','123','0','2019-04-27 01:53:24');
INSERT INTO `bank_loan_sys`.`school_info` (`id`,`create_time`,`name`,`pass_word`,`is_delete`,`update_time`)  VALUES('2','2019-04-22 16:53:24','login2','123','0','2019-04-12 14:53:24');
INSERT INTO `bank_loan_sys`.`student_info` (`id`,`create_time`,`name`,`pass_word`,`is_delete`,`update_time`,`school_id`,`is_black`)  VALUES('1','2019-04-13 12:53:29','login1','123','0','2019-04-06 06:53:29','1','1');
INSERT INTO `bank_loan_sys`.`student_info` (`id`,`create_time`,`name`,`pass_word`,`is_delete`,`update_time`,`school_id`,`is_black`)  VALUES('2','2019-05-02 00:53:29','login2','123','0','2019-04-07 19:53:29','2','1');
INSERT INTO `bank_loan_sys`.`load_apply_info` (`id`,`create_time`,`is_delete`,`update_time`,`real_name`,`id_number`,`idnumber_img1`,`idnumber_img2`,`cel_phone`,`email`,`pca`,`address`,`money_amount`,`reason`,`prove_file`,`redate`,`reamount`,`rest_amount`,`school_check_status`,`school_check_remark`,`bank_check_status`,`bank_check_remark`,`scool_id`,`stu_id`)  VALUES('1','2019-04-03 23:53:36','0','2019-04-18 12:53:36','真实姓名1','身份证号1','null','null','联系电话1','邮箱1','广东 广州','现居地址1','53','贷款原因1','null','2019-04-03','0','#money_amount#','1','学校审核备注1','3','1','1','1');
INSERT INTO `bank_loan_sys`.`load_apply_info` (`id`,`create_time`,`is_delete`,`update_time`,`real_name`,`id_number`,`idnumber_img1`,`idnumber_img2`,`cel_phone`,`email`,`pca`,`address`,`money_amount`,`reason`,`prove_file`,`redate`,`reamount`,`rest_amount`,`school_check_status`,`school_check_remark`,`bank_check_status`,`bank_check_remark`,`scool_id`,`stu_id`)  VALUES('2','2019-04-11 15:53:36','0','2019-04-29 11:53:36','真实姓名2','身份证号2','null','null','联系电话2','邮箱2','广东 广州','现居地址2','17','贷款原因2','null','2019-04-24','0','#money_amount#','1','学校审核备注2','1','3','1','2');
INSERT INTO `bank_loan_sys`.`load_apply_info` (`id`,`create_time`,`is_delete`,`update_time`,`real_name`,`id_number`,`idnumber_img1`,`idnumber_img2`,`cel_phone`,`email`,`pca`,`address`,`money_amount`,`reason`,`prove_file`,`redate`,`reamount`,`rest_amount`,`school_check_status`,`school_check_remark`,`bank_check_status`,`bank_check_remark`,`scool_id`,`stu_id`)  VALUES('3','2019-04-11 15:53:36','0','2019-04-27 12:53:36','真实姓名3','身份证号3','null','null','联系电话3','邮箱3','广东 广州','现居地址3','44','贷款原因3','null','2019-04-08','0','#money_amount#','1','学校审核备注3','2','3','1','2');
INSERT INTO `bank_loan_sys`.`load_apply_info` (`id`,`create_time`,`is_delete`,`update_time`,`real_name`,`id_number`,`idnumber_img1`,`idnumber_img2`,`cel_phone`,`email`,`pca`,`address`,`money_amount`,`reason`,`prove_file`,`redate`,`reamount`,`rest_amount`,`school_check_status`,`school_check_remark`,`bank_check_status`,`bank_check_remark`,`scool_id`,`stu_id`)  VALUES('4','2019-04-06 13:53:36','0','2019-05-02 20:53:36','真实姓名4','身份证号4','null','null','联系电话4','邮箱4','广东 广州','现居地址4','76','贷款原因4','null','2019-04-07','0','#money_amount#','2','学校审核备注4','1','1','2','2');
INSERT INTO `bank_loan_sys`.`load_apply_info` (`id`,`create_time`,`is_delete`,`update_time`,`real_name`,`id_number`,`idnumber_img1`,`idnumber_img2`,`cel_phone`,`email`,`pca`,`address`,`money_amount`,`reason`,`prove_file`,`redate`,`reamount`,`rest_amount`,`school_check_status`,`school_check_remark`,`bank_check_status`,`bank_check_remark`,`scool_id`,`stu_id`)  VALUES('5','2019-04-25 00:53:36','0','2019-04-27 09:53:36','真实姓名5','身份证号5','null','null','联系电话5','邮箱5','广东 广州','现居地址5','30','贷款原因5','null','2019-04-25','0','#money_amount#','3','学校审核备注5','1','1','1','2');
INSERT INTO `bank_loan_sys`.`load_apply_info` (`id`,`create_time`,`is_delete`,`update_time`,`real_name`,`id_number`,`idnumber_img1`,`idnumber_img2`,`cel_phone`,`email`,`pca`,`address`,`money_amount`,`reason`,`prove_file`,`redate`,`reamount`,`rest_amount`,`school_check_status`,`school_check_remark`,`bank_check_status`,`bank_check_remark`,`scool_id`,`stu_id`)  VALUES('6','2019-04-07 20:53:36','0','2019-04-26 16:53:36','真实姓名6','身份证号6','null','null','联系电话6','邮箱6','广东 广州','现居地址6','49','贷款原因6','null','2019-04-12','0','#money_amount#','2','学校审核备注6','1','1','2','1');
INSERT INTO `bank_loan_sys`.`remoney_info` (`id`,`create_time`,`is_delete`,`update_time`,`amount`,`apply_id`,`user_id`)  VALUES('1','2019-04-07 21:53:40','0','2019-04-28 09:53:40','87','5','2');
INSERT INTO `bank_loan_sys`.`remoney_info` (`id`,`create_time`,`is_delete`,`update_time`,`amount`,`apply_id`,`user_id`)  VALUES('2','2019-04-04 04:53:40','0','2019-04-06 11:53:40','18','2','1');
INSERT INTO `bank_loan_sys`.`remoney_info` (`id`,`create_time`,`is_delete`,`update_time`,`amount`,`apply_id`,`user_id`)  VALUES('3','2019-04-07 01:53:40','0','2019-04-15 19:53:40','83','6','2');
INSERT INTO `bank_loan_sys`.`remoney_info` (`id`,`create_time`,`is_delete`,`update_time`,`amount`,`apply_id`,`user_id`)  VALUES('4','2019-05-02 19:53:40','0','2019-04-04 16:53:40','77','5','1');
INSERT INTO `bank_loan_sys`.`remoney_info` (`id`,`create_time`,`is_delete`,`update_time`,`amount`,`apply_id`,`user_id`)  VALUES('5','2019-04-14 06:53:40','0','2019-04-30 09:53:40','95','3','1');
INSERT INTO `bank_loan_sys`.`remoney_info` (`id`,`create_time`,`is_delete`,`update_time`,`amount`,`apply_id`,`user_id`)  VALUES('6','2019-04-16 22:53:40','0','2019-04-03 14:53:40','4','1','1');