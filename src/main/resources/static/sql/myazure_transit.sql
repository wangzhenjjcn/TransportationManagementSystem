/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : myazure_transit

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-05 00:21:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cushion`
-- ----------------------------
DROP TABLE IF EXISTS `cushion`;
CREATE TABLE `cushion` (
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '未设置', '未设置', '未设置', '未设置', '未设置', '000000', '2018-06-26 10:19:11', '2018-07-04 18:18:06');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('1', 'default', 'd', '000000', '2018-07-04 16:52:49', '2018-07-04 16:52:49');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory
-- ----------------------------
INSERT INTO `factory` VALUES ('1', 'default', 'default', 'default', 'default', 'default', '000000000', '2018-06-26 10:18:48', '2018-07-03 16:31:45');

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
  `delivery_vehicle_id` bigint(11) unsigned DEFAULT NULL,
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
  `shipping_type` int(11) DEFAULT NULL,
  `fee_time` int(2) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `remarkspy` varchar(25) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1903 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2018-07-05 00:06:14', '2018-07-05 00:06:14', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '5', '26', '19477', 'cOiaoTgU', 'CSN96959', 'zHJQLdMYFTcb', 'tUAFmWTx', '上海', 'sh', '苏州', 'sz', '53', '1', 'default', 'default', '939', '0', 'TEST850NAME', null, '13957993032', '', null, '1', 'PthMutUQxT', null, '2018-07-05 00:06:14', '2018-07-05 00:13:38');
INSERT INTO `orders` VALUES ('1890', '2018-07-05 00:12:58', '2018-07-05 00:12:58', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '80', '42', '93768', 'UXhaQJjH', 'CSN78525', 'aRIbJfWsZRMy', 'EPSIuLup', '上海', 'sh', '苏州', 'sz', '87', '1', 'default', 'default', '340', '0', '王师傅', null, '13906122066', '', null, '7', 'wTjSXBAAxe', null, '2018-07-05 00:12:58', '2018-07-05 00:12:58');
INSERT INTO `orders` VALUES ('1891', '2018-07-05 00:12:59', '2018-07-05 00:12:59', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '64', '8488', 'cHdsZsnC', 'CSN69281', 'OpWeTfDApSRg', 'ISlNiuDp', '上海', 'sh', '苏州', 'sz', '47', '1', 'default', 'default', '114', '0', '王师傅', null, '13985416333', '', null, '7', 'SlJnvUkhLv', null, '2018-07-05 00:12:59', '2018-07-05 00:12:59');
INSERT INTO `orders` VALUES ('1892', '2018-07-05 00:12:59', '2018-07-05 00:12:59', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '66', '37', '98714', 'lKbRDErG', 'CSN18188', 'JvHMhcheXJPF', 'CmLbRMFd', '上海', 'sh', '苏州', 'sz', '76', '1', 'default', 'default', '756', '0', '王师傅', null, '13967791464', '', null, '2', 'fYdCMOdoVm', null, '2018-07-05 00:12:59', '2018-07-05 00:12:59');
INSERT INTO `orders` VALUES ('1893', '2018-07-05 00:12:59', '2018-07-05 00:12:59', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '30', '55', '61007', 'gufgnbNz', 'CSN39706', 'tnrKooOtHeFW', 'bNgqAgaV', '上海', 'sh', '苏州', 'sz', '29', '1', 'default', 'default', '346', '0', '王师傅', null, '13982869328', '', null, '5', 'qWIbjfdRLT', null, '2018-07-05 00:12:59', '2018-07-05 00:12:59');
INSERT INTO `orders` VALUES ('1894', '2018-07-05 00:12:59', '2018-07-05 00:12:59', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '22', '81', '74132', 'NxNtvfhE', 'CSN58073', 'ETWOenwJMXms', 'oacwFAjg', '上海', 'sh', '苏州', 'sz', '77', '1', 'default', 'default', '521', '0', '王师傅', null, '13974925635', '', null, '7', 'XdJhYoibYE', null, '2018-07-05 00:12:59', '2018-07-05 00:12:59');
INSERT INTO `orders` VALUES ('1895', '2018-07-05 00:13:00', '2018-07-05 00:13:00', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '55', '34', '82238', 'FJoLfNAv', 'CSN93155', 'sLElvGUPfaAg', 'kbtZvXsS', '上海', 'sh', '苏州', 'sz', '39', '1', 'default', 'default', '128', '0', '王师傅', null, '13936888660', '', null, '7', 'iwWqkWizhH', null, '2018-07-05 00:13:00', '2018-07-05 00:13:00');
INSERT INTO `orders` VALUES ('1896', '2018-07-05 00:13:00', '2018-07-05 00:13:00', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '82', '77', '93497', 'vBHnWtab', 'CSN12176', 'sPAkLwngQlkq', 'NJKsxyoZ', '上海', 'sh', '苏州', 'sz', '98', '1', 'default', 'default', '140', '0', '王师傅', null, '13944948376', '', null, '3', 'sYYndNAaQm', null, '2018-07-05 00:13:00', '2018-07-05 00:13:00');
INSERT INTO `orders` VALUES ('1897', '2018-07-05 00:13:00', '2018-07-05 00:13:00', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '78', '57', '25890', 'cYmdfLWq', 'CSN06780', 'hDJxblKljHRL', 'qdmBYlFh', '上海', 'sh', '苏州', 'sz', '79', '1', 'default', 'default', '799', '0', '王师傅', null, '13978807070', '', null, '8', 'KlGpVgfGMP', null, '2018-07-05 00:13:00', '2018-07-05 00:13:00');
INSERT INTO `orders` VALUES ('1898', '2018-07-05 00:13:00', '2018-07-05 00:13:00', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '92', '64', '2029', 'OsheCsyj', 'CSN43133', 'GKzgmWnUCebk', 'aYcuwlJN', '上海', 'sh', '苏州', 'sz', '47', '1', 'default', 'default', '161', '0', '王师傅', null, '13924771627', '', null, '9', 'oYWhbQkWyH', null, '2018-07-05 00:13:00', '2018-07-05 00:13:00');
INSERT INTO `orders` VALUES ('1899', '2018-07-05 00:13:00', '2018-07-05 00:13:00', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '4', '85', '82218', 'OFHBtTTQ', 'CSN31120', 'aEXipqGjGyiD', 'ASTgkKPQ', '上海', 'sh', '苏州', 'sz', '25', '1', 'default', 'default', '907', '0', '王师傅', null, '13982407695', '', null, '4', 'idtuTjUoZz', null, '2018-07-05 00:13:00', '2018-07-05 00:13:00');
INSERT INTO `orders` VALUES ('1900', '2018-07-05 00:13:27', '2018-07-05 00:13:27', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '82', '53', '82043', 'bfzZEarE', 'CSN41658', 'NzeBbATHyvto', 'vobDbcVE', '上海', 'sh', '苏州', 'sz', '84', '1', 'default', 'default', '586', '0', '王师傅', null, '13975065418', '', null, '9', 'WJxFXVYmRh', null, '2018-07-05 00:13:27', '2018-07-05 00:13:27');
INSERT INTO `orders` VALUES ('1901', '2018-07-05 00:13:41', '2018-07-05 00:13:41', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '86', '13', '86664', 'AVXmXIJr', 'CSN42435', 'jEflmYXPTKcx', 'ldgZveTY', '上海', 'sh', '苏州', 'sz', '52', '1', 'default', 'default', '465', '0', '王师傅', null, '13962922863', '', null, '4', 'ymzpqADYcR', null, '2018-07-05 00:13:41', '2018-07-05 00:13:41');
INSERT INTO `orders` VALUES ('1902', '2018-07-05 00:13:44', '2018-07-05 00:13:44', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '19', '47', '36922', 'gcgEtFxy', 'CSN85206', 'jcSlZcFBabMg', 'MwmGUtVV', '上海', 'sh', '苏州', 'sz', '84', '1', 'default', 'default', '697', '0', '王师傅', null, '13961619026', '', null, '3', 'hoBxHDMkEI', null, '2018-07-05 00:13:44', '2018-07-05 00:13:44');

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
  `price` int(11) unsigned DEFAULT NULL,
  `chartered_price` int(11) unsigned DEFAULT NULL,
  `weight` int(11) unsigned DEFAULT NULL,
  `size` int(11) unsigned DEFAULT NULL,
  `distance` int(11) unsigned DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `sourcepy` varchar(25) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `destinationpy` varchar(25) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', '0', '0', '0', '0', '0', 'default', 'default', null, 'default', null, '2018-07-03 15:08:07', '2018-07-03 15:08:07');

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
  `role` varchar(15) DEFAULT NULL,
  `role_id` bigint(11) unsigned DEFAULT NULL,
  `token` varchar(25) DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT NULL,
  `last_login_time` varchar(25) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'default', null, '默认', null, null, null, null, null, null, '2018-07-03 15:02:31', '2018-07-03 15:02:31');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', 'default', '2018-07-03 15:06:00', '2018-07-04 16:49:47');
