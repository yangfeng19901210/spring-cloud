/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3308
 Source Schema         : spring_user_center

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 13/05/2022 17:18:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for spring_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `spring_sys_user`;
CREATE TABLE `spring_sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spring_sys_user
-- ----------------------------
INSERT INTO `spring_sys_user` VALUES (1, '张三');
INSERT INTO `spring_sys_user` VALUES (2, '李四');
INSERT INTO `spring_sys_user` VALUES (3, '王五');
INSERT INTO `spring_sys_user` VALUES (4, '赵六');
INSERT INTO `spring_sys_user` VALUES (5, '刘备');
INSERT INTO `spring_sys_user` VALUES (6, '关于');
INSERT INTO `spring_sys_user` VALUES (7, '张飞');
INSERT INTO `spring_sys_user` VALUES (8, '曹操');

SET FOREIGN_KEY_CHECKS = 1;
