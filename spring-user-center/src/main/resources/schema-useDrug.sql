SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chronic_use_drug_cycle_unit
-- ----------------------------
DROP TABLE IF EXISTS `chronic_use_drug_cycle_unit`;
CREATE TABLE `chronic_use_drug_cycle_unit`  (
  `id` varchar(21) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `unit` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用药方案之用药周期单位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chronic_use_drug_cycle_unit
-- ----------------------------
INSERT INTO `chronic_use_drug_cycle_unit` VALUES ('1', '1');
INSERT INTO `chronic_use_drug_cycle_unit` VALUES ('2', '2');
INSERT INTO `chronic_use_drug_cycle_unit` VALUES ('3', '3');
SET FOREIGN_KEY_CHECKS = 1;