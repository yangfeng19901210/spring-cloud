/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3308
 Source Schema         : spring_order_center

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 13/05/2022 17:19:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rocketmq_transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `rocketmq_transaction_log`;
CREATE TABLE `rocketmq_transaction_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `transaction_Id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '事务id',
  `log` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rocketmq_transaction_log
-- ----------------------------
INSERT INTO `rocketmq_transaction_log` VALUES (1, 'ef89739d-b9ed-40ac-acb5-0c35b91f704d', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (2, 'ad7c3ab2-7219-4fe2-88b3-a60840bc2b59', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (3, '58360801-ef37-4b0d-af20-6f2e0f486946', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (4, '3274e111-28ff-4b71-8d58-a8dca08f3024', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (5, '3f2c5d34-7e21-4b8a-9e5b-8b22552430ae', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (6, '05f317b8-f2f7-4088-a88d-39fdf3336ecd', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (7, '11be253d-5ff4-4758-bfdf-7b58698216e7', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (8, '55fe9def-f8a0-471f-8e08-8d2f072bfc6f', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (9, 'fb6273d0-051f-495f-a251-76ecfc8e9416', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (10, '5ede9833-cd72-4708-9bed-116f358eeef0', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (11, '166c858e-1a1a-4d64-92d9-8be624581e0f', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (12, '95823ef6-4618-4e6a-9aba-74315823d015', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (13, '29f553cc-78fc-4151-8038-704f11dd2eda', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (14, 'c94ce2b3-8765-45d8-9e32-be851f9bc8a6', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (15, '77be7a78-1ea2-4251-bfa4-d981dfc2db43', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (16, 'cef280cc-eae4-4df2-9bc6-394320da477f', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (17, '7778663b-8ea1-4e29-b182-96c9a37d756a', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (18, '123d431e-6910-4899-9a75-c1e380da8cf2', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (19, 'e61820d3-4817-463c-9ede-93731ff43148', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (20, 'e9bf5774-b7ff-4dc8-b395-e38ac55c6850', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (21, '5c343627-78e3-4948-bb25-95ea0dfafb1a', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (22, 'df945f8a-0f97-4a13-a21a-3b9a5abd562f', '审核分享');
INSERT INTO `rocketmq_transaction_log` VALUES (23, '2e000ed7-be5f-43b1-8013-34975d6284e6', '审核分享');

-- ----------------------------
-- Table structure for spring_bus_share
-- ----------------------------
DROP TABLE IF EXISTS `spring_bus_share`;
CREATE TABLE `spring_bus_share`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章内容',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `crete_time` datetime(0) NULL DEFAULT NULL COMMENT '分享时间',
  `status` int NULL DEFAULT NULL COMMENT '文章状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分享表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spring_bus_share
-- ----------------------------
INSERT INTO `spring_bus_share` VALUES (1, 'java实战之RocketMq', 'rocketmq事务消息发送', 1, '2022-05-13 11:37:43', 3);
INSERT INTO `spring_bus_share` VALUES (2, 'java实战之RocketMq', 'rocketmq事务消息发送', 2, '2022-05-13 11:46:15', 3);
INSERT INTO `spring_bus_share` VALUES (3, 'java实战之RocketMq', 'rocketmq事务消息发送', 3, '2022-05-13 13:54:36', 3);
INSERT INTO `spring_bus_share` VALUES (4, 'java实战之RocketMq', 'rocketmq事务消息发送', 4, '2022-05-13 13:56:16', 3);
INSERT INTO `spring_bus_share` VALUES (5, 'java实战之RocketMq', 'rocketmq事务消息发送', 5, '2022-05-13 13:59:34', 3);
INSERT INTO `spring_bus_share` VALUES (6, 'java实战之RocketMq', 'rocketmq事务消息发送', 6, '2022-05-13 14:05:58', 3);

SET FOREIGN_KEY_CHECKS = 1;
