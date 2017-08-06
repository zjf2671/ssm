/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : recipe

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-07-16 12:52:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for recipe_count
-- ----------------------------
DROP TABLE IF EXISTS `recipe_count`;
CREATE TABLE `recipe_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `recipecount` int(11) DEFAULT NULL,
  `titlecount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recipe_count
-- ----------------------------
INSERT INTO `recipe_count` VALUES ('1', '测试', '1', '1');
