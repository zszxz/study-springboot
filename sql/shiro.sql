CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` varchar(20) DEFAULT NULL COMMENT '用户id',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐值',
  `state` varchar(50) DEFAULT NULL COMMENT '状态(normal正常用户,prohibit冻结)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `Role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `User_Role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` varchar(11) DEFAULT NULL COMMENT '用户id',
  `roleId` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `Power` (
  `powerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `powerType` varchar(255) DEFAULT NULL COMMENT '权限类型',
  `powerName` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `power` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`powerId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `Role_Power` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` int(11) DEFAULT NULL COMMENT '角色id',
  `powerId` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `Power`(`powerId`, `powerType`, `powerName`, `power`) VALUES (1, '1', '查询用户', 'user:info');
INSERT INTO `Power`(`powerId`, `powerType`, `powerName`, `power`) VALUES (2, '1', '查询数据', 'user:data');
INSERT INTO `Power`(`powerId`, `powerType`, `powerName`, `power`) VALUES (3, '1', '查询数据', 'data:all');


INSERT INTO `Role`(`roleId`, `roleName`) VALUES (1, 'user');
INSERT INTO `Role`(`roleId`, `roleName`) VALUES (2, 'manager');
INSERT INTO `Role`(`roleId`, `roleName`) VALUES (3, 'super');


INSERT INTO `User`(`id`, `userId`, `userName`, `password`, `salt`, `state`) VALUES (1, 'zxzxz', 'zxzxz', 'ff961c3282a6ffcc57b0f30a5f34db86', 'user', 'normal');
INSERT INTO `User`(`id`, `userId`, `userName`, `password`, `salt`, `state`) VALUES (2, 'youku1327', 'youku1327', '78e78cb20aead7b00bbf50ff8d3ac281', 'user', 'normal');


INSERT INTO `User_Role`(`id`, `userId`, `roleId`) VALUES (1, 'zxzxz', 1);
INSERT INTO `User_Role`(`id`, `userId`, `roleId`) VALUES (2, 'zxzxz', 2);
INSERT INTO `User_Role`(`id`, `userId`, `roleId`) VALUES (3, 'zxzxz', 2);


INSERT INTO `Role_Power`(`id`, `roleId`, `powerId`) VALUES (1, 1, 1);
INSERT INTO `Role_Power`(`id`, `roleId`, `powerId`) VALUES (2, 2, 1);
INSERT INTO `Role_Power`(`id`, `roleId`, `powerId`) VALUES (3, 2, 2);
