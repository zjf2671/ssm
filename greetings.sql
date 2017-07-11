/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : recipe

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-07-11 14:45:08
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
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of greetings
-- ----------------------------
INSERT INTO `greetings` VALUES ('1', 'note-1 ui-draggable ui-draggable-dragging', 'left: 586.35px; top: 264.35px; z-index: 99; cursor: pointer; transform: rotate(4deg);', 'harry', '一定要幸福哦~', null, null);
INSERT INTO `greetings` VALUES ('2', 'note-2 ui-draggable ui-draggable-dragging', 'left: 332.97px; top: 105.97px; z-index: 99; cursor: pointer; transform: rotate(20deg);', 'harry', '祝你们白头偕老！', null, null);
INSERT INTO `greetings` VALUES ('3', 'note-3 ui-draggable ui-draggable-dragging', 'left: 625.734px; top: 197.734px; z-index: 99; cursor: pointer; transform: rotate(0deg);', 'harry', '早生贵子~', null, null);
INSERT INTO `greetings` VALUES ('4', 'note-4 ui-draggable ui-draggable-dragging', 'left: 147.61px; top: 277.61px; z-index: 99; cursor: pointer; transform: rotate(7deg);', 'harry', '新婚快乐~', null, null);
INSERT INTO `greetings` VALUES ('5', 'note-5 ui-draggable ui-draggable-dragging', 'left: 504.933px; top: 97.9329px; z-index: 99; cursor: pointer; transform: rotate(13deg);', 'harry', '生个宝宝认我做干妈！', null, null);
INSERT INTO `greetings` VALUES ('6', 'note-6 ui-draggable ui-draggable-dragging', 'left: 200.07px; top: 334.08px; z-index: 99; cursor: pointer; transform: rotate(-5deg);', 'harry', '喜结良缘O(∩_∩)O哈哈哈~', null, null);
INSERT INTO `greetings` VALUES ('8', 'note-4 ui-draggable ui-draggable-dragging', 'left: 110.204px; top: 88.2039px; z-index: 99; cursor: pointer; transform: rotate(8deg);', 'harry', '哎呦，不错哦！！', null, '2017-06-15 19:13:13');
INSERT INTO `greetings` VALUES ('43', 'note-6 ui-draggable ui-draggable-dragging', 'left: 424.556px; top: 114.556px; z-index: 99; cursor: pointer; transform: rotate(8deg);', 'harry', 'You\'re the luckiest guy in the world.', null, null);
INSERT INTO `greetings` VALUES ('44', 'note-6 ui-draggable ui-draggable-dragging', 'left: 575.2px; top: 336.2px; z-index: 99; cursor: pointer; transform: rotate(2deg);', 'harry', 'Happy married life!', null, null);
INSERT INTO `greetings` VALUES ('45', 'note-2 ui-draggable ui-draggable-dragging', 'left: 93.5065px; top: 174.507px; z-index: 99; cursor: pointer; transform: rotate(5deg);', 'harry', 'Best wishes from one of your old friends on your engagement.', null, '2017-06-15 19:16:18');
INSERT INTO `greetings` VALUES ('46', 'note-1 ui-draggable ui-draggable-dragging', 'left: 262.44px; top: 381.44px; z-index: 99; cursor: pointer; transform: rotate(-3deg);', 'harry', 'Let me wish you and your bride every joy and the best of everything.', null, null);
INSERT INTO `greetings` VALUES ('47', 'note-2 ui-draggable ui-draggable-dragging', 'left: 392.637px; top: 245.715px; z-index: 99; cursor: pointer; transform: rotate(1deg);', 'harry', 'X/F ing.........', null, '2017-06-18 21:30:53');
INSERT INTO `greetings` VALUES ('48', 'note-6 ui-draggable ui-draggable-dragging', 'left: 606.766px; top: 121.766px; z-index: 99; cursor: pointer; transform: rotate(17deg);', '宝宝', '喜结连理！', null, null);
INSERT INTO `greetings` VALUES ('49', 'note-1 ui-draggable ui-draggable-dragging', 'left: 236.278px; top: 223.278px; z-index: 99; cursor: pointer; transform: rotate(5deg);', '小丽', '百年好合!', null, '2017-07-11 14:36:35');
INSERT INTO `greetings` VALUES ('50', 'note-1 ui-draggable ui-draggable-dragging', 'left: 517.08px; top: 402.08px; z-index: 99; cursor: pointer; transform: rotate(9deg);', '小红', '永结同心~~~~~', null, null);
INSERT INTO `greetings` VALUES ('51', 'note-4 ui-draggable ui-draggable-dragging', 'left: 327.13px; top: 427.13px; z-index: 99; cursor: pointer; transform: rotate(3deg);', '小华', '执子之手~~~~~', null, null);
INSERT INTO `greetings` VALUES ('52', 'note-5 ui-draggable ui-draggable-dragging', 'left: 429.83px; top: 431.83px; z-index: 99; cursor: pointer; transform: rotate(-17deg);', '小明', '与子偕老~~', null, null);
INSERT INTO `greetings` VALUES ('53', 'note-3 ui-draggable ui-draggable-dragging', 'left: 258.487px; top: 89.4873px; z-index: 99; cursor: pointer; transform: rotate(-8deg);', '小人', '珠帘壁合~', null, null);
INSERT INTO `greetings` VALUES ('54', 'note-3 ui-draggable ui-draggable-dragging', 'left: 180.333px; top: 66.3331px; z-index: 99; cursor: pointer; transform: rotate(17deg);', 'harry', '天缘巧合', null, '2017-06-15 19:23:14');
INSERT INTO `greetings` VALUES ('64', 'note-4', 'transform:rotate(2deg); left:588px; top:88px;', 'harry', '?，不错呦，?', '2017-07-10 16:33:37', '2017-07-10 16:33:37');
