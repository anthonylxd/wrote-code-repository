/*
Navicat MySQL Data Transfer

Source Server         : ch10
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : ocs

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-09-17 21:53:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `host`
-- ----------------------------
DROP TABLE IF EXISTS `host`;
CREATE TABLE `host` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of host
-- ----------------------------
INSERT INTO `host` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL DEFAULT '0',
  `ordermoney` float DEFAULT NULL,
  `orderkind` varchar(255) DEFAULT NULL,
  `ordertime` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `agentId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `isPay` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '100', '1', '1994.10.10', '1', '1', '1', '发货');

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `title` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `zan` int(11) DEFAULT NULL,
  `agentname` varchar(255) DEFAULT NULL,
  `customername` varchar(255) DEFAULT NULL,
  `pay` varchar(255) DEFAULT NULL,
  `send` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('', '2', '', '0', '', '', '已付款', '未发货');
INSERT INTO `post` VALUES ('1', '1', '2017-01-20', '2', '1', '1', '已付款', '已发货');
INSERT INTO `post` VALUES ('1212', '1', '2014-03-12', '12', '12', '12', '未付款', '已发货');
INSERT INTO `post` VALUES ('2', '1', '', '0', '', '', '未付款', '已发货');
INSERT INTO `post` VALUES ('3', '1', '2', '2', '2', '2', '未付款', '已发货');
INSERT INTO `post` VALUES ('4', '3', '4', '4', '4', '4', '未付款', '未发货');
INSERT INTO `post` VALUES ('5', '3', '2016-10-12', '1234', '1', '2', '未付款', '已发货');
INSERT INTO `post` VALUES ('手机', '2', '2016-10-12', '1200', '12', '12', '未付款', '已付款');
INSERT INTO `post` VALUES ('水果什锦', '1', '2014-03-12', '1200', '奇葩舍', '奇葩舍', '未付款', '已发货');
INSERT INTO `post` VALUES ('苹果5000', '2', '2014-03-12', '20000', '济南代理商', '零售店', '已付款', '未发货');
INSERT INTO `post` VALUES ('西瓜一顿', '2', '2016-10-12', '10000', '东方超市', '东方超市', '未付款', '未发货');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL DEFAULT '0',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '3', '3');
INSERT INTO `user` VALUES ('1', '1', '1');
INSERT INTO `user` VALUES ('2', '2', '2');
