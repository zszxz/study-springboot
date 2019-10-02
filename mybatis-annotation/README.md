CREATE TABLE `tb_user` (
  `user_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_gender` varchar(2) DEFAULT NULL COMMENT '用户性别',
  `user_telephone` varchar(15) DEFAULT NULL COMMENT '用户电话',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;