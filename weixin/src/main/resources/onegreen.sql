/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : onegreen

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2014-09-30 15:07:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activities
-- ----------------------------
DROP TABLE IF EXISTS `activities`;
CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) NOT NULL COMMENT 'uuid',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `image_id` int(11) DEFAULT NULL COMMENT '活动图片id',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `editTime` datetime DEFAULT NULL COMMENT '编辑时长',
  `startTime` varchar(10) DEFAULT NULL COMMENT '开始时间',
  `endTime` varchar(10) DEFAULT NULL COMMENT '结束时间',
  `platform_id` int(11) NOT NULL COMMENT '平台id',
  `status` int(11) DEFAULT '1' COMMENT '状态 1：正常 0：禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='公司活动';

-- ----------------------------
-- Records of activities
-- ----------------------------
INSERT INTO `activities` VALUES ('40', '60a4c9457bcc4ba0a6eccfd58c0a73de', '国庆放假国庆放假国庆放假国庆放假', '国庆放假<p>国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假国庆放假</p>', null, '2014-09-25 10:44:24', null, '2014-09-24', '2014-10-01', '3', '0');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `uuid` varchar(40) NOT NULL COMMENT 'uuid',
  `title` varchar(100) DEFAULT NULL COMMENT '标题（从自动回复中添加的文章没有标题）',
  `image_id` int(11) DEFAULT NULL COMMENT '图片id',
  `content` varchar(2000) NOT NULL COMMENT '内容',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `editTime` datetime DEFAULT NULL COMMENT '编辑时间',
  `isAutoReply` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是自动回复文章',
  `views` int(11) DEFAULT NULL COMMENT '浏览次数',
  `platform_id` int(11) NOT NULL COMMENT '公众平台id',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态 1：可用   0：不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'F4F5E20859714750829ADDF436832EBD', '这是第一篇文本文章2', null, '文本文章内容', '2014-09-10 11:03:51', '2014-09-10 11:12:37', '\0', '0', '1', '1');
INSERT INTO `article` VALUES ('2', 'BDFC342981174B659C6B16DED4392D66', '这是第一篇图文文章44444', '2', '图文文章内容', '2014-09-10 11:03:51', '2014-09-10 11:12:37', '\0', '0', '1', '1');
INSERT INTO `article` VALUES ('3', 'f7c15eb962284237b72046f07984a7ca', '水电费三大发大水发水电费', null, '<p>请输入文章内容谁点发送到发送到放水电费撒范德萨发</p>', '2014-09-19 23:32:37', '2014-09-19 23:32:37', '\0', '0', '3', '1');

-- ----------------------------
-- Table structure for companyprofile
-- ----------------------------
DROP TABLE IF EXISTS `companyprofile`;
CREATE TABLE `companyprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业介绍id',
  `uuid` varchar(40) DEFAULT NULL COMMENT '企业介绍uuid',
  `companyName` varchar(20) DEFAULT NULL COMMENT '企业名字',
  `content` varchar(2000) DEFAULT NULL COMMENT '企业介绍内容',
  `platform_id` int(11) DEFAULT NULL COMMENT '公众平台id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of companyprofile
-- ----------------------------
INSERT INTO `companyprofile` VALUES ('2', 'FE521C6E7A584276B668650F5DA89FE0', '云南禅客网络科技有限责任公司', '云南禅客网络科技有限责任公司是一家网络公司，云南禅客网络科技有限责任公司是一家网络公司', '1');
INSERT INTO `companyprofile` VALUES ('3', 'c27c79d68ebf4ebabd5a56f8fc6ea3d1', '云南米戈网络科技有限公司', '<p>						</p><p></p><p>						</p><p></p><p>						</p><p></p><p>						</p><p></p><p>云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司云南米戈网络科技有限公司</p><p></p><p></p><p></p><p>', '3');

-- ----------------------------
-- Table structure for companyprofile_images
-- ----------------------------
DROP TABLE IF EXISTS `companyprofile_images`;
CREATE TABLE `companyprofile_images` (
  `profile_id` int(11) NOT NULL COMMENT '企业介绍id',
  `image_id` int(11) NOT NULL COMMENT '图片id',
  PRIMARY KEY (`profile_id`,`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of companyprofile_images
-- ----------------------------
INSERT INTO `companyprofile_images` VALUES ('2', '2');
INSERT INTO `companyprofile_images` VALUES ('2', '3');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `customerId` varchar(40) NOT NULL COMMENT '系统生成的客户id',
  `name` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `realName` varchar(8) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(11) NOT NULL COMMENT '手机',
  `phone` varchar(12) DEFAULT NULL COMMENT '电话',
  `fax` varchar(12) DEFAULT NULL COMMENT '传真',
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `editTime` datetime DEFAULT NULL COMMENT '编辑时间',
  `uuid` varchar(36) DEFAULT NULL COMMENT 'uuid与校验密码有关',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '6B13B4979BA9453F923910C31BDAF6FF', 'luoshengsha', 'fd7bb108ffc4fafaa7e134327596ff63', '罗生沙', '13919860400', '0931-7635206', '0931-7635206', 'luoshengsha@163.com', '2014-09-07 23:25:09', null, 'b4476bc1-ef94-4150-a896-260c155e5dbe');
INSERT INTO `customer` VALUES ('2', 'fd1d16c647754589ae03ba2500f287f7', 'gsau_730', '2838f7ba7f94f39058ac1d77a4234308', null, '13919860400', null, null, 'luoshengsha@163.com', '2014-09-17 21:52:51', null, '55a1806c-6e4f-4284-97ac-632920e2d8c6');
INSERT INTO `customer` VALUES ('3', 'ea8c782d00e8436fa760ad45f618a9bf', 'luoshengsha2', '77f4975c3fe850c69e6b6c528ffa3e07', '罗生沙', '13919860400', '0931-7635206', '0931-7635206', 'luoshengsha@163.com', '2014-09-17 21:54:19', '2014-09-23 21:31:27', '2c217e53-ef03-4ef9-8c86-d3d8c040aa79');
INSERT INTO `customer` VALUES ('4', 'ab164515ed284c79b241186b0a740d7c', 'abc', '2df8d03294e2b4c74a9efb48690edeaf', null, '13919862347', null, null, '329879241@qq.com', '2014-09-21 17:02:07', null, '71083bd9-d87c-4b19-bb57-9904e8380758');

-- ----------------------------
-- Table structure for defaultreplymessage
-- ----------------------------
DROP TABLE IF EXISTS `defaultreplymessage`;
CREATE TABLE `defaultreplymessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(1000) NOT NULL COMMENT '回复内容',
  `editTime` datetime NOT NULL COMMENT '编辑时间',
  `platform_id` int(11) NOT NULL COMMENT '平台id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='默认文本回复信息';

-- ----------------------------
-- Records of defaultreplymessage
-- ----------------------------
INSERT INTO `defaultreplymessage` VALUES ('1', '这是默认自动文本回复信息！哈哈哈哈哈哈', '2014-09-09 22:49:50', '1');
INSERT INTO `defaultreplymessage` VALUES ('2', 'afafdsfd', '2014-09-24 17:54:06', '3');

-- ----------------------------
-- Table structure for fans
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `subscribe` varchar(255) DEFAULT NULL COMMENT '用户是否订阅该公众号标识 0：代表此用户没有关注该公众号，拉取不到其余信息 1：代表已关注',
  `openid` int(11) DEFAULT NULL COMMENT '粉丝openId',
  `nickname` varchar(255) DEFAULT NULL COMMENT '粉丝昵称',
  `sex` varchar(255) DEFAULT NULL COMMENT '粉丝性别 1：男性 2：女性 0：未知',
  `language` varchar(255) DEFAULT NULL COMMENT '用户的语言，简体中文为zh_CN',
  `city` varchar(255) DEFAULT NULL COMMENT '用户所在城市',
  `province` varchar(255) DEFAULT NULL COMMENT '用户所在省份',
  `country` varchar(255) DEFAULT NULL COMMENT '用户所在国家',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `subscribe_time` datetime DEFAULT NULL COMMENT '用户关注时间',
  `unsubscribe_time` datetime DEFAULT NULL COMMENT '用户取消关注时间',
  `unionid` int(11) DEFAULT NULL COMMENT '用户unionid，具体含义见微信公众号文档',
  `signScore` varchar(255) DEFAULT NULL COMMENT 'signScore',
  `lastestSignTime` datetime DEFAULT NULL COMMENT '最后一次签到时间',
  `platform_id` int(11) DEFAULT NULL COMMENT '公众平台id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fans
-- ----------------------------

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `uuid` varchar(40) DEFAULT NULL COMMENT '图片uuid',
  `title` varchar(20) DEFAULT NULL COMMENT '图片标题，可以为空',
  `path` varchar(100) NOT NULL COMMENT '图片路径',
  `createTime` datetime NOT NULL COMMENT '上传时间',
  `platform_id` int(11) NOT NULL COMMENT '平台id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('2', '448B96984C76483F852559E0513DEBF5', '测试图片', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:32:09', '1');
INSERT INTO `image` VALUES ('3', 'DEC8B47836B94969A2E1F4FB55E0F12F', '测试图片1', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:51', '1');
INSERT INTO `image` VALUES ('4', '88308482DCE54F8187BE9A64CE65E088', '测试图片2', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('5', '0BA464CEACA44F729B8FF1CE133A880D', '测试图片3', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('6', '620488846D104BA583D4EA55EE9708C6', '测试图片4', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('8', 'C5200B1D5774484C94A4617DCF2AE57F', '测试图片6', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('9', '846651BD93714051843B738086E3C200', '测试图片7', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('10', '28A754C73E6A4F9EA85720342ACCA50A', '测试图片8', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('11', '054D0534C45241EC81EA547C81C8658A', '测试图片9', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('12', 'B2733B716A8C4AB9BBD073C14D9F7146', '测试图片10', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('13', '65B91CF522CC4EE1B1B10C5BD23E7702', '测试图片11', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('14', '75274B515DAD472B9792837828FEAF45', '测试图片12', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('15', '6E48DB5578F847C7861AB33E08FB3213', '测试图片13', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('16', '85F499628CAA489EA445F2D86B562F61', '测试图片14', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('17', '026615ACCC0A4905B37D66DA73622F44', '测试图片15', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:52', '1');
INSERT INTO `image` VALUES ('18', '941A6B1E55644B90B2F1388C5195AAB6', '测试图片16', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:53', '1');
INSERT INTO `image` VALUES ('19', '0299E36079A94FE28A93640135461A01', '测试图片17', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:53', '1');
INSERT INTO `image` VALUES ('20', 'DB32F1F419C6456697BCAC8D0DA2804E', '测试图片18', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:53', '1');
INSERT INTO `image` VALUES ('21', '0FBE85F9DF0E48D895398711F1391E79', '测试图片19', 'http://pic.baidu.com/23432w4.jpg', '2014-09-08 11:41:53', '1');
INSERT INTO `image` VALUES ('22', '963803592f8847d581aaa596cf71415c', 'xhfsc.jpg', 'f:\\tmpFiles\\migo_picture\\f42064b3-916f-4668-870f-cc08914be2b0.jpg', '2014-09-23 14:12:56', '3');
INSERT INTO `image` VALUES ('23', '6c54edf2065743e79af0c51aa0dc019d', 'buy.png', 'f:\\tmpFiles\\migo_picture\\35c20238-9644-458a-a678-0c44b9ea5504.png', '2014-09-23 14:22:39', '3');
INSERT INTO `image` VALUES ('24', 'f224cc53a2fe446196321f3becf5ab0e', '858x683_MarkMan.png', 'f:\\tmpFiles\\migo_picture\\5499be22-d43a-4ecb-bbac-eaec040df42d.png', '2014-09-23 14:22:40', '3');
INSERT INTO `image` VALUES ('25', 'beea6f2b012a49cab2730683d1bc932b', 'btn_order.png', 'f:\\tmpFiles\\migo_picture\\053fe532-9392-4afe-8d64-6fcb1dbfc201.png', '2014-09-23 14:22:40', '3');
INSERT INTO `image` VALUES ('26', 'a2a9012b561e4744ade94f6de3dc63a1', '858x683_MarkMan.png', 'f:\\tmpFiles\\migo_picture\\980c1aee-7196-4ebe-8cf8-8954e4280fce.png', '2014-09-23 14:37:05', '3');
INSERT INTO `image` VALUES ('27', 'a4983632d0a24742971509b5bfbbbf0a', '858x683_MarkMan.png', 'f:\\tmpFiles\\migo_picture\\b82c0e0b-61f0-4ba1-a37d-119b86eb0a32.png', '2014-09-23 14:44:25', '3');
INSERT INTO `image` VALUES ('28', 'faba7db84a0d4d82b6fb05e2f63b660a', '858x683_MarkMan.png', 'f:\\tmpFiles\\migo_picture\\3011a151-d34a-4218-a680-821b4cf84e68.png', '2014-09-23 14:46:09', '3');
INSERT INTO `image` VALUES ('29', 'b15e88fa8d6d47f09b295a2089c6a9b0', '858x683_MarkMan.png', 'f:\\tmpFiles\\migo_picture\\a37da71a-ab52-4ec5-8162-b413934124e8.png', '2014-09-23 14:49:08', '3');
INSERT INTO `image` VALUES ('30', '9c6d62723d1a48458e78fabc84882e6e', '858x683_MarkMan.png', 'f:\\tmpFiles\\migo_picture\\e21c9719-b101-4432-b709-a8b73beef8c0.png', '2014-09-23 14:50:45', '3');
INSERT INTO `image` VALUES ('31', '1fd9105263e8497092aee8364c85049b', '858x683_MarkMan.png', 'f:\\tmpFiles\\migo_picture\\89c9ae91-00f9-4923-8df3-9b9a21ac8760.png', '2014-09-23 14:51:37', '3');
INSERT INTO `image` VALUES ('32', '1f2d8ea9fb684515ab2b46524e5229c5', 'buy.png', 'f:\\tmpFiles\\migo_picture\\0e393c50-842b-4d6a-9b05-153cb5d454d6.png', '2014-09-23 14:52:16', '3');
INSERT INTO `image` VALUES ('33', '207bf335975c4374aa6a6eed03211228', '858x683_MarkMan.png', 'images/2014/09/23/1bf00525-51eb-4f35-9282-0940a6947d19.png', '2014-09-23 15:01:44', '3');
INSERT INTO `image` VALUES ('34', '3ca04c143f2d4b27b2855f198b27a453', 'buy.png', 'images/2014/09/23/90292a1c-2a49-4d54-ac3c-df40860cfb06.png', '2014-09-23 15:05:05', '3');
INSERT INTO `image` VALUES ('35', '85816ad39bf14d43951e62443bd21d60', '858x683_MarkMan.png', 'images/2014/09/23/d4f1331f-497d-4163-8ce5-9e1a456ce145.png', '2014-09-23 15:13:55', '3');
INSERT INTO `image` VALUES ('36', '0dbb60c4120b4f1982b5e4bf8d36110b', '858x683_MarkMan.png', 'images/2014/09/23/58f20896-b072-427d-8dea-440d665a79c0.png', '2014-09-23 15:27:31', '3');
INSERT INTO `image` VALUES ('37', 'dea0c8fdf8e54f738f891f6bbac25cf8', '858x683_MarkMan.png', 'images/2014/09/23/9391b984-d9db-4de7-926c-94d2f035bc10.png', '2014-09-23 15:31:06', '3');
INSERT INTO `image` VALUES ('41', '5ac3d0b1e18e4b14a13d05cc939cd37b', '858x683_MarkMan.png', 'images/2014/09/23/da17e79a-67b1-4a26-b237-a761b64aacbb.png', '2014-09-23 16:29:04', '3');
INSERT INTO `image` VALUES ('42', 'db35003ea16c4b50ad4dbd9d2f1fd309', 'buy.png', 'images/2014/09/23/1e871a8c-bbc6-49df-ac27-079b373fd6cc.png', '2014-09-23 16:31:13', '3');
INSERT INTO `image` VALUES ('44', '8cc202d49e5c4b69bb0287379457013e', 'Desert.jpg', 'images/2014/09/24/d2f9f360-86d2-4129-8f22-e5c386078627.jpg', '2014-09-24 22:19:34', '3');
INSERT INTO `image` VALUES ('45', 'b9831615fb93401c9173492bd7e58b37', 'Hydrangeas.jpg', 'images/2014/09/24/774bd4e3-7cc4-4d39-979e-d6d8b719d429.jpg', '2014-09-24 22:26:39', '3');
INSERT INTO `image` VALUES ('46', 'ffb810e1744f4a3b9d6c4cc1b9004f04', 'Penguins.jpg', 'images/2014/09/24/c90dd521-35e2-440d-b2b4-7707abd2c942.jpg', '2014-09-24 22:28:08', '3');
INSERT INTO `image` VALUES ('47', '4bf60d540fa34338b9f6d1d30be04d28', 'Chrysanthemum.jpg', 'images/2014/09/24/75cdc2d6-4dfa-4192-961b-2d3ef120074b.jpg', '2014-09-24 22:49:28', '3');
INSERT INTO `image` VALUES ('48', '8f717fecdaa1467294a7b5afdd9471ec', 'Chrysanthemum.jpg', 'images/2014/09/24/e75b1f9f-40f9-4466-be76-f535cfd825ea.jpg', '2014-09-24 22:57:11', '3');
INSERT INTO `image` VALUES ('49', '704c013f00594307b5f2b5a94ac8542c', 'Penguins.jpg', 'images/2014/09/24/1e9adff5-8ab7-4bb9-8092-c7a660e97e40.jpg', '2014-09-24 23:00:42', '3');
INSERT INTO `image` VALUES ('50', '31c22599474f43849ef659fff27d6196', 'Lighthouse.jpg', 'images/2014/09/24/63b1e90a-20c9-4eee-b061-7ea2a8929936.jpg', '2014-09-24 23:03:15', '3');
INSERT INTO `image` VALUES ('51', '31b9f6e5f04f4be388699837cdcfe24a', 'Tulips.jpg', 'images/2014/09/24/ab8f281c-9097-4362-9645-59432d6d516a.jpg', '2014-09-24 23:13:23', '3');
INSERT INTO `image` VALUES ('52', 'e0fdf452a657443b8f447d01bd25853d', 'Koala.jpg', 'images/2014/09/24/8a26d5b2-0ca4-44ec-9823-8244b4d8ace6.jpg', '2014-09-24 23:40:05', '3');
INSERT INTO `image` VALUES ('53', '31645653ae94414f92c94fc090b5a248', 'Jellyfish.jpg', 'images/2014/09/25/83f8c1a7-9498-4503-8da7-a043541cf148.jpg', '2014-09-25 09:41:43', '3');
INSERT INTO `image` VALUES ('54', 'c838c23d6dce49f680e4eeae67214876', 'Tulips.jpg', 'images/2014/09/25/2a5f6292-2c85-450d-a1d6-10faa4898c08.jpg', '2014-09-25 09:43:18', '3');
INSERT INTO `image` VALUES ('55', '2a9fa9d1eeb64a488ec058849ce1dedc', 'Chrysanthemum.jpg', 'images/2014/09/25/bb004969-999d-4b5d-ac4d-54f9e453750e.jpg', '2014-09-25 09:51:55', '3');
INSERT INTO `image` VALUES ('56', '6eed11ec04874f46a8212a5243625e3d', 'Desert.jpg', 'images/2014/09/25/f1808ffe-f42e-4b2a-a99b-ceeb1dbfe53e.jpg', '2014-09-25 10:00:41', '3');
INSERT INTO `image` VALUES ('57', '9c9a1ca98ac14785b3525faf4041a7e6', 'Lighthouse.jpg', 'images/2014/09/25/227e9ca1-a1ae-4060-a2d0-a95b990223bd.jpg', '2014-09-25 10:43:25', '3');
INSERT INTO `image` VALUES ('58', '1e8e57d0fd7845b5925a3143e3c38616', 'Hydrangeas.jpg', 'images/2014/09/25/2463b711-0a92-4719-a9bc-f6f58c2413b1.jpg', '2014-09-25 22:18:50', '3');
INSERT INTO `image` VALUES ('59', '6aeb35b7fc52437882064bbe89e302df', 'Hydrangeas.jpg', 'images/2014/09/25/62865612-f7c4-4510-a3dd-57f95087522e.jpg', '2014-09-25 22:26:44', '3');
INSERT INTO `image` VALUES ('60', '78a154a4d2c444f3bad6fc6306f616ca', 'Hydrangeas.jpg', 'images/2014/09/25/bf57cdf5-6378-4009-8c0b-8698d6da132b.jpg', '2014-09-25 22:27:55', '3');
INSERT INTO `image` VALUES ('61', 'c09bb31406ce4341a2aaa7b0f317f542', 'Hydrangeas.jpg', 'images/2014/09/25/a5e485b4-a6f1-4d34-b0b5-cc650f8dd556.jpg', '2014-09-25 22:43:41', '3');
INSERT INTO `image` VALUES ('62', '4f513a6a14e245f890f75069adbb8e8b', 'Hydrangeas.jpg', 'images/2014/09/25/d9bb3758-068e-49aa-bfea-e77b34365747.jpg', '2014-09-25 22:47:02', '3');
INSERT INTO `image` VALUES ('63', '55ec6a40f5da4491bcf05ee6d83cbcf9', 'Jellyfish.jpg', 'images/2014/09/25/db58de17-b1c8-449c-8e6e-72a7e6cf31c1.jpg', '2014-09-25 22:56:01', '3');
INSERT INTO `image` VALUES ('64', 'e2ca952ff32a4ea998a41c3645ab77a1', 'Desert.jpg', 'images/2014/09/25/552aae6d-c95c-41ae-b335-eb658c835cf5.jpg', '2014-09-25 22:57:42', '3');
INSERT INTO `image` VALUES ('65', '0df1c3752c6a4b7dbd1799af27ebdd76', 'Hydrangeas.jpg', 'images/2014/09/25/3cffdf3c-dd40-4fda-9eec-b9f87eb18be7.jpg', '2014-09-25 23:07:14', '3');
INSERT INTO `image` VALUES ('66', '6d7f0078c2f34526995635de2dcef28b', 'Lighthouse.jpg', 'images/2014/09/25/f732c40b-69d0-4a87-902e-dcf9d25506ad.jpg', '2014-09-25 23:13:56', '3');

-- ----------------------------
-- Table structure for linkus
-- ----------------------------
DROP TABLE IF EXISTS `linkus`;
CREATE TABLE `linkus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系我们id',
  `uuid` varchar(40) NOT NULL COMMENT '联系我们uuid',
  `content` varchar(2000) NOT NULL COMMENT '联系我们内容',
  `editTime` datetime NOT NULL COMMENT '编辑时间',
  `platform_id` int(11) NOT NULL COMMENT '公众平台id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linkus
-- ----------------------------
INSERT INTO `linkus` VALUES ('1', '06586BF5AB834108BFFDCBEF4FE71A21', '联系我们呀哈哈', '2014-09-08 12:11:38', '1');
INSERT INTO `linkus` VALUES ('2', '664671ee45fc410d9c52451b343691e4', '<p>阿道夫是打发第三方额外额外热温热佛教三等奖佛披萨大家佛ised</p>', '2014-09-25 21:44:05', '3');

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) NOT NULL COMMENT '公众号uuid',
  `originalId` varchar(30) NOT NULL COMMENT '公众号原始id',
  `platformNo` varchar(50) NOT NULL COMMENT '公众号',
  `userName` varchar(30) NOT NULL COMMENT '公众号登录用户名',
  `password` varchar(30) NOT NULL COMMENT '公众号登录用户密码',
  `appId` varchar(30) NOT NULL COMMENT '公众号appid',
  `appSecret` varchar(40) NOT NULL COMMENT '公众号appSecret',
  `customer_id` int(11) NOT NULL COMMENT '客户id（此公众号的拥有者）',
  `createTime` datetime NOT NULL COMMENT '公众号添加时间',
  `validTime` datetime NOT NULL COMMENT '公众号有效时间',
  `editTime` datetime DEFAULT NULL COMMENT '编辑时间',
  `platformType` int(1) NOT NULL COMMENT '公众号类型  1-服务号 0-订阅号',
  `isAuth` bit(1) NOT NULL COMMENT '公众号是否已经过腾讯认证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  UNIQUE KEY `platformNo` (`platformNo`),
  UNIQUE KEY `originalId` (`originalId`),
  UNIQUE KEY `appId` (`appId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform
-- ----------------------------
INSERT INTO `platform` VALUES ('1', '694153A1D58341C693D4BBC8AE4FB7CC', 'gh_3e7314baeab1', 'luo_shengsha', 'ynlc123@163.com', '123456', '8293iouoidsu8f234', 'lkjsdl3243lkksdj9832u49329jdf', '1', '2014-09-09 20:24:33', '2015-09-09 20:24:33', null, '0', '');
INSERT INTO `platform` VALUES ('3', '4396bb3b9c504295b1f1dd3a3126524c', 'gh_3e7314baeab2', 'luo_shengsha2', 'ynlc123@163.com', '435678799767', '8293iouoidsu8f235', 'sdlfjlw34366666', '3', '2014-09-17 23:12:59', '2015-09-17 23:12:59', '2014-09-26 20:10:29', '0', '\0');

-- ----------------------------
-- Table structure for replymutipleimagetext
-- ----------------------------
DROP TABLE IF EXISTS `replymutipleimagetext`;
CREATE TABLE `replymutipleimagetext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL COMMENT 'uuid',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键词',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `editTime` datetime DEFAULT NULL COMMENT '编辑时间',
  `type` varchar(7) DEFAULT NULL COMMENT '类型 SINGLE：单图文 MUTIPLE：多图文',
  `status` int(1) DEFAULT NULL COMMENT '是否有效',
  `platform_id` int(11) DEFAULT NULL COMMENT '平台id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replymutipleimagetext
-- ----------------------------
INSERT INTO `replymutipleimagetext` VALUES ('1', '3245', '222', '2014-09-23 23:42:17', '2014-09-24 23:42:25', 'SINGLE', '0', '3');
INSERT INTO `replymutipleimagetext` VALUES ('4', '217be8f36fb34098a705fb30da08086d', '中国', '2014-09-24 14:44:02', '2014-09-29 23:03:08', 'MUTIPLE', '1', '3');

-- ----------------------------
-- Table structure for replymutipleimagetext_article
-- ----------------------------
DROP TABLE IF EXISTS `replymutipleimagetext_article`;
CREATE TABLE `replymutipleimagetext_article` (
  `autoReplyArticle_id` int(11) NOT NULL COMMENT '自动回复文章id',
  `article_id` int(11) NOT NULL COMMENT '文章id',
  PRIMARY KEY (`autoReplyArticle_id`,`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replymutipleimagetext_article
-- ----------------------------
INSERT INTO `replymutipleimagetext_article` VALUES ('1', '1');
INSERT INTO `replymutipleimagetext_article` VALUES ('4', '0');

-- ----------------------------
-- Table structure for replytext
-- ----------------------------
DROP TABLE IF EXISTS `replytext`;
CREATE TABLE `replytext` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) NOT NULL COMMENT 'uuid',
  `keywords` varchar(10) NOT NULL COMMENT '关键词',
  `content` varchar(1000) NOT NULL COMMENT '内容',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `editTime` datetime DEFAULT NULL COMMENT '编辑时间',
  `status` int(11) NOT NULL COMMENT '状态 1：正常 0：禁用',
  `platform_id` int(11) NOT NULL COMMENT '公众平台id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replytext
-- ----------------------------
INSERT INTO `replytext` VALUES ('2', '98935a3b38ec4259918718ec834d7eb6', '代发地方大双方都', '2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送2222222是打发是打发发送22222', '2014-09-24 16:55:59', '2014-09-24 17:22:42', '0', '3');
INSERT INTO `replytext` VALUES ('3', '088ec2d3b04c44d184b7096b3df42543', '斑斑驳驳', '嘎嘎嘎嘎嘎嘎嘎嘎嘎', '2014-09-24 17:07:14', null, '0', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
