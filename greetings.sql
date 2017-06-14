/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : recipe

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-06-14 11:37:35
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
INSERT INTO `greetings` VALUES ('1', 'note-1 ui-draggable ui-draggable-dragging', 'left: 650.24px; top: 193.24px; z-index: 99; cursor: pointer; transform: rotate(-18deg);', '一定要幸福哦~');
INSERT INTO `greetings` VALUES ('2', 'note-2 ui-draggable ui-draggable-dragging', 'left: 519.18px; top: 30.18px; z-index: 99; cursor: pointer; transform: rotate(-19deg);', '祝你们白头偕老！');
INSERT INTO `greetings` VALUES ('3', 'note-3 ui-draggable ui-draggable-dragging', 'left: 422.64px; top: 339.64px; z-index: 99; cursor: pointer; transform: rotate(17deg);', '早生贵子~');
INSERT INTO `greetings` VALUES ('4', 'note-4 ui-draggable ui-draggable-dragging', 'left: 203.63px; top: 269.63px; z-index: 99; cursor: pointer; transform: rotate(-6deg);', '新婚快乐~');
INSERT INTO `greetings` VALUES ('5', 'note-5 ui-draggable ui-draggable-dragging', 'left: 655.95px; top: 47.95px; z-index: 99; cursor: pointer; transform: rotate(12deg);', '生个宝宝认我做干妈！');
INSERT INTO `greetings` VALUES ('6', 'note-6 ui-draggable ui-draggable-dragging', 'left: 49.6397px; top: 424.64px; z-index: 99; cursor: pointer; transform: rotate(10deg);', '喜结良缘O(∩_∩)O哈哈哈~');
INSERT INTO `greetings` VALUES ('8', 'note-4 ui-draggable ui-draggable-dragging', 'left: 182.13px; top: 125.13px; z-index: 99; cursor: pointer; transform: rotate(-17deg);', '哎呦，不错哦！！');
INSERT INTO `greetings` VALUES ('43', 'note-6 ui-draggable ui-draggable-dragging', 'left: 550.7px; top: 115.7px; z-index: 99; cursor: pointer; transform: rotate(-1deg);', 'You\'re the luckiest guy in the world.');
INSERT INTO `greetings` VALUES ('44', 'note-6 ui-draggable ui-draggable-dragging', 'left: 340.42px; top: 180.42px; z-index: 99; cursor: pointer; transform: rotate(-10deg);', 'Happy married life!');
INSERT INTO `greetings` VALUES ('45', 'note-2 ui-draggable ui-draggable-dragging', 'left: 91.54px; top: 216.54px; z-index: 99; cursor: pointer; transform: rotate(-5deg);', 'Best wishes from one of your old friends on your engagement.');
INSERT INTO `greetings` VALUES ('46', 'note-1 ui-draggable ui-draggable-dragging', 'left: 366.04px; top: 462.04px; z-index: 99; cursor: pointer; transform: rotate(-3deg);', 'Let me wish you and your bride every joy and the best of everything.');
INSERT INTO `greetings` VALUES ('47', 'note-2 ui-draggable ui-draggable-dragging', 'left: 267.3px; top: 361.3px; z-index: 99; cursor: pointer; transform: rotate(4deg);', 'X/F ing.........');
INSERT INTO `greetings` VALUES ('48', 'note-6 ui-draggable ui-draggable-dragging', 'left: 450.34px; top: 217.34px; z-index: 99; cursor: pointer; transform: rotate(2deg);', '喜结连理！');
INSERT INTO `greetings` VALUES ('49', 'note-1 ui-draggable ui-draggable-dragging', 'left: 264.9px; top: 45.9px; z-index: 99; cursor: pointer; transform: rotate(-5deg);', '百年好合!');
INSERT INTO `greetings` VALUES ('50', 'note-1 ui-draggable ui-draggable-dragging', 'left: 669.79px; top: 303.79px; z-index: 99; cursor: pointer; transform: rotate(10deg);', '永结同心~~~~~');
INSERT INTO `greetings` VALUES ('51', 'note-4 ui-draggable ui-draggable-dragging', 'left: 604.04px; top: 395.04px; z-index: 99; cursor: pointer; transform: rotate(-13deg);', '执子之手~~~~~');
INSERT INTO `greetings` VALUES ('52', 'note-5 ui-draggable ui-draggable-dragging', 'left: 530.43px; top: 332.43px; z-index: 99; cursor: pointer; transform: rotate(-1deg);', '与子偕老~~');
INSERT INTO `greetings` VALUES ('53', 'note-3 ui-draggable ui-draggable-dragging', 'left: 425.16px; top: 81.16px; z-index: 99; cursor: pointer; transform: rotate(-18deg);', '珠帘壁合~');
INSERT INTO `greetings` VALUES ('54', 'note-3 ui-draggable ui-draggable-dragging', 'left: 57.85px; top: 65.85px; z-index: 99; cursor: pointer; transform: rotate(-5deg);', '天缘巧合');
