/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : recipe

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-06-14 10:23:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for greetings
-- ----------------------------
DROP TABLE IF EXISTS `greetings`;
CREATE TABLE `greetings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classes` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of greetings
-- ----------------------------
INSERT INTO `greetings` VALUES ('1', 'note-1 ui-draggable', 'left: 475.61px; top: 163.61px; z-index: 99; cursor: pointer; transform: rotate(18deg);', '一定要幸福哦~');
INSERT INTO `greetings` VALUES ('2', 'note-2 ui-draggable ui-draggable-dragging', 'left: 464.812px; top: 102.812px; z-index: 99; cursor: pointer; transform: rotate(1deg);', '祝你们白头偕老！');
INSERT INTO `greetings` VALUES ('3', 'note-3 ui-draggable ui-draggable-dragging', 'left: 441.641px; top: 294.641px; z-index: 99; cursor: pointer; transform: rotate(0deg);', '早生贵子~');
INSERT INTO `greetings` VALUES ('4', 'note-4 ui-draggable', 'left: 390.27px; top: 92.27px; z-index: 99; cursor: pointer; transform: rotate(4deg);', '新婚快乐~');
INSERT INTO `greetings` VALUES ('5', 'note-5 ui-draggable', 'left: 648.16px; top: 41.16px; z-index: 99; cursor: pointer; transform: rotate(11deg);', '生个宝宝认我做干妈！');
INSERT INTO `greetings` VALUES ('6', 'note-6 ui-draggable ui-draggable-dragging', 'left: 49.6397px; top: 424.64px; z-index: 99; cursor: pointer; transform: rotate(10deg);', '喜结良缘O(∩_∩)O哈哈哈~');
INSERT INTO `greetings` VALUES ('8', 'note-4 ui-draggable ui-draggable-dragging', 'transform: rotate(20deg); left: 351.812px; top: 169.812px; z-index: 99; cursor: pointer;', '哎呦，不错哦！！');
INSERT INTO `greetings` VALUES ('43', 'note-6', 'transform:rotate(13deg); left:491px; top:108px', 'rqrqrq');
INSERT INTO `greetings` VALUES ('44', 'note-6', 'transform:rotate(5deg); left:422px; top:222px', 'rqrqq');
INSERT INTO `greetings` VALUES ('45', 'note-2', 'transform:rotate(8deg); left:149px; top:237px', 'rqrrqrq');
INSERT INTO `greetings` VALUES ('46', 'note-1', 'transform:rotate(17deg); left:427px; top:377px', 'rqrqr');
INSERT INTO `greetings` VALUES ('47', 'note-2', 'transform:rotate(12deg); left:394px; top:66px', 'rwrrw');
INSERT INTO `greetings` VALUES ('48', 'note-6', 'transform:rotate(-8deg); left:509px; top:212px', 'rwrw');
INSERT INTO `greetings` VALUES ('49', 'note-1', 'transform:rotate(-15deg); left:389px; top:152px', 'rqrqr');
INSERT INTO `greetings` VALUES ('50', 'note-1', 'transform:rotate(11deg); left:669px; top:328px', 'rqrq');
INSERT INTO `greetings` VALUES ('51', 'note-4', 'transform:rotate(17deg); left:620px; top:424px', 'rqrq');
INSERT INTO `greetings` VALUES ('52', 'note-5', 'transform:rotate(6deg); left:573px; top:388px', 'rqrq');
INSERT INTO `greetings` VALUES ('53', 'note-3', 'transform:rotate(-3deg); left:407px; top:46px', 'rq');
INSERT INTO `greetings` VALUES ('54', 'note-3', 'transform:rotate(20deg); left:36px; top:54px', 'r');
