/*
Navicat MySQL Data Transfer

Source Server         : ch10
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-01-05 08:27:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `buycar`
-- ----------------------------
DROP TABLE IF EXISTS `buycar`;
CREATE TABLE `buycar` (
  `productname` varchar(255) NOT NULL,
  `productfare` double DEFAULT NULL,
  `fahuo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buycar
-- ----------------------------
INSERT INTO `buycar` VALUES ('德国球衣', '1', '未发货');
INSERT INTO `buycar` VALUES ('荷兰球衣', '1', '未发货');
INSERT INTO `buycar` VALUES ('阿根廷球衣', '1', '未发货');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customername` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('11', '11');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productname` varchar(255) NOT NULL DEFAULT '',
  `productnum` int(11) DEFAULT NULL,
  `productfare` double DEFAULT NULL,
  PRIMARY KEY (`productname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('中国球衣', '97', '56');
INSERT INTO `product` VALUES ('巴西球衣', '110', '60');
INSERT INTO `product` VALUES ('德国球衣', '234', '65');
INSERT INTO `product` VALUES ('法国球衣', '45', '42');
INSERT INTO `product` VALUES ('英格兰球衣', '60', '64');
INSERT INTO `product` VALUES ('西班牙球衣', '45', '50');
INSERT INTO `product` VALUES ('阿根廷球衣', '126', '48');

-- ----------------------------
-- Table structure for `shopuser`
-- ----------------------------
DROP TABLE IF EXISTS `shopuser`;
CREATE TABLE `shopuser` (
  `shopusername` varchar(255) NOT NULL DEFAULT '',
  `password` int(11) NOT NULL,
  PRIMARY KEY (`shopusername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopuser
-- ----------------------------
INSERT INTO `shopuser` VALUES ('22', '22');
