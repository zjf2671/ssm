/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : recipe

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-06-13 18:17:05
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
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

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
INSERT INTO `greetings` VALUES ('20', 'note-6 ui-draggable ui-draggable-dragging', 'transform: rotate(-14deg); left: 277px; top: 67px; z-index: 99; cursor: pointer;', 'egte');
INSERT INTO `greetings` VALUES ('23', 'note-5 ui-draggable ui-draggable-dragging', 'left: 47.2956px; top: 176.296px; z-index: 99; cursor: pointer; transform: rotate(-17deg);', 't5y45y4');
INSERT INTO `greetings` VALUES ('25', 'note-2 ui-draggable ui-draggable-dragging', 'left: 178.576px; top: 116.576px; z-index: 99; cursor: pointer; transform: rotate(3deg);', 'rqrqr');
INSERT INTO `greetings` VALUES ('26', 'note-2 ui-draggable ui-draggable-dragging', 'left: 138.637px; top: 19.6374px; z-index: 99; cursor: pointer; transform: rotate(6deg);', '5435');
INSERT INTO `greetings` VALUES ('27', 'note-5 ui-draggable ui-draggable-dragging', 'left: 14.2409px; top: 335.241px; z-index: 99; cursor: pointer; transform: rotate(11deg);', '恭喜恭喜');
INSERT INTO `greetings` VALUES ('28', 'note-3 ui-draggable ui-draggable-dragging', 'left: 193.36px; top: 389.36px; z-index: 99; cursor: pointer; transform: rotate(11deg);', 'wrwr');
INSERT INTO `greetings` VALUES ('29', 'note-3 ui-draggable ui-draggable-dragging', 'left: 297.999px; top: 262.999px; z-index: 99; cursor: pointer; transform: rotate(15deg);', 'erwre');
INSERT INTO `greetings` VALUES ('30', 'note-1 ui-draggable ui-draggable-dragging', 'left: 367px; top: 36px; z-index: 99; cursor: pointer; transform: rotate(-5deg);', 'tqtqt');
INSERT INTO `greetings` VALUES ('31', 'note-5 ui-draggable ui-draggable-dragging', 'left: 283px; top: 377px; z-index: 99; cursor: pointer; transform: rotate(12deg);', 'tqtqtq');
INSERT INTO `greetings` VALUES ('32', 'note-5 ui-draggable ui-draggable-dragging', 'left: 97.9092px; top: 274.909px; z-index: 99; cursor: pointer; transform: rotate(4deg);', 'rqrq');
INSERT INTO `greetings` VALUES ('33', 'note-1 ui-draggable ui-draggable-dragging', 'left: 374px; top: 444px; z-index: 99; cursor: pointer; transform: rotate(-3deg);', 'rqrqq');
INSERT INTO `greetings` VALUES ('34', 'note-1 ui-draggable ui-draggable-dragging', 'z-index: 99; transform: rotate(-15deg); cursor: pointer; left: 17.1652px; top: 62.4621px;', '用途');
INSERT INTO `greetings` VALUES ('35', 'note-6 ui-draggable ui-draggable-dragging', 'left: 661.36px; top: 221.36px; transform: rotate(16deg); z-index: 99; cursor: pointer;', '这个好');
INSERT INTO `greetings` VALUES ('36', 'note-6 ui-draggable ui-draggable-dragging', 'transform: rotate(18deg); left: 551.792px; top: 413.792px; z-index: 99; cursor: pointer;', 'rwwrwr');
INSERT INTO `greetings` VALUES ('37', 'note-2 ui-draggable ui-draggable-dragging', 'transform: rotate(4deg); left: 181.14px; top: 208.14px; z-index: 99; cursor: pointer;', 'rqrqrq');
