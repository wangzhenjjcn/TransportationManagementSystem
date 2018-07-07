/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : myazure_transit

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-08 00:16:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cushion`
-- ----------------------------
DROP TABLE IF EXISTS `cushion`;
CREATE TABLE `cushion` (
  `cushion_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(11) unsigned NOT NULL,
  `payout` bigint(11) unsigned NOT NULL,
  `pay_time` datetime NOT NULL,
  `creator_user_id` bigint(11) unsigned NOT NULL,
  `remarks` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remarkspy` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cushion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of cushion
-- ----------------------------
INSERT INTO `cushion` VALUES ('1', '1', '12', '2018-07-05 00:14:28', '1', '好的', 'hd', '2018-07-05 00:14:54', '2018-07-05 00:16:53');
INSERT INTO `cushion` VALUES ('2', '1', '33', '2018-07-04 00:15:02', '1', '能', 'n', '2018-07-05 00:15:11', '2018-07-05 00:17:01');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `namepy` varchar(25) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `addresspy` varchar(25) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '未设置', '未设置', '未设置', '未设置', '未设置', '000000', '2018-06-26 10:19:11', '2018-07-04 18:18:06');
INSERT INTO `customer` VALUES ('4', '王振', 'wz', '金鸡湖大道1355号', 'jjhdd1355h', '王振', '15106205593', '2018-07-06 07:10:38', '2018-07-06 07:10:38');
INSERT INTO `customer` VALUES ('5', '王师傅', 'wsf', '金鸡湖大道国际科技园1355号二期C区501室', 'jjhddgjkjy1355heqCq501s', '王振', '15106205593', '2018-07-06 16:55:59', '2018-07-06 16:55:59');

-- ----------------------------
-- Table structure for `data`
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `mKey` varchar(500) NOT NULL,
  `mValue` varchar(5000) NOT NULL,
  PRIMARY KEY (`mKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------

-- ----------------------------
-- Table structure for `driver`
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `driver_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `namepy` varchar(25) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('1', 'default', 'd', '000000', '2018-07-04 16:52:49', '2018-07-04 16:52:49');
INSERT INTO `driver` VALUES ('2', '王振', null, '15106205593', '2018-07-06 11:18:08', '2018-07-06 11:18:08');
INSERT INTO `driver` VALUES ('3', '王师傅', 'wsf', '15106205593', '2018-07-06 11:19:05', '2018-07-06 11:19:05');

-- ----------------------------
-- Table structure for `factory`
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory` (
  `factory_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `namepy` varchar(25) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `addresspy` varchar(25) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`factory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory
-- ----------------------------
INSERT INTO `factory` VALUES ('1', 'default', 'default', 'default', 'default', 'default', '000000000', '2018-06-26 10:18:48', '2018-07-03 16:31:45');
INSERT INTO `factory` VALUES ('4', '药尚网', 'ysw', '金鸡湖大道1355号国际科技园二期C区501室', 'jjhdd1355hgjkjyeqcq501c', '王振', '15106205593', '2018-07-06 07:36:17', '2018-07-06 07:37:23');
INSERT INTO `factory` VALUES ('5', '三星半导体苏州有限公司', null, '星港街133号星海厂房', null, '三星', '0512-88887776', '2018-07-06 17:03:19', '2018-07-06 17:03:19');
INSERT INTO `factory` VALUES ('6', '骐达商贸有限公司', 'qdsmyxgs', '景德镇市浮梁县下街街上', 'jdzsflxxjjs', '王师傅', '0333-88887776', '2018-07-06 17:05:19', '2018-07-06 17:05:19');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `order_creat_date` datetime DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_state` int(2) unsigned DEFAULT '0',
  `creator_user_id` bigint(11) unsigned DEFAULT NULL,
  `customer_user_id` bigint(11) unsigned DEFAULT NULL,
  `transport_driver_user_id` bigint(11) unsigned DEFAULT NULL,
  `delivery_driver_user_id` bigint(11) unsigned DEFAULT NULL,
  `factory_user_id` bigint(11) unsigned DEFAULT NULL,
  `transport_vehicle_id` bigint(11) unsigned DEFAULT NULL,
  `transport_vehicle_driver_id` bigint(11) unsigned DEFAULT NULL,
  `delivery_vehicle_id` bigint(11) unsigned DEFAULT NULL,
  `delivery_vehicle_driver_id` bigint(11) unsigned DEFAULT NULL,
  `customer_id` bigint(11) unsigned DEFAULT NULL,
  `factory_id` bigint(11) DEFAULT NULL,
  `plan_id` bigint(11) unsigned DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `distence` int(11) DEFAULT NULL,
  `entry_number` varchar(255) DEFAULT NULL,
  `customer_number` varchar(30) DEFAULT NULL,
  `pickup_number` varchar(255) DEFAULT NULL,
  `transfer_number` varchar(255) DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sourcepy` varchar(25) DEFAULT NULL,
  `destination` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `destinationpy` varchar(25) DEFAULT NULL,
  `packages` int(11) DEFAULT NULL,
  `freight_tpye` int(1) DEFAULT '0',
  `transport_vehicle_registration_number` varchar(9) DEFAULT NULL,
  `delivery_vehicle_registration_number` varchar(9) DEFAULT NULL,
  `carriage_fee` int(11) DEFAULT NULL,
  `cushion_fee` int(11) DEFAULT NULL,
  `contact` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `contactpy` varchar(25) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `is_chartered` bit(1) DEFAULT NULL,
  `fee_time` int(2) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `remarkspy` varchar(25) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2030 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2018-07-05 00:06:14', '2018-07-05 00:06:14', '0', '1', '1', '1', '1', '1', '1', null, '1', null, '1', '1', '1', '5', '26', '19477', 'cOiaoTgU', 'CSN96959', 'zHJQLdMYFTcb', 'tUAFmWTx', '上海', 'sh', '苏州', 'sz', '53', '1', 'default', 'default', '939', '0', 'TEST850NAME', null, '13957993032', '', '1', 'PthMutUQxT', null, '2018-07-05 00:06:14', '2018-07-05 00:13:38');
INSERT INTO `orders` VALUES ('2016', '2018-07-06 18:03:19', '2018-07-06 18:03:19', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '13', '55', '37878', 'VZyixQyk', 'CSN10635', 'lqQMMuieinGO', 'hiBvZlom', '上海', 'sh', '苏州', 'sz', '80', '4', 'default', 'default', '371', '0', '王师傅', 'wsf', '13996987820', '', '5', 'tlfqCPhaiy', 'tlfqCPhaiy', '2018-07-06 18:03:19', '2018-07-06 18:03:19');
INSERT INTO `orders` VALUES ('2017', '2018-07-06 18:04:15', '2018-07-06 18:04:15', '0', '1', '1', '1', '1', '1', '2', '1', '5', '1', '1', '1', '1', '0', '41', '50034', 'idguMIxL', 'CSN90664', 'AmQkgnIGLYIP', 'slWVdTmp', '上海', 'sh', '苏州', 'sz', '92', '3', 'default', 'default', '197', '0', '王师傅', 'wsf', '13981695419', '', '5', 'BKOZSOsZnY', 'BKOZSOsZnY', '2018-07-06 18:04:15', '2018-07-06 19:49:44');
INSERT INTO `orders` VALUES ('2018', '2018-07-06 18:04:16', '2018-07-06 18:04:16', '0', '1', '1', '1', '1', '1', '3', '1', '2', '1', '1', '1', '1', '80', '28', '93957', 'FhMiVotG', 'CSN96259', 'UQDGVnyfXwZH', 'hSomgGhj', '上海', 'sh', '苏州', 'sz', '77', '6', 'default', 'default', '472', '0', '王师傅', 'wsf', '13988637771', '', '5', 'PkPJGGuYMl', 'PkPJGGuYMl', '2018-07-06 18:04:16', '2018-07-06 19:49:43');
INSERT INTO `orders` VALUES ('2019', '2018-07-06 18:04:16', '2018-07-06 18:04:16', '0', '1', '1', '1', '1', '1', '3', '2', '2', '3', '4', '4', '3', '12', '31', '123', 'JLHCM551006', '1006', '0A115-0497695', 'SUZ18JQLG465', '浦德莎', 'pds', '外高桥凤威', 'wgqfw', '4', '1', '苏KTT82S', '苏EMM977', '200', '420', '锦诚', 'jc', '0512-87362632', '', '2', '长3.4M 销毁搞定费100', 'z3.4M xhgdf100', '2018-07-06 18:04:16', '2018-07-06 21:03:55');
INSERT INTO `orders` VALUES ('2020', '2018-07-06 18:04:16', '2018-07-06 18:04:16', '0', '1', '1', '1', '1', '1', '2', '1', '4', '1', '1', '1', '1', '2', '32', '43764', 'jntEJOps', 'CSN49311', 'JfyekRPcrlzv', 'mjCtPsSF', '上海', 'sh', '苏州', 'sz', '9', '1', 'default', 'default', '812', '0', '王师傅', 'wsf', '13945339169', '', '0', 'dTAjLrzqgV', 'dTAjLrzqgV', '2018-07-06 18:04:16', '2018-07-06 19:49:46');
INSERT INTO `orders` VALUES ('2021', '2018-07-06 18:04:16', '2018-07-06 18:04:16', '0', '1', '1', '1', '1', '1', '4', '1', '2', '1', '1', '1', '1', '84', '84', '30555', 'CUHpXOUJ', 'CSN74551', 'hGCgnGleuIdk', 'SIxbjvzJ', '上海', 'sh', '苏州', 'sz', '70', '5', 'default', 'default', '359', '0', '王师傅', 'wsf', '13926480844', '', '4', 'JFrHymddQm', 'JFrHymddQm', '2018-07-06 18:04:16', '2018-07-06 19:49:49');
INSERT INTO `orders` VALUES ('2022', '2018-07-06 18:04:17', '2018-07-06 18:04:17', '0', '1', '1', '1', '1', '1', '4', '1', '2', '1', '1', '1', '1', '45', '63', '51209', 'BnHRCdWI', 'CSN88061', 'XPJNhNdTICLo', 'bZkaXAue', '上海', 'sh', '苏州', 'sz', '24', '7', 'default', 'default', '238', '0', '王师傅', 'wsf', '13910218074', '', '1', 'IMzOUtEkhp', 'IMzOUtEkhp', '2018-07-06 18:04:17', '2018-07-06 19:49:49');
INSERT INTO `orders` VALUES ('2023', '2018-07-06 18:04:17', '2018-07-06 18:04:17', '0', '1', '1', '1', '1', '1', '4', '1', '2', '1', '1', '1', '1', '25', '60', '55935', 'vlsTpurv', 'CSN53848', 'ppAZdpxOydkR', 'nPQQcqbS', '上海', 'sh', '苏州', 'sz', '63', '7', 'default', 'default', '747', '0', '王师傅', 'wsf', '13925342822', '', '2', 'CUCqCjwzCA', 'CUCqCjwzCA', '2018-07-06 18:04:17', '2018-07-06 19:49:50');
INSERT INTO `orders` VALUES ('2024', '2018-07-06 18:04:17', '2018-07-06 18:04:17', '0', '1', '1', '1', '1', '1', '2', '1', '3', '1', '1', '1', '1', '83', '76', '27712', 'HCDoaBXo', 'CSN81667', 'AyIDJNDQMdvN', 'QnztTSlu', '上海', 'sh', '苏州', 'sz', '55', '4', 'default', 'default', '742', '0', '王师傅', 'wsf', '13929636119', '', '9', 'LXWtoCfYyU', 'LXWtoCfYyU', '2018-07-06 18:04:17', '2018-07-06 19:49:50');
INSERT INTO `orders` VALUES ('2025', '2018-07-06 18:04:17', '2018-07-06 18:04:17', '0', '1', '1', '1', '1', '1', '4', '1', '2', '1', '1', '1', '1', '24', '66', '59869', 'aTKpkqRJ', 'CSN76076', 'sMkAZiMgGsvn', 'IQYkQMQF', '上海', 'sh', '苏州', 'sz', '57', '6', 'default', 'default', '138', '0', '王师傅', 'wsf', '13920636698', '', '3', 'IRiElvUePc', 'IRiElvUePc', '2018-07-06 18:04:17', '2018-07-06 19:49:52');
INSERT INTO `orders` VALUES ('2026', '2018-07-06 18:04:18', '2018-07-06 18:04:18', '0', '1', '1', '1', '1', '1', '2', '1', '1', '1', '1', '1', '1', '37', '8', '50529', 'IKQQZTdv', 'CSN55455', 'GctTiknjWAtM', 'dXkYZTed', '上海', 'sh', '苏州', 'sz', '30', '3', 'default', 'default', '5', '0', '王师傅', 'wsf', '13907412257', '', '8', 'tybwhZWkzE', 'tybwhZWkzE', '2018-07-06 18:04:18', '2018-07-06 19:49:57');
INSERT INTO `orders` VALUES ('2027', '2018-07-06 20:54:32', '2018-07-06 20:54:32', '0', '2', '1', '1', '1', '1', '3', '2', '2', '3', null, '4', '3', '12', '31', '123', 'JLHCM551006', '1006', '0A115-0497695', 'SUZ18JQLG465', '浦德莎', 'pds', '外高桥凤威', 'wgqfw', '4', '1', '苏KTT82S', '苏EMM977', '200', '420', '锦诚', 'jc', '0512-87362632', '', '2', '长3.4M 销毁搞定费100', 'z3.4M xhgdf100', '2018-07-06 20:54:32', '2018-07-06 20:54:32');
INSERT INTO `orders` VALUES ('2028', '2018-07-06 20:55:25', '2018-07-06 20:55:25', '0', '2', '1', '1', '1', '1', '3', '2', '2', '3', null, '4', '3', '122', '312', '1231', 'JLHCM551006', '1006', '0A115-0497695', 'SUZ18JQLG465', '浦德莎', 'pds', '外高桥凤威', 'wgqfw', '4', '1', '苏KTT82S', '苏EMM977', '200', '420', '锦诚', 'jc', '0512-87362632', '', '2', '长3.4M 销毁搞定费100', 'z3.4M xhgdf100', '2018-07-06 20:55:25', '2018-07-06 20:55:25');
INSERT INTO `orders` VALUES ('2029', '2018-07-07 19:13:40', '2018-07-07 19:13:40', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '18', '95', '64332', 'ISOGBDdr', 'CSN44367', 'sAnPpaNzEvKi', 'yehBNplY', '上海', 'sh', '苏州', 'sz', '60', '1', 'default', 'default', '368', '0', '王师傅', 'wsf', '13907029481', '', '9', 'qdeSRpNUHG', 'qdeSRpNUHG', '2018-07-07 19:13:40', '2018-07-07 19:13:40');

-- ----------------------------
-- Table structure for `payment`
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payment_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(11) unsigned NOT NULL,
  `payout` bigint(11) unsigned NOT NULL,
  `pay_time` datetime NOT NULL,
  `creator_user_id` bigint(11) unsigned NOT NULL,
  `remarks` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remarkspy` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '1', '12', '2018-07-05 00:14:28', '1', '好的', 'hd', '2018-07-05 00:14:54', '2018-07-05 00:16:53');
INSERT INTO `payment` VALUES ('2', '1', '33', '2018-07-04 00:15:02', '1', '能', 'n', '2018-07-05 00:15:11', '2018-07-05 00:17:01');

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `plan_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `freight_tpye` int(2) unsigned DEFAULT '1',
  `price` int(11) unsigned DEFAULT NULL,
  `chartered_price` int(11) unsigned DEFAULT NULL,
  `weight` int(11) unsigned DEFAULT NULL,
  `size` int(11) unsigned DEFAULT NULL,
  `distance` int(11) unsigned DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `company_namepy` varchar(25) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `sourcepy` varchar(25) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `destinationpy` varchar(25) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', '1', '0', '0', '0', '0', '0', 'default', 'd', 'default', 'd', 'default', 'd', '2018-07-03 15:08:07', '2018-07-06 20:15:26');
INSERT INTO `plan` VALUES ('2', '1', '80', '400', '1000', '1000', '50', '德邦物流有限公司', 'dbwlyxgs', '苏州', 'sz', '上海', 'sh', '2018-07-06 20:24:01', '2018-07-06 20:24:01');
INSERT INTO `plan` VALUES ('3', '1', '800', '4000', '1000', '1000', '500', '德邦物流有限公司', 'dbwlyxgs', '苏州', 'sz', '上海', 'sh', '2018-07-06 20:24:50', '2018-07-06 20:24:50');
INSERT INTO `plan` VALUES ('4', '1', '8', '400', '10', '10', '5', '德邦物流有限公司', 'dbwlyxgs', '苏州', 'sz', '上海', 'sh', '2018-07-06 20:25:05', '2018-07-06 20:25:05');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(25) DEFAULT NULL,
  `pass_word` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `salt` varchar(25) DEFAULT NULL,
  `role` int(1) DEFAULT NULL,
  `role_id` bigint(11) unsigned DEFAULT NULL,
  `role_string` varchar(255) DEFAULT NULL,
  `role_string_py` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT NULL,
  `last_login_time` varchar(25) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'default', null, '默认', null, '-1', '1', '超级管理员', 'cjgly', null, null, null, '2018-07-03 15:02:31', '2018-07-05 04:20:13');
INSERT INTO `user` VALUES ('2', 'wangzhen', '986986', '王振', '12321309', '-1', '1', '超级管理员', 'cjgly', '97C112376670EF2220E998920463A317', '127.0.0.1', '1530945209838', '2018-07-05 08:44:22', '2018-07-07 14:33:30');

-- ----------------------------
-- Table structure for `vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vehicle_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `car_license_plate` varchar(255) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', 'default', '2018-07-03 15:06:00', '2018-07-04 16:49:47');
INSERT INTO `vehicle` VALUES ('2', '苏EMM977', '2018-07-06 07:47:52', '2018-07-06 07:47:52');
INSERT INTO `vehicle` VALUES ('3', '苏KTT82S', '2018-07-06 07:48:03', '2018-07-06 07:48:03');
INSERT INTO `vehicle` VALUES ('4', '甘T12987', '2018-07-06 07:48:16', '2018-07-06 07:48:16');
INSERT INTO `vehicle` VALUES ('5', '沪ASDD23', '2018-07-06 07:48:35', '2018-07-06 07:48:35');
INSERT INTO `vehicle` VALUES ('6', '苏EK197C', '2018-07-06 07:48:46', '2018-07-06 07:48:46');
