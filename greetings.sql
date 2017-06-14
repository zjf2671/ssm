/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : recipe

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-06-14 19:14:20
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
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of greetings
-- ----------------------------
INSERT INTO `greetings` VALUES ('1', 'note-1 ui-draggable ui-draggable-dragging', 'left: 614.11px; top: 258.11px; z-index: 99; cursor: pointer; transform: rotate(-19deg);', '一定要幸福哦~', null);
INSERT INTO `greetings` VALUES ('2', 'note-2 ui-draggable ui-draggable-dragging', 'left: 410.78px; top: 140.78px; z-index: 99; cursor: pointer; transform: rotate(7deg);', '祝你们白头偕老！', null);
INSERT INTO `greetings` VALUES ('3', 'note-3 ui-draggable ui-draggable-dragging', 'left: 632.74px; top: 183.74px; z-index: 99; cursor: pointer; transform: rotate(5deg);', '早生贵子~', null);
INSERT INTO `greetings` VALUES ('4', 'note-4 ui-draggable ui-draggable-dragging', 'left: 147.61px; top: 277.61px; z-index: 99; cursor: pointer; transform: rotate(7deg);', '新婚快乐~', null);
INSERT INTO `greetings` VALUES ('5', 'note-5 ui-draggable ui-draggable-dragging', 'left: 553.31px; top: 90.31px; z-index: 99; cursor: pointer; transform: rotate(20deg);', '生个宝宝认我做干妈！', null);
INSERT INTO `greetings` VALUES ('6', 'note-6 ui-draggable ui-draggable-dragging', 'left: 200.07px; top: 334.08px; z-index: 99; cursor: pointer; transform: rotate(-5deg);', '喜结良缘O(∩_∩)O哈哈哈~', null);
INSERT INTO `greetings` VALUES ('8', 'note-4 ui-draggable ui-draggable-dragging', 'left: 135.17px; top: 134.17px; z-index: 99; cursor: pointer; transform: rotate(17deg);', '哎呦，不错哦！！', null);
INSERT INTO `greetings` VALUES ('43', 'note-6 ui-draggable ui-draggable-dragging', 'left: 484.41px; top: 107.41px; z-index: 99; cursor: pointer; transform: rotate(-4deg);', 'You\'re the luckiest guy in the world.', null);
INSERT INTO `greetings` VALUES ('44', 'note-6 ui-draggable ui-draggable-dragging', 'left: 575.2px; top: 336.2px; z-index: 99; cursor: pointer; transform: rotate(2deg);', 'Happy married life!', null);
INSERT INTO `greetings` VALUES ('45', 'note-2 ui-draggable ui-draggable-dragging', 'left: 110.516px; top: 195.516px; z-index: 99; cursor: pointer; transform: rotate(2deg);', 'Best wishes from one of your old friends on your engagement.', null);
INSERT INTO `greetings` VALUES ('46', 'note-1 ui-draggable ui-draggable-dragging', 'left: 262.44px; top: 381.44px; z-index: 99; cursor: pointer; transform: rotate(-3deg);', 'Let me wish you and your bride every joy and the best of everything.', null);
INSERT INTO `greetings` VALUES ('47', 'note-2 ui-draggable ui-draggable-dragging', 'left: 400.77px; top: 270.43px; z-index: 99; cursor: pointer; transform: rotate(10deg);', 'X/F ing.........', null);
INSERT INTO `greetings` VALUES ('48', 'note-6 ui-draggable ui-draggable-dragging', 'left: 636.42px; top: 110.42px; z-index: 99; cursor: pointer; transform: rotate(14deg);', '喜结连理！', null);
INSERT INTO `greetings` VALUES ('49', 'note-1 ui-draggable ui-draggable-dragging', 'left: 274.24px; top: 93.24px; z-index: 99; cursor: pointer; transform: rotate(-18deg);', '百年好合!', null);
INSERT INTO `greetings` VALUES ('50', 'note-1 ui-draggable ui-draggable-dragging', 'left: 517.08px; top: 402.08px; z-index: 99; cursor: pointer; transform: rotate(9deg);', '永结同心~~~~~', null);
INSERT INTO `greetings` VALUES ('51', 'note-4 ui-draggable ui-draggable-dragging', 'left: 327.13px; top: 427.13px; z-index: 99; cursor: pointer; transform: rotate(3deg);', '执子之手~~~~~', null);
INSERT INTO `greetings` VALUES ('52', 'note-5 ui-draggable ui-draggable-dragging', 'left: 429.83px; top: 431.83px; z-index: 99; cursor: pointer; transform: rotate(-17deg);', '与子偕老~~', null);
INSERT INTO `greetings` VALUES ('53', 'note-3 ui-draggable ui-draggable-dragging', 'left: 338.57px; top: 130.57px; z-index: 99; cursor: pointer; transform: rotate(-18deg);', '珠帘壁合~', null);
INSERT INTO `greetings` VALUES ('54', 'note-3 ui-draggable ui-draggable-dragging', 'left: 196.6px; top: 93.6px; z-index: 99; cursor: pointer; transform: rotate(3deg);', '天缘巧合', null);
