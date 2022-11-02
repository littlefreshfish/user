/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : mail

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2022-11-02 20:31:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('2', 'cc', 'js', '123');
INSERT INTO `account` VALUES ('3', 'cc2', 'js2', '123');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `address_default` int(11) DEFAULT '0' COMMENT '是否默认地址 1 是 0 否',
  `receiver_name` varchar(255) DEFAULT NULL,
  `order_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES ('1', '523453453', '1', '0', '22', '123');
INSERT INTO `user_address` VALUES ('2', '重庆市渝北区观音桥步行街', '1', '1', '22', '123');
INSERT INTO `user_address` VALUES ('26', 'asdfasdfasdfasdfa', '3', '1', '小苗', '123456789');
INSERT INTO `user_address` VALUES ('27', 'sdfadfas', '3', '0', '小苗as', '123456789');
INSERT INTO `user_address` VALUES ('28', 'sdfadfas', '3', '0', '小苗as', '123456789');
INSERT INTO `user_address` VALUES ('29', 'sdfadfas', '3', '0', '小苗as', '123456789');
INSERT INTO `user_address` VALUES ('30', 'asdfasfda', '3', '0', 'asdf', '12345');
INSERT INTO `user_address` VALUES ('31', 'aasdf', '3', '0', 'affsad', '1212');
