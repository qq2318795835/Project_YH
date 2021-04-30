/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : dcrep

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2021-04-28 15:56:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus_customer
-- ----------------------------
DROP TABLE IF EXISTS `bus_customer`;
CREATE TABLE `bus_customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `customernName` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `caddress` varchar(255) DEFAULT NULL,
  `ctelephone` varchar(255) DEFAULT NULL COMMENT '客户公司电话',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `contactNumber` varchar(255) DEFAULT NULL COMMENT '联系人电话',
  `backAccount` varchar(255) DEFAULT NULL,
  `contactEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_customer
-- ----------------------------
INSERT INTO `bus_customer` VALUES ('2', '小明超市', '400100', '深圳', '0755-9123131', '张小明', '13025687957', '654431331343413', '213654698@163.com');
INSERT INTO `bus_customer` VALUES ('3', '快八超市', '430000', '武汉', '027-11011011', '雷生', '13434134131', '6543123341334133', '5632155@163.com');
INSERT INTO `bus_customer` VALUES ('4', '永辉超市', '100100', '天津', '0248-1568475', '张老板', '13500549755', '6120321848482245', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('5', '大润发(历下店)', '250000', '山东省济南市历下区文化西路1号', '(0531)86591317', '王志芳', '13263548878', '6120321848482245', '213123@sina.com');
INSERT INTO `bus_customer` VALUES ('6', '华联超市(郭店店)', '250000', '山东省济南市历城区国美电器(郭店连锁店)西60米', '(0531)81213968', '贾燕青', '13500549755', '654431331343413', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('7', '华联超市(舜耕路店)', '250000', '山东省济南市历下区舜耕路28号', '(0531)82596799', '郭卫东', '15698777554', '654431331343413', '265456877@qq.com');
INSERT INTO `bus_customer` VALUES ('8', '华联超市(嘉华购物广场店)', '250000', '济南市槐荫区经二路588号嘉华购物广场B1', '(0531)87082788', '崔红宇', '14756986648', '654431331343413', '261548963@qq.com');
INSERT INTO `bus_customer` VALUES ('10', '永辉超市', '100100', '天津', '0248-15684755', '张老板', '13500549755', '6120321848482245', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('12', '好客来超市', '010010', '呼和浩特', '027-11011011', '李德成', '13434134131', '654312334563214', '23215487@163.com');
INSERT INTO `bus_customer` VALUES ('13', '小张超市', '430000', '武汉', '0271-91231316', '张大明', '13848867958', '654431331343413', '213123@sina.com');
INSERT INTO `bus_customer` VALUES ('14', '小明超市', '518000', '深圳', '0755-91231317', '张小明', '13025687957', '654431331343413', '213123@sina.com');
INSERT INTO `bus_customer` VALUES ('15', '快七超市', '430000', '武汉', '027-11011011', '雷生', '13434134131', '6543123341334133', '6666@66.com');
INSERT INTO `bus_customer` VALUES ('16', '永辉超市', '100100', '天津', '0248-15684755', '张老板', '13500549755', '6120321848482245', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('17', '永辉超市', '100100', '天津', '0248-15684754', '张老板', '13500549755', '6120321848482245', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('18', '大润发(历下店)', '250000', '山东省济南市历下区文化西路1号', '(0531)86591317', '王志芳', '13263548878', '6120321848482245', '213123@sina.com');
INSERT INTO `bus_customer` VALUES ('19', '华联超市(郭店店)', '250000', '山东省济南市历城区国美电器(郭店连锁店)西60米', '(0531)81213968', '贾燕青', '13500549755', '654431331343413', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('20', '小张超市', '430000', '武汉', '0271-91231315', '张大明', '13848867958', '654431331343413', '693215453@163.com');
INSERT INTO `bus_customer` VALUES ('21', '小明超市', '150020', '天津', '0755-91231598', '卡拉金', '13025687957', '654431331343413', '215894782@sina.com');
INSERT INTO `bus_customer` VALUES ('22', '华联超市(郭店店)', '250000', '山东省济南市历城区国美电器(郭店连锁店)西60米', '(0531)81213968', '贾燕青', '13500549755', '654431331343413', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('23', '小张超市', '111', '武汉', '0271-91231315', '张大明', '13848867958', '654431331343413', '213123@sina.com');
INSERT INTO `bus_customer` VALUES ('24', '小明超市123', '1500202', '天津', '0755-91231598', '卡拉金', '13025687957', '654431331343413', '215894782@sina.com');
INSERT INTO `bus_customer` VALUES ('25', '华联超市(郭店店)', '250000', '山东省济南市历城区国美电器(郭店连锁店)西60米', '(0531)81213968', '贾燕青', '13500549755', '654431331343413', '256412569@qq.com');
INSERT INTO `bus_customer` VALUES ('26', '小张超市', '430000', '武汉', '0271-91231315', '张大明', '13848867958', '654431331343413', '693215453@163.com');
INSERT INTO `bus_customer` VALUES ('27', '小明超市', '150020', '天津', '0755-91231598', '卡拉金', '13025687957', '654431331343413', '215894782@sina.com');

-- ----------------------------
-- Table structure for bus_goods
-- ----------------------------
DROP TABLE IF EXISTS `bus_goods`;
CREATE TABLE `bus_goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) DEFAULT '',
  `produceplace` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `gpackage` varchar(255) DEFAULT NULL,
  `productcode` varchar(255) DEFAULT NULL,
  `promitcode` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT '0',
  `dangernum` int(11) DEFAULT '10',
  `gimg` varchar(255) DEFAULT NULL,
  `available` int(4) DEFAULT NULL,
  `pid` int(11) DEFAULT '0',
  `sid` int(11) DEFAULT '0',
  `totalweight` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`gid`) USING BTREE,
  KEY `FK_sq0btr2v2lq8gt8b4gb8tlk0i` (`pid`) USING BTREE,
  KEY `goods_number` (`number`),
  KEY `goods_dangernum` (`dangernum`),
  KEY `goods_name` (`gname`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_goods
-- ----------------------------
INSERT INTO `bus_goods` VALUES ('1', '娃哈哈', '深圳', '120ML', '瓶', 'PH12345', 'PZ1234', '4月5日0时至24时，云南省新增确诊病例15例（含12例无症状感染者转确诊病例），新增无症状感染者2例。4月5日0时至24时，云南省新增确诊病例15例（含12例无症状感染者转确诊病例），新增无症状感染者2例。4月5日0时至24时，云南省新增确诊病例15例（含12例无症状感染者转确诊病例），新增无症状感染者2例。4月5日0时至24时，云南省新增确诊病例15例（含12例无症状感染者转确诊病例）', '2.00', '2976', '10', '2018-12-25/userface1.jpg', '0', '10', '3', '632.40');
INSERT INTO `bus_goods` VALUES ('2', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1500', '100', '2018-12-25/userface5.jpg', '1', '9', '1', '200.00');
INSERT INTO `bus_goods` VALUES ('6', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '950', '10', '2018-12-25/userface4.jpg', '1', '10', null, '300.00');
INSERT INTO `bus_goods` VALUES ('7', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('8', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('9', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '900', '100', '2018-12-25/userface4.jpg', '1', '9', '1', '700.00');
INSERT INTO `bus_goods` VALUES ('10', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1000', '100', '2018-12-25/userface5.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('11', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '1100', '10', '2018-12-25/userface4.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('12', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('13', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('14', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '5000', '100', '2018-12-25/userface4.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('15', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1000', '100', '2018-12-25/userface5.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('16', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '1100', '10', '2018-12-25/userface4.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('17', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('18', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('19', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '5000', '100', '2018-12-25/userface4.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('20', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1000', '100', '2018-12-25/userface5.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('21', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '1100', '10', '2018-12-25/userface4.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('22', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('23', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('24', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '5000', '100', '2018-12-25/userface4.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('25', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1000', '100', '2018-12-25/userface5.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('26', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '1100', '10', '2018-12-25/userface4.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('27', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('28', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('29', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '5000', '100', '2018-12-25/userface4.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('30', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1000', '100', '2018-12-25/userface5.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('31', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '1100', '10', '2018-12-25/userface4.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('32', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('33', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('34', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '5000', '100', '2018-12-25/userface4.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('35', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1000', '100', '2018-12-25/userface5.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('36', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '1100', '10', '2018-12-25/userface4.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('37', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('38', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('39', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '5000', '100', '2018-12-25/userface4.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('40', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '1000', '100', '2018-12-25/userface5.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('41', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '1100', '10', '2018-12-25/userface4.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('42', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '488', '10', '2018-12-25/userface1.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('43', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '1100', '10', '2018-12-25/userface2.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('44', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '2', '100', '2018-12-25/userface4.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('45', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '3', '100', '2018-12-25/userface5.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('46', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '4', '10', '2018-12-25/userface4.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('47', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '6', '10', '2018-12-25/userface1.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('48', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '5', '10', '2018-12-25/userface2.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('49', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '5', '100', '2018-12-25/userface4.jpg', '1', '9', null, null);
INSERT INTO `bus_goods` VALUES ('50', '干脆面', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3.00', '7', '100', '2018-12-25/userface5.jpg', '1', '10', null, null);
INSERT INTO `bus_goods` VALUES ('51', '营养快线', '深圳', '500ML', '瓶', '46523156485', '63265215547', '营养好喝', '5.00', '7', '10', '2018-12-25/userface4.jpg', '1', '11', null, null);
INSERT INTO `bus_goods` VALUES ('52', '娃哈哈', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2.00', '5', '10', '2018-12-25/userface1.jpg', '1', '8', null, null);
INSERT INTO `bus_goods` VALUES ('53', '旺旺雪饼[小包]', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4.00', '6', '10', '2018-12-25/userface2.jpg', '1', '1', null, null);
INSERT INTO `bus_goods` VALUES ('54', '旺旺大礼包', '天津', '500g', '袋', '46525626485', '633655215547', '包含仙贝，小面包等', '20.00', '7', '10', '2018-12-25/userface4.jpg', '1', '2', null, null);

-- ----------------------------
-- Table structure for bus_inport
-- ----------------------------
DROP TABLE IF EXISTS `bus_inport`;
CREATE TABLE `bus_inport` (
  `Iid` int(11) NOT NULL AUTO_INCREMENT,
  `paytype` varchar(255) DEFAULT NULL,
  `inporttime` timestamp NULL DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `inportprice` double(10,2) DEFAULT NULL,
  `providerid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `totalweight` double(10,2) DEFAULT NULL,
  `outportinfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Iid`) USING BTREE,
  KEY `FK_1o4bujsyd2kl4iqw48fie224v` (`providerid`) USING BTREE,
  KEY `FK_ho29poeu4o2dxu4rg1ammeaql` (`goodsid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_inport
-- ----------------------------
INSERT INTO `bus_inport` VALUES ('1', '微信', '2018-05-07 00:00:00', '李四', '100', '备注', '3.50', '8', '1', '1', '56.30', '已退:10箱/10.0kg');
INSERT INTO `bus_inport` VALUES ('2', '支付宝', '2018-05-07 00:00:00', '张三', '1000', '无', '2.50', '9', '2', '1', '33.60', null);
INSERT INTO `bus_inport` VALUES ('3', '银联', '2018-05-07 00:00:00', '张三', '100', '1231', '111.00', '10', '6', '1', '58.30', null);
INSERT INTO `bus_inport` VALUES ('4', '银联', '2018-05-07 00:00:00', '张三', '1000', '无', '2.00', '11', '7', '2', '86.50', null);
INSERT INTO `bus_inport` VALUES ('5', '银联', '2018-05-07 00:00:00', '张三', '100', '无', '1.00', '8', '8', '2', '100.30', null);
INSERT INTO `bus_inport` VALUES ('6', '银联', '2018-05-07 00:00:00', '张三', '100', '1231', '2.50', '9', '9', '2', '120.50', null);
INSERT INTO `bus_inport` VALUES ('8', '支付宝', '2018-05-07 00:00:00', '张三', '100', '', '1.00', '10', '10', '3', '263.90', null);
INSERT INTO `bus_inport` VALUES ('10', '支付宝', '2018-08-07 17:17:57', '超级管理员', '100', 'sadfasfdsa', '1.50', '11', '11', '3', '168.10', null);
INSERT INTO `bus_inport` VALUES ('11', '支付宝', '2018-09-17 16:12:25', '超级管理员', '21', '21', '21.00', '8', '12', '3', '69.10', null);
INSERT INTO `bus_inport` VALUES ('13', '微信', '2018-05-07 00:00:00', '李四', '500', '备注', '3.50', '9', '13', '2', '56.30', null);
INSERT INTO `bus_inport` VALUES ('21', '支付宝', '2018-05-07 00:00:00', '赵六', '300', '备注', '3.50', '10', '14', '3', '200.00', '');
INSERT INTO `bus_inport` VALUES ('22', '肉偿', '2021-04-19 00:00:00', '三号技师', '200', '肉偿支付', '30.30', '11', '15', '1', '100.00', null);
INSERT INTO `bus_inport` VALUES ('23', '银联支付', '2021-04-05 00:00:00', '李四', '200', '货到付款', '3.50', '8', '16', '1', '500.00', null);
INSERT INTO `bus_inport` VALUES ('24', '银联', '2021-04-11 00:00:00', '李四', '200', '123123', '1.50', '9', '2', '3', '50.00', null);
INSERT INTO `bus_inport` VALUES ('25', '银联', '2021-04-12 00:00:00', '超级管理员', '200', '', '3.50', '9', '6', '4', '50.00', null);
INSERT INTO `bus_inport` VALUES ('26', '银联', '2021-04-12 00:00:00', '超级管理员', '200', '打', '3.50', '9', '6', '4', '50.00', null);
INSERT INTO `bus_inport` VALUES ('27', '银联', '2021-04-12 00:00:00', '张三', '200', '打', '3.50', '9', '6', '4', '50.00', null);
INSERT INTO `bus_inport` VALUES ('28', '银联', '2021-04-12 00:00:00', '张三', '10', '打', '3.50', '9', '6', '2', '50.00', null);
INSERT INTO `bus_inport` VALUES ('29', '银联', '2021-04-13 00:00:00', '王五', '100', '修改全部', '1.50', '8', '1', '3', '50.00', '已退:10箱/10.0kg');
INSERT INTO `bus_inport` VALUES ('31', '支付宝', '2021-04-15 00:00:00', '', '10', '测试', '1.50', '8', '1', '2', '10.00', null);
INSERT INTO `bus_inport` VALUES ('33', '微信', '2021-04-23 00:00:00', '张三', '100', '首页进货第二次测试', '2.00', '11', '9', '6', '100.00', null);
INSERT INTO `bus_inport` VALUES ('34', '支付宝', '2021-04-22 00:00:00', '李四', '100', '首页进货第三次测试', '1.00', '11', '9', '7', '100.00', null);
INSERT INTO `bus_inport` VALUES ('35', '微信', '2021-04-22 00:00:00', '王五', '100', '首页进货第四次测试', '3.00', '11', '9', '7', '100.00', null);
INSERT INTO `bus_inport` VALUES ('36', '刷卡', '2021-04-23 00:00:00', '王五', '100', '添加进货日期问题测试', '2.00', '8', '1', '4', '100.00', null);
INSERT INTO `bus_inport` VALUES ('37', '刷卡', '2021-04-24 00:00:00', '管理员', '100', '首页添加进货日期第二次测试', '3.00', '11', '9', '6', '100.00', null);

-- ----------------------------
-- Table structure for bus_outport
-- ----------------------------
DROP TABLE IF EXISTS `bus_outport`;
CREATE TABLE `bus_outport` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `providerid` int(11) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `outputtime` timestamp NULL DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `outportprice` double(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `totalweight` double(10,2) DEFAULT NULL,
  `iid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_outport
-- ----------------------------
INSERT INTO `bus_outport` VALUES ('1', '10', '微信', '2019-08-16 00:00:00', '李四', '2.00', '50', '退货', '1', '2', '50.00', '24');
INSERT INTO `bus_outport` VALUES ('2', '9', '银联', '2019-08-14 00:00:00', '李四', '3.00', '50', '退货', '2', '1', '50.00', '25');
INSERT INTO `bus_outport` VALUES ('3', '10', '支付宝', '2019-08-17 00:00:00', '超级管理员', '5.00', '20', '退货', '6', '3', '20.00', '26');
INSERT INTO `bus_outport` VALUES ('5', '8', '支付宝', '2019-08-17 00:00:00', '赵六', '1.50', '10', '退货', '1', '3', '10.00', '29');
INSERT INTO `bus_outport` VALUES ('6', '11', '微信', '2019-08-15 00:00:00', '超级管理员', '2.00', '40', '退货', '7', '4', '30.00', '27');
INSERT INTO `bus_outport` VALUES ('7', '8', '银联', '2019-08-16 00:00:00', '张三', '4.00', '30', '退货', '8', '5', '46.00', '28');
INSERT INTO `bus_outport` VALUES ('8', '9', '支付宝', '2019-08-17 00:00:00', '张三', '20.00', '60', '退货', '9', '6', '28.00', '29');
INSERT INTO `bus_outport` VALUES ('9', '10', '微信', '2019-08-16 00:00:00', '李四', '2.00', '50', '退货', '1', '2', '50.00', '24');
INSERT INTO `bus_outport` VALUES ('10', '9', '银联', '2019-08-14 00:00:00', '李四', '3.00', '50', '退货', '2', '1', '50.00', '25');
INSERT INTO `bus_outport` VALUES ('11', '10', '支付宝', '2019-08-17 00:00:00', '超级管理员', '5.00', '20', '退货', '6', '3', '20.00', '26');
INSERT INTO `bus_outport` VALUES ('12', '11', '微信', '2019-08-15 00:00:00', '超级管理员', '2.00', '40', '退货', '7', '4', '30.00', '27');
INSERT INTO `bus_outport` VALUES ('13', '8', '银联', '2019-08-16 00:00:00', '张三', '4.00', '30', '退货', '8', '5', '46.00', '28');
INSERT INTO `bus_outport` VALUES ('14', '9', '支付宝', '2019-08-17 00:00:00', '张三', '20.00', '60', '退货', '9', '6', '28.00', '29');
INSERT INTO `bus_outport` VALUES ('15', '10', '微信', '2019-08-16 00:00:00', '李四', '2.00', '50', '退货', '1', '2', '50.00', '24');
INSERT INTO `bus_outport` VALUES ('16', '9', '银联', '2019-08-14 00:00:00', '李四', '3.00', '50', '退货', '2', '1', '50.00', '25');
INSERT INTO `bus_outport` VALUES ('17', '10', '支付宝', '2019-08-17 00:00:00', '超级管理员', '5.00', '20', '退货', '6', '3', '20.00', '26');
INSERT INTO `bus_outport` VALUES ('18', '11', '微信', '2019-08-15 00:00:00', '超级管理员', '2.00', '40', '退货', '7', '4', '30.00', '27');
INSERT INTO `bus_outport` VALUES ('19', '8', '银联', '2019-08-16 00:00:00', '张三', '4.00', '30', '退货', '8', '5', '46.00', '28');
INSERT INTO `bus_outport` VALUES ('20', '9', '支付宝', '2019-08-17 00:00:00', '张三', '20.00', '60', '退货', '9', '6', '28.00', '29');
INSERT INTO `bus_outport` VALUES ('21', '10', '微信', '2019-08-16 00:00:00', '李四', '2.00', '50', '退货', '1', '2', '50.00', '24');
INSERT INTO `bus_outport` VALUES ('22', '9', '银联', '2019-08-14 00:00:00', '李四', '3.00', '50', '退货', '2', '1', '50.00', '25');
INSERT INTO `bus_outport` VALUES ('23', '10', '支付宝', '2019-08-17 00:00:00', '超级管理员', '5.00', '20', '退货', '6', '3', '20.00', '26');
INSERT INTO `bus_outport` VALUES ('24', '11', '微信', '2019-08-15 00:00:00', '超级管理员', '2.00', '40', '退货', '7', '4', '30.00', '27');
INSERT INTO `bus_outport` VALUES ('25', '8', '银联', '2019-08-16 00:00:00', '张三', '4.00', '30', '退货', '8', '5', '46.00', '28');
INSERT INTO `bus_outport` VALUES ('26', '9', '支付宝', '2019-08-17 00:00:00', '张三', '20.00', '60', '退货', '9', '6', '28.00', '29');
INSERT INTO `bus_outport` VALUES ('27', '10', '微信', '2019-08-16 00:00:00', '李四', '2.00', '50', '退货', '1', '2', '50.00', '24');
INSERT INTO `bus_outport` VALUES ('28', '9', '银联', '2019-08-14 00:00:00', '李四', '3.00', '50', '退货', '2', '1', '50.00', '25');
INSERT INTO `bus_outport` VALUES ('29', '10', '支付宝', '2019-08-17 00:00:00', '超级管理员', '5.00', '20', '退货', '6', '3', '20.00', '26');
INSERT INTO `bus_outport` VALUES ('30', '11', '微信', '2019-08-15 00:00:00', '超级管理员', '2.00', '40', '退货', '7', '4', '30.00', '27');
INSERT INTO `bus_outport` VALUES ('31', '8', '银联', '2019-08-16 00:00:00', '张三', '4.00', '30', '退货', '8', '5', '46.00', '28');
INSERT INTO `bus_outport` VALUES ('32', '9', '支付宝', '2019-08-17 00:00:00', '张三', '20.00', '60', '退货', '9', '6', '28.00', '29');
INSERT INTO `bus_outport` VALUES ('33', '10', '微信', '2019-08-16 00:00:00', '李四', '2.00', '50', '退货', '1', '2', '50.00', '24');
INSERT INTO `bus_outport` VALUES ('34', '9', '银联', '2019-08-14 00:00:00', '李四', '3.00', '50', '退货', '2', '1', '50.00', '25');
INSERT INTO `bus_outport` VALUES ('35', '10', '支付宝', '2019-08-17 00:00:00', '超级管理员', '5.00', '20', '退货', '6', '3', '20.00', '26');
INSERT INTO `bus_outport` VALUES ('36', '11', '微信', '2019-08-15 00:00:00', '超级管理员', '2.00', '40', '退货', '7', '4', '30.00', '27');
INSERT INTO `bus_outport` VALUES ('37', '8', '银联', '2019-08-16 00:00:00', '张三', '4.00', '30', '退货', '8', '5', '46.00', '28');
INSERT INTO `bus_outport` VALUES ('53', '8', '微信', null, '李四', '3.50', '10', '终于终于，日期参数可以传上去了', '1', '1', '10.00', '1');
INSERT INTO `bus_outport` VALUES ('54', '8', '微信', '2021-04-16 00:00:00', '李四', '3.50', '10', '终于终于终于日期参数可以上传了', '1', '1', '10.00', '1');

-- ----------------------------
-- Table structure for bus_provider
-- ----------------------------
DROP TABLE IF EXISTS `bus_provider`;
CREATE TABLE `bus_provider` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `providername` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `backAccount` varchar(255) DEFAULT NULL,
  `contactEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_provider
-- ----------------------------
INSERT INTO `bus_provider` VALUES ('8', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('9', '康师傅集团', '031011', '广州东莞', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mcxz321.@gmail.com');
INSERT INTO `bus_provider` VALUES ('10', '旺旺食品', '434000', '仙桃', '0728-4124312', '小明', '13413441141', '696545562154963', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('11', '达利园食品', '430000', '汉川', '0728-4124312', '大明', '13413441141', '632156321456987', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('12', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('13', '康师傅集团', '031011', '广州东莞', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mcxz321.@gmail.com');
INSERT INTO `bus_provider` VALUES ('14', '旺旺食品', '434000', '小面包', '0728-4124312', '明上佐木', '13413441141', '696545562154963', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('15', '达利园食品', '430000', '汉川', '0728-4124312', '大明', '13413441141', '632156321456987', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('16', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('17', '康师傅集团', '052201', '黑龙江', '04715636321', '佐井一郎', '14854632157', '62136987456321', 'zjyl963.@gmail.com');
INSERT INTO `bus_provider` VALUES ('18', '旺旺食品', '434000', '仙桃', '0728-4124312', '小明', '13413441141', '696545562154963', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('19', '达利园食品', '430000', '汉川', '0728-4124312', '大明', '13413441141', '632156321456987', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('20', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('21', '康师傅集团', '031011', '广州东莞', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mcxz321.@gmail.com');
INSERT INTO `bus_provider` VALUES ('22', '旺旺食品', '434000', '仙桃', '0728-4124312', '小明', '13413441141', '696545562154963', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('23', '达利园食品', '430000', '汉川', '0728-4124312', '大明', '13413441141', '632156321456987', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('24', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('25', '康师傅集团', '031011', '广州东莞', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mcxz321.@gmail.com');
INSERT INTO `bus_provider` VALUES ('26', '旺旺食品', '434000', '仙桃', '0728-4124312', '小明', '13413441141', '696545562154963', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('27', '达利园食品', '430000', '汉川', '0728-4124312', '大明', '13413441141', '632156321456987', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('28', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('29', '康师傅集团', '031011', '广州东莞', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mcxz321.@gmail.com');
INSERT INTO `bus_provider` VALUES ('30', '旺旺食品', '434000', '仙桃', '0728-4124312', '小明', '13413441141', '696545562154963', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('31', '达利园食品', '430000', '汉川', '0728-4124312', '大明', '13413441141', '632156321456987', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('32', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('33', '康师傅集团', '031011', '广州东莞', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mcxz321.@gmail.com');
INSERT INTO `bus_provider` VALUES ('34', '康师傅集团', '031011', '广州东莞', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mcxz321.@gmail.com');
INSERT INTO `bus_provider` VALUES ('35', '旺旺食品', '434000', '仙桃', '0728-4124312', '小明', '13413441141', '696545562154963', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('36', '达利园食品', '430000', '汉川', '0728-4124312', '大明', '13413441141', '632156321456987', '12312321@sina.com');
INSERT INTO `bus_provider` VALUES ('37', '娃哈哈集团', '513131', '杭州', '21312', '小晨', '12312', '632159631547698', '123131');
INSERT INTO `bus_provider` VALUES ('38', '康师傅集团', '031011', '上海', '04715632587', '木村杏子', '14854632157', '62136987456321', 'mm633.@gmail.com');

-- ----------------------------
-- Table structure for bus_sales
-- ----------------------------
DROP TABLE IF EXISTS `bus_sales`;
CREATE TABLE `bus_sales` (
  `ssid` mediumint(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `salestime` datetime DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `saleprice` double(10,2) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `salebackinfo` varchar(255) DEFAULT NULL,
  `totalweight` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`ssid`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_sales
-- ----------------------------
INSERT INTO `bus_sales` VALUES ('2', '2', '支付宝', '2020-01-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', null, '100.00');
INSERT INTO `bus_sales` VALUES ('5', '3', '微信', '2020-01-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('6', '4', '云闪付', '2020-01-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('7', '5', '银联', '2020-01-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('8', '6', '未结账', '2020-01-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('9', '2', '支付宝', '2020-02-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('10', '3', '微信', '2020-02-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('11', '4', '云闪付', '2020-02-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('12', '5', '银联', '2020-02-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('13', '6', '未结账', '2020-02-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('14', '2', '支付宝', '2020-03-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('15', '3', '微信', '2020-03-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('16', '4', '云闪付', '2020-03-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('17', '5', '银联', '2020-03-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('18', '6', '未结账', '2020-03-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('19', '2', '支付宝', '2020-04-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('20', '3', '微信', '2020-04-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('21', '4', '云闪付', '2020-04-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('22', '5', '银联', '2020-04-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('23', '6', '未结账', '2020-04-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('24', '2', '支付宝', '2020-05-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('25', '3', '微信', '2020-05-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('26', '4', '云闪付', '2020-05-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('27', '5', '银联', '2020-05-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('28', '6', '未结账', '2020-05-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('29', '2', '支付宝', '2020-06-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('30', '3', '微信', '2020-06-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('31', '4', '云闪付', '2020-06-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('32', '5', '银联', '2020-06-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('33', '6', '未结账', '2020-06-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('34', '2', '支付宝', '2020-07-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('35', '3', '微信', '2020-07-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('36', '4', '云闪付', '2020-07-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('37', '5', '银联', '2020-07-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('38', '6', '未结账', '2020-07-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('39', '2', '支付宝', '2020-08-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('40', '3', '微信', '2020-08-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('41', '4', '云闪付', '2020-08-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('42', '5', '银联', '2020-08-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('43', '6', '未结账', '2020-08-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('44', '2', '支付宝', '2020-09-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('45', '3', '微信', '2020-09-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('46', '4', '云闪付', '2020-09-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('47', '5', '银联', '2020-09-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('48', '6', '未结账', '2020-09-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('49', '2', '支付宝', '2020-10-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('50', '3', '微信', '2020-10-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('51', '4', '云闪付', '2020-10-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('52', '5', '银联', '2020-10-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('53', '6', '未结账', '2020-10-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('54', '2', '支付宝', '2020-11-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('55', '3', '微信', '2020-11-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('56', '4', '云闪付', '2020-11-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('57', '5', '银联', '2020-11-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('58', '6', '未结账', '2020-11-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('59', '2', '支付宝', '2020-12-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('60', '3', '微信', '2020-12-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('61', '4', '云闪付', '2020-12-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('62', '5', '银联', '2020-12-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('63', '6', '未结账', '2020-12-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('64', '2', '支付宝', '2020-04-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('65', '3', '微信', '2020-04-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('66', '4', '云闪付', '2020-05-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('67', '5', '银联', '2020-08-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('68', '6', '未结账', '2020-06-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('69', '2', '支付宝', '2020-09-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('70', '3', '微信', '2020-03-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');
INSERT INTO `bus_sales` VALUES ('71', '4', '云闪付', '2020-10-25 00:00:00', '王五', '321', '只发货一半', '6.00', '6', '3', '', '100.00');
INSERT INTO `bus_sales` VALUES ('72', '5', '银联', '2020-12-15 00:00:00', '赵六', '214', '全款', '12.00', '8', '5', '', '100.00');
INSERT INTO `bus_sales` VALUES ('73', '6', '未结账', '2020-02-19 00:00:00', '超级管理员', '200', '货到付款', '5.00', '9', '2', '', '100.00');
INSERT INTO `bus_sales` VALUES ('74', '2', '支付宝', '2020-11-13 00:00:00', '李四', '326', '备注', '3.50', '1', '4', '', '100.00');
INSERT INTO `bus_sales` VALUES ('75', '3', '微信', '2020-12-02 00:00:00', '张三', '236', '备注', '2.50', '2', '6', '', '100.00');

-- ----------------------------
-- Table structure for bus_salesback
-- ----------------------------
DROP TABLE IF EXISTS `bus_salesback`;
CREATE TABLE `bus_salesback` (
  `sbid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `salesbacktime` datetime DEFAULT NULL,
  `salebackprice` double(10,2) DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `totalweight` double(10,2) DEFAULT NULL,
  `ssid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sbid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_salesback
-- ----------------------------
INSERT INTO `bus_salesback` VALUES ('1', '2', '支付宝', '2020-01-13 00:00:00', '3.50', '李四', '125', '退货', '1', '3', '100.00', '2');
INSERT INTO `bus_salesback` VALUES ('2', '3', '微信', '2020-01-02 00:00:00', '2.50', '张三', '65', '退货', '2', '2', '100.00', '5');
INSERT INTO `bus_salesback` VALUES ('6', '4', '支付宝', '2020-01-25 00:00:00', '6.00', '王五', '75', '商品过期，换货', '6', '5', '100.00', '6');
INSERT INTO `bus_salesback` VALUES ('7', '6', '银联', '2020-01-15 00:00:00', '12.00', '赵六', '84', '退货', '8', '1', '100.00', '7');
INSERT INTO `bus_salesback` VALUES ('8', '7', '微信', '2020-01-19 00:00:00', '5.00', '超级管理员', '35', '退货', '9', '6', '100.00', '8');
INSERT INTO `bus_salesback` VALUES ('9', '2', '支付宝', '2020-02-13 00:00:00', '3.50', '李四', '125', '退货', '1', '3', '100.00', '9');
INSERT INTO `bus_salesback` VALUES ('10', '3', '微信', '2020-02-02 00:00:00', '2.50', '张三', '65', '退货', '2', '2', '100.00', '10');
INSERT INTO `bus_salesback` VALUES ('11', '4', '支付宝', '2020-02-25 00:00:00', '6.00', '王五', '75', '商品过期，换货', '6', '5', '100.00', '11');
INSERT INTO `bus_salesback` VALUES ('12', '6', '银联', '2020-02-15 00:00:00', '12.00', '赵六', '84', '退货', '8', '1', '100.00', '12');
INSERT INTO `bus_salesback` VALUES ('13', '7', '微信', '2020-02-19 00:00:00', '5.00', '超级管理员', '35', '退货', '9', '6', '100.00', '13');
INSERT INTO `bus_salesback` VALUES ('14', '2', '支付宝', '2020-03-13 00:00:00', '3.50', '李四', '125', '退货', '1', '3', '100.00', '14');
INSERT INTO `bus_salesback` VALUES ('15', '3', '微信', '2020-03-02 00:00:00', '2.50', '张三', '65', '退货', '2', '2', '100.00', '15');
INSERT INTO `bus_salesback` VALUES ('16', '4', '支付宝', '2020-03-25 00:00:00', '6.00', '王五', '75', '商品过期，换货', '6', '5', '100.00', '16');
INSERT INTO `bus_salesback` VALUES ('17', '6', '银联', '2020-03-15 00:00:00', '12.00', '赵六', '84', '退货', '8', '1', '100.00', '17');
INSERT INTO `bus_salesback` VALUES ('18', '7', '微信', '2020-03-19 00:00:00', '5.00', '超级管理员', '35', '退货', '9', '6', '100.00', '18');
INSERT INTO `bus_salesback` VALUES ('19', '2', '支付宝', '2020-04-13 00:00:00', '3.50', '李四', '125', '退货', '1', '3', '100.00', '19');
INSERT INTO `bus_salesback` VALUES ('20', '3', '微信', '2020-04-02 00:00:00', '2.50', '张三', '65', '退货', '2', '2', '100.00', '20');
INSERT INTO `bus_salesback` VALUES ('21', '4', '支付宝', '2020-04-25 00:00:00', '6.00', '王五', '75', '商品过期，换货', '6', '5', '100.00', '21');
INSERT INTO `bus_salesback` VALUES ('22', '6', '银联', '2020-04-15 00:00:00', '12.00', '赵六', '84', '退货', '8', '1', '100.00', '22');
INSERT INTO `bus_salesback` VALUES ('23', '2', '支付宝', '2020-04-19 00:00:00', '3.50', '李四', '35', '退货', '1', '3', '100.00', '23');
INSERT INTO `bus_salesback` VALUES ('24', '3', '微信', '2020-05-13 00:00:00', '2.50', '张三', '125', '退货', '2', '2', '100.00', '24');
INSERT INTO `bus_salesback` VALUES ('25', '4', '支付宝', '2020-05-02 00:00:00', '6.00', '王五', '65', '商品过期，换货', '6', '5', '100.00', '25');
INSERT INTO `bus_salesback` VALUES ('26', '6', '银联', '2020-05-25 00:00:00', '12.00', '赵六', '75', '退货', '8', '1', '100.00', '26');
INSERT INTO `bus_salesback` VALUES ('27', '7', '微信', '2020-05-15 00:00:00', '5.00', '超级管理员', '84', '退货', '9', '6', '100.00', '27');
INSERT INTO `bus_salesback` VALUES ('28', '2', '支付宝', '2020-05-19 00:00:00', '3.50', '李四', '35', '退货', '1', '3', '100.00', '28');
INSERT INTO `bus_salesback` VALUES ('29', '3', '微信', '2020-06-13 00:00:00', '2.50', '张三', '125', '退货', '2', '2', '100.00', '29');
INSERT INTO `bus_salesback` VALUES ('30', '4', '支付宝', '2020-06-02 00:00:00', '6.00', '王五', '65', '商品过期，换货', '6', '5', '100.00', '30');
INSERT INTO `bus_salesback` VALUES ('31', '6', '银联', '2020-06-25 00:00:00', '12.00', '赵六', '75', '退货', '8', '1', '100.00', '31');
INSERT INTO `bus_salesback` VALUES ('32', '7', '微信', '2020-06-15 00:00:00', '5.00', '超级管理员', '84', '退货', '9', '6', '100.00', '32');
INSERT INTO `bus_salesback` VALUES ('33', '2', '支付宝', '2020-06-19 00:00:00', '3.50', '李四', '35', '退货', '1', '3', '100.00', '33');
INSERT INTO `bus_salesback` VALUES ('34', '3', '微信', '2020-07-13 00:00:00', '2.50', '张三', '125', '退货', '2', '2', '100.00', '34');
INSERT INTO `bus_salesback` VALUES ('35', '4', '支付宝', '2020-07-02 00:00:00', '6.00', '王五', '65', '商品过期，换货', '6', '5', '100.00', '35');
INSERT INTO `bus_salesback` VALUES ('36', '6', '银联', '2020-07-25 00:00:00', '12.00', '赵六', '75', '退货', '8', '1', '100.00', '36');
INSERT INTO `bus_salesback` VALUES ('37', '7', '微信', '2020-07-15 00:00:00', '5.00', '超级管理员', '84', '退货', '9', '6', '100.00', '37');
INSERT INTO `bus_salesback` VALUES ('38', '2', '支付宝', '2020-07-19 00:00:00', '3.50', '李四', '35', '退货', '1', '3', '100.00', '38');
INSERT INTO `bus_salesback` VALUES ('39', '3', '微信', '2020-08-13 00:00:00', '2.50', '张三', '125', '退货', '2', '2', '100.00', '39');
INSERT INTO `bus_salesback` VALUES ('40', '4', '支付宝', '2020-08-02 00:00:00', '6.00', '王五', '65', '商品过期，换货', '6', '5', '100.00', '40');
INSERT INTO `bus_salesback` VALUES ('41', '6', '银联', '2020-08-25 00:00:00', '12.00', '赵六', '75', '退货', '8', '1', '100.00', '41');
INSERT INTO `bus_salesback` VALUES ('42', '2', '支付宝', '2020-08-15 00:00:00', '3.50', '李四', '84', '退货', '1', '3', '100.00', '42');
INSERT INTO `bus_salesback` VALUES ('43', '3', '微信', '2020-08-19 00:00:00', '2.50', '张三', '35', '退货', '2', '2', '100.00', '43');
INSERT INTO `bus_salesback` VALUES ('44', '4', '支付宝', '2020-09-13 00:00:00', '6.00', '王五', '125', '商品过期，换货', '6', '5', '100.00', '44');
INSERT INTO `bus_salesback` VALUES ('45', '6', '银联', '2020-09-02 00:00:00', '12.00', '赵六', '65', '退货', '8', '1', '100.00', '45');
INSERT INTO `bus_salesback` VALUES ('46', '7', '微信', '2020-09-25 00:00:00', '5.00', '超级管理员', '75', '退货', '9', '6', '100.00', '46');
INSERT INTO `bus_salesback` VALUES ('47', '2', '支付宝', '2020-09-15 00:00:00', '3.50', '李四', '84', '退货', '1', '3', '100.00', '47');
INSERT INTO `bus_salesback` VALUES ('48', '3', '微信', '2020-09-19 00:00:00', '2.50', '张三', '35', '退货', '2', '2', '100.00', '48');
INSERT INTO `bus_salesback` VALUES ('49', '4', '支付宝', '2020-10-13 00:00:00', '6.00', '王五', '125', '商品过期，换货', '6', '5', '100.00', '49');
INSERT INTO `bus_salesback` VALUES ('50', '6', '银联', '2020-10-02 00:00:00', '12.00', '赵六', '65', '退货', '8', '1', '100.00', '50');
INSERT INTO `bus_salesback` VALUES ('51', '7', '微信', '2020-10-25 00:00:00', '5.00', '超级管理员', '75', '退货', '9', '6', '100.00', '51');
INSERT INTO `bus_salesback` VALUES ('52', '2', '支付宝', '2020-10-15 00:00:00', '3.50', '李四', '84', '退货', '1', '3', '100.00', '52');
INSERT INTO `bus_salesback` VALUES ('53', '3', '微信', '2020-10-19 00:00:00', '2.50', '张三', '35', '退货', '2', '2', '100.00', '53');
INSERT INTO `bus_salesback` VALUES ('54', '4', '支付宝', '2020-11-13 00:00:00', '6.00', '王五', '125', '商品过期，换货', '6', '5', '100.00', '54');
INSERT INTO `bus_salesback` VALUES ('55', '6', '银联', '2020-11-02 00:00:00', '12.00', '赵六', '65', '退货', '8', '1', '100.00', '55');
INSERT INTO `bus_salesback` VALUES ('56', '7', '微信', '2020-11-25 00:00:00', '5.00', '超级管理员', '75', '退货', '9', '6', '100.00', '56');
INSERT INTO `bus_salesback` VALUES ('57', '2', '支付宝', '2020-11-15 00:00:00', '3.50', '李四', '84', '退货', '1', '3', '100.00', '57');
INSERT INTO `bus_salesback` VALUES ('58', '3', '微信', '2020-11-19 00:00:00', '2.50', '张三', '35', '退货', '2', '2', '100.00', '58');
INSERT INTO `bus_salesback` VALUES ('59', '4', '支付宝', '2020-12-13 00:00:00', '6.00', '王五', '125', '商品过期，换货', '6', '5', '100.00', '59');
INSERT INTO `bus_salesback` VALUES ('60', '6', '银联', '2020-12-02 00:00:00', '12.00', '赵六', '65', '退货', '8', '1', '100.00', '60');
INSERT INTO `bus_salesback` VALUES ('61', '2', '支付宝', '2020-12-25 00:00:00', '3.50', '李四', '75', '退货', '1', '3', '100.00', '61');
INSERT INTO `bus_salesback` VALUES ('62', '3', '微信', '2020-12-15 00:00:00', '2.50', '张三', '84', '退货', '2', '2', '100.00', '62');
INSERT INTO `bus_salesback` VALUES ('63', '4', '支付宝', '2020-12-19 00:00:00', '6.00', '王五', '35', '商品过期，换货', '6', '5', '100.00', '63');
INSERT INTO `bus_salesback` VALUES ('64', '6', '银联', '2020-04-13 00:00:00', '12.00', '赵六', '125', '退货', '8', '1', '100.00', '64');
INSERT INTO `bus_salesback` VALUES ('65', '7', '微信', '2020-04-02 00:00:00', '5.00', '超级管理员', '65', '退货', '9', '6', '100.00', '65');
INSERT INTO `bus_salesback` VALUES ('66', '2', '支付宝', '2020-05-25 00:00:00', '3.50', '李四', '75', '退货', '1', '3', '100.00', '66');
INSERT INTO `bus_salesback` VALUES ('67', '3', '微信', '2020-08-15 00:00:00', '2.50', '张三', '84', '退货', '2', '2', '100.00', '67');
INSERT INTO `bus_salesback` VALUES ('68', '4', '支付宝', '2020-06-19 00:00:00', '6.00', '王五', '35', '商品过期，换货', '6', '5', '100.00', '68');
INSERT INTO `bus_salesback` VALUES ('69', '6', '银联', '2020-09-13 00:00:00', '12.00', '赵六', '125', '退货', '8', '1', '100.00', '69');
INSERT INTO `bus_salesback` VALUES ('70', '7', '微信', '2020-03-02 00:00:00', '5.00', '超级管理员', '65', '退货', '9', '6', '100.00', '70');
INSERT INTO `bus_salesback` VALUES ('71', '2', '支付宝', '2020-10-25 00:00:00', '3.50', '李四', '75', '退货', '1', '3', '100.00', '71');
INSERT INTO `bus_salesback` VALUES ('72', '3', '微信', '2020-12-15 00:00:00', '2.50', '张三', '84', '退货', '2', '2', '100.00', '72');
INSERT INTO `bus_salesback` VALUES ('73', '4', '支付宝', '2020-02-19 00:00:00', '6.00', '王五', '35', '商品过期，换货', '6', '5', '100.00', '73');
INSERT INTO `bus_salesback` VALUES ('74', '6', '银联', '2020-11-13 00:00:00', '12.00', '赵六', '65', '退货', '8', '1', '100.00', '74');
INSERT INTO `bus_salesback` VALUES ('75', '7', '微信', '2020-12-02 00:00:00', '5.00', '超级管理员', '75', '退货', '9', '6', '100.00', '75');
INSERT INTO `bus_salesback` VALUES ('85', '5', '微信', '2020-08-02 00:00:00', '3.20', '张三', '48', '退货', '9', '7', '100.00', '76');

-- ----------------------------
-- Table structure for bus_storehouse
-- ----------------------------
DROP TABLE IF EXISTS `bus_storehouse`;
CREATE TABLE `bus_storehouse` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `total` double(10,2) DEFAULT NULL,
  `margin` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_storehouse
-- ----------------------------
INSERT INTO `bus_storehouse` VALUES ('1', '一号仓库', '天津市滨海新区泉水道23号', '1000.00', '377.60');
INSERT INTO `bus_storehouse` VALUES ('2', '二号仓库', '天津市滨海新区泉水道23号', '1000.00', '490.00');
INSERT INTO `bus_storehouse` VALUES ('3', '三号仓库', '天津市滨海新区泉水道24号', '1000.00', '410.00');
INSERT INTO `bus_storehouse` VALUES ('4', '四号仓库', '天津市滨海新区泉水道25号', '1000.00', '650.00');
INSERT INTO `bus_storehouse` VALUES ('5', '五号仓库', '天津市滨海新区泉水道26号', '1000.00', '900.00');
INSERT INTO `bus_storehouse` VALUES ('6', '六号仓库', '天津市滨海新区泉水道27号', '1000.00', '800.00');
INSERT INTO `bus_storehouse` VALUES ('7', '七号仓库', '天津市滨海新区泉水道55号', '2000.00', '800.00');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dpid` int(11) NOT NULL,
  `dtitle` varchar(255) DEFAULT NULL,
  `dopen` int(11) DEFAULT NULL,
  `dremark` varchar(255) DEFAULT NULL,
  `daddress` varchar(255) DEFAULT NULL,
  `davailable` int(11) DEFAULT NULL COMMENT '状态【0不可用1可用】',
  `dordernum` int(11) DEFAULT NULL COMMENT '排序码【为了调事显示顺序】',
  `dcreatetime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '总经办', '1', '权利最高', '北京', '1', '1', '2019-04-08 00:00:00');
INSERT INTO `sys_dept` VALUES ('2', '1', '销售部', '0', '销售', '武汉', '1', '2', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('3', '1', '运营部', '0', '无', '武汉', '1', '3', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('4', '1', '生产部', '0', '无', '武汉', '1', '4', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('5', '2', '销售一部', '0', '销售一部', '武汉', '1', '5', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('6', '2', '销售二部', '0', '销售二部', '武汉', '1', '6', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('7', '3', '运营一部', '0', '运营一部', '武汉', '1', '7', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('8', '2', '销售三部', '0', '销售三部', '深圳', '1', '8', '2021-03-02 22:24:36');
INSERT INTO `sys_dept` VALUES ('9', '2', '销售四部', '0', '销售四部', '广州', '1', '9', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('10', '2', '销售五部', '0', '销售五部', '济南', '1', '10', '2019-04-10 00:00:00');
INSERT INTO `sys_dept` VALUES ('11', '4', '生产一部', '0', '生产食品', '武汉', '1', '11', '2021-03-31 22:21:02');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '权限类型[menu/permission]',
  `title` varchar(255) DEFAULT NULL,
  `percode` varchar(255) DEFAULT NULL COMMENT '权限编码[只有type= permission才有  user:view]',
  `icon` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `open` int(11) DEFAULT NULL,
  `ordernum` int(11) DEFAULT NULL,
  `available` int(11) DEFAULT NULL COMMENT '状态【0不可用1可用】',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '0', 'menu', '尚学堂进销存管理系统', null, '&#xe68e;', '', '', '1', '1', '1');
INSERT INTO `sys_permission` VALUES ('2', '1', 'menu', '基础管理', null, '&#xe857;', '', '', '1', '2', '1');
INSERT INTO `sys_permission` VALUES ('3', '1', 'menu', '进货管理', null, '&#xe645;', '', null, '0', '3', '1');
INSERT INTO `sys_permission` VALUES ('4', '1', 'menu', '销售管理', null, '&#xe611;', '', '', '0', '4', '1');
INSERT INTO `sys_permission` VALUES ('5', '1', 'menu', '系统管理', null, '&#xe614;', '', '', '0', '5', '1');
INSERT INTO `sys_permission` VALUES ('6', '1', 'menu', '其它管理', null, '&#xe628;', '', '', '0', '6', '1');
INSERT INTO `sys_permission` VALUES ('7', '2', 'menu', '客户管理', null, '&#xe651;', '/bus/toCustomerManager', '', '0', '7', '1');
INSERT INTO `sys_permission` VALUES ('8', '2', 'menu', '供应商管理', null, '&#xe658;', '/bus/toProviderManager', '', '0', '8', '1');
INSERT INTO `sys_permission` VALUES ('9', '2', 'menu', '商品管理', null, '&#xe657;', '/bus/toGoodsManager', '', '0', '9', '1');
INSERT INTO `sys_permission` VALUES ('10', '3', 'menu', '商品进货', null, '&#xe756;', '/bus/toInportManager', '', '0', '10', '1');
INSERT INTO `sys_permission` VALUES ('11', '3', 'menu', '商品退货查询', null, '&#xe65a;', '/bus/toOutportManager', '', '0', '11', '1');
INSERT INTO `sys_permission` VALUES ('12', '4', 'menu', '商品销售', null, '&#xe65b;', '', '', '0', '12', '1');
INSERT INTO `sys_permission` VALUES ('13', '4', 'menu', '销售退货查询', null, '&#xe770;', '', '', '0', '13', '1');
INSERT INTO `sys_permission` VALUES ('14', '5', 'menu', '部门管理', null, '&#xe770;', '/sys/toDeptManager', '', '0', '14', '1');
INSERT INTO `sys_permission` VALUES ('15', '5', 'menu', '菜单管理', null, '&#xe857;', '/sys/toMenuManager', '', '0', '15', '1');
INSERT INTO `sys_permission` VALUES ('16', '5', 'menu', '权限管理', '', '&#xe857;', '/sys/toPermissionManager', '', '0', '16', '1');
INSERT INTO `sys_permission` VALUES ('17', '5', 'menu', '角色管理', '', '&#xe650;', '/sys/toRoleManager', '', '0', '17', '1');
INSERT INTO `sys_permission` VALUES ('18', '5', 'menu', '用户管理', '', '&#xe612;', '/sys/toUserManager', '', '0', '18', '1');
INSERT INTO `sys_permission` VALUES ('21', '6', 'menu', '登陆日志', null, '&#xe675;', '/sys/toLogLoginManager', '', '0', '21', '1');
INSERT INTO `sys_permission` VALUES ('22', '6', 'menu', '系统公告', null, '&#xe756;', '/sys/toNoticeManager', null, '0', '22', '1');
INSERT INTO `sys_permission` VALUES ('23', '6', 'menu', '图标管理', null, '&#xe670;', '../resources/page/icon.html', null, '0', '23', '1');
INSERT INTO `sys_permission` VALUES ('30', '14', 'permission', '添加部门', 'dept:create', '', null, null, '0', '24', '1');
INSERT INTO `sys_permission` VALUES ('31', '14', 'permission', '修改部门', 'dept:update', '', null, null, '0', '26', '1');
INSERT INTO `sys_permission` VALUES ('32', '14', 'permission', '删除部门', 'dept:delete', '', null, null, '0', '27', '1');
INSERT INTO `sys_permission` VALUES ('34', '15', 'permission', '添加菜单', 'menu:create', '', '', '', '0', '29', '1');
INSERT INTO `sys_permission` VALUES ('35', '15', 'permission', '修改菜单', 'menu:update', '', null, null, '0', '30', '1');
INSERT INTO `sys_permission` VALUES ('36', '15', 'permission', '删除菜单', 'menu:delete', '', null, null, '0', '31', '1');
INSERT INTO `sys_permission` VALUES ('38', '16', 'permission', '添加权限', 'permission:create', '', null, null, '0', '33', '1');
INSERT INTO `sys_permission` VALUES ('39', '16', 'permission', '修改权限', 'permission:update', '', null, null, '0', '34', '1');
INSERT INTO `sys_permission` VALUES ('40', '16', 'permission', '删除权限', 'permission:delete', '', null, null, '0', '35', '1');
INSERT INTO `sys_permission` VALUES ('42', '17', 'permission', '添加角色', 'role:create', '', null, null, '0', '37', '1');
INSERT INTO `sys_permission` VALUES ('43', '17', 'permission', '修改角色', 'role:update', '', null, null, '0', '38', '1');
INSERT INTO `sys_permission` VALUES ('44', '17', 'permission', '角色删除', 'role:delete', '', null, null, '0', '39', '1');
INSERT INTO `sys_permission` VALUES ('46', '17', 'permission', '分配权限', 'role:selectPermission', '', null, null, '0', '41', '1');
INSERT INTO `sys_permission` VALUES ('47', '18', 'permission', '添加用户', 'user:create', '', null, null, '0', '42', '1');
INSERT INTO `sys_permission` VALUES ('48', '18', 'permission', '修改用户', 'user:update', '', null, null, '0', '43', '1');
INSERT INTO `sys_permission` VALUES ('49', '18', 'permission', '删除用户', 'user:delete', '', null, null, '0', '44', '1');
INSERT INTO `sys_permission` VALUES ('51', '18', 'permission', '用户分配角色', 'user:selectRole', '', null, null, '0', '46', '1');
INSERT INTO `sys_permission` VALUES ('52', '18', 'permission', '重置密码', 'user:resetPwd', null, null, null, '0', '47', '1');
INSERT INTO `sys_permission` VALUES ('53', '14', 'permission', '部门查询', 'dept:view', null, null, null, '0', '48', '1');
INSERT INTO `sys_permission` VALUES ('54', '15', 'permission', '菜单查询', 'menu:view', null, null, null, '0', '49', '1');
INSERT INTO `sys_permission` VALUES ('55', '16', 'permission', '权限查询', 'permission:view', null, null, null, '0', '50', '1');
INSERT INTO `sys_permission` VALUES ('56', '17', 'permission', '角色查询', 'role:view', null, null, null, '0', '51', '1');
INSERT INTO `sys_permission` VALUES ('57', '18', 'permission', '用户查询', 'user:view', null, null, null, '0', '52', '1');
INSERT INTO `sys_permission` VALUES ('68', '7', 'permission', '客户查询', 'customer:view', null, null, null, null, '60', '1');
INSERT INTO `sys_permission` VALUES ('69', '7', 'permission', '客户添加', 'customer:create', null, null, null, null, '61', '1');
INSERT INTO `sys_permission` VALUES ('70', '7', 'permission', '客户修改', 'customer:update', null, null, null, null, '62', '1');
INSERT INTO `sys_permission` VALUES ('71', '7', 'permission', '客户删除', 'customer:delete', null, null, null, null, '63', '1');
INSERT INTO `sys_permission` VALUES ('73', '21', 'permission', '日志查询', 'info:view', null, null, null, null, '65', '1');
INSERT INTO `sys_permission` VALUES ('74', '21', 'permission', '日志删除', 'info:delete', null, null, null, null, '66', '1');
INSERT INTO `sys_permission` VALUES ('75', '21', 'permission', '日志批量删除', 'info:batchdelete', null, null, null, null, '67', '1');
INSERT INTO `sys_permission` VALUES ('76', '22', 'permission', '公告查询', 'notice:view', null, null, null, null, '68', '1');
INSERT INTO `sys_permission` VALUES ('77', '22', 'permission', '公告添加', 'notice:create', null, null, null, null, '69', '1');
INSERT INTO `sys_permission` VALUES ('78', '22', 'permission', '公告修改', 'notice:update', null, null, null, null, '70', '1');
INSERT INTO `sys_permission` VALUES ('79', '22', 'permission', '公告删除', 'notice:delete', null, null, null, null, '71', '1');
INSERT INTO `sys_permission` VALUES ('81', '8', 'permission', '供应商查询', 'provider:view', null, null, null, null, '73', '1');
INSERT INTO `sys_permission` VALUES ('82', '8', 'permission', '供应商添加', 'provider:create', null, null, null, null, '74', '1');
INSERT INTO `sys_permission` VALUES ('83', '8', 'permission', '供应商修改', 'provider:update', null, null, null, null, '75', '1');
INSERT INTO `sys_permission` VALUES ('84', '8', 'permission', '供应商删除', 'provider:delete', null, null, null, null, '76', '1');
INSERT INTO `sys_permission` VALUES ('86', '22', 'permission', '公告查看', 'notice:viewnotice', null, null, null, null, '78', '1');
INSERT INTO `sys_permission` VALUES ('91', '9', 'permission', '商品查询', 'goods:view', null, null, null, '0', '79', '1');
INSERT INTO `sys_permission` VALUES ('92', '9', 'permission', '商品添加', 'goods:create', null, null, null, '0', '80', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有菜单权限', '1', '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES ('4', '基础数据管理员', '基础数据管理员', '1', '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES ('5', '仓库管理员', '仓库管理员', '1', '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES ('6', '销售管理员', '销售管理员', '1', '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES ('7', '系统管理员', '系统管理员', '1', '2019-04-10 14:06:32');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`pid`,`rid`) USING BTREE,
  KEY `FK_tcsr9ucxypb3ce1q5qngsfk33` (`rid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('1', '5');
INSERT INTO `sys_role_permission` VALUES ('1', '6');
INSERT INTO `sys_role_permission` VALUES ('1', '7');
INSERT INTO `sys_role_permission` VALUES ('1', '8');
INSERT INTO `sys_role_permission` VALUES ('1', '9');
INSERT INTO `sys_role_permission` VALUES ('1', '10');
INSERT INTO `sys_role_permission` VALUES ('1', '11');
INSERT INTO `sys_role_permission` VALUES ('1', '12');
INSERT INTO `sys_role_permission` VALUES ('1', '13');
INSERT INTO `sys_role_permission` VALUES ('1', '14');
INSERT INTO `sys_role_permission` VALUES ('1', '15');
INSERT INTO `sys_role_permission` VALUES ('1', '16');
INSERT INTO `sys_role_permission` VALUES ('1', '17');
INSERT INTO `sys_role_permission` VALUES ('1', '18');
INSERT INTO `sys_role_permission` VALUES ('1', '21');
INSERT INTO `sys_role_permission` VALUES ('1', '22');
INSERT INTO `sys_role_permission` VALUES ('1', '23');
INSERT INTO `sys_role_permission` VALUES ('1', '31');
INSERT INTO `sys_role_permission` VALUES ('1', '34');
INSERT INTO `sys_role_permission` VALUES ('1', '35');
INSERT INTO `sys_role_permission` VALUES ('1', '36');
INSERT INTO `sys_role_permission` VALUES ('1', '38');
INSERT INTO `sys_role_permission` VALUES ('1', '39');
INSERT INTO `sys_role_permission` VALUES ('1', '40');
INSERT INTO `sys_role_permission` VALUES ('1', '42');
INSERT INTO `sys_role_permission` VALUES ('1', '43');
INSERT INTO `sys_role_permission` VALUES ('1', '44');
INSERT INTO `sys_role_permission` VALUES ('1', '46');
INSERT INTO `sys_role_permission` VALUES ('1', '47');
INSERT INTO `sys_role_permission` VALUES ('1', '48');
INSERT INTO `sys_role_permission` VALUES ('1', '49');
INSERT INTO `sys_role_permission` VALUES ('1', '51');
INSERT INTO `sys_role_permission` VALUES ('1', '52');
INSERT INTO `sys_role_permission` VALUES ('1', '53');
INSERT INTO `sys_role_permission` VALUES ('1', '54');
INSERT INTO `sys_role_permission` VALUES ('1', '55');
INSERT INTO `sys_role_permission` VALUES ('1', '56');
INSERT INTO `sys_role_permission` VALUES ('1', '57');
INSERT INTO `sys_role_permission` VALUES ('1', '68');
INSERT INTO `sys_role_permission` VALUES ('1', '69');
INSERT INTO `sys_role_permission` VALUES ('1', '70');
INSERT INTO `sys_role_permission` VALUES ('1', '71');
INSERT INTO `sys_role_permission` VALUES ('1', '73');
INSERT INTO `sys_role_permission` VALUES ('1', '74');
INSERT INTO `sys_role_permission` VALUES ('1', '75');
INSERT INTO `sys_role_permission` VALUES ('1', '76');
INSERT INTO `sys_role_permission` VALUES ('1', '77');
INSERT INTO `sys_role_permission` VALUES ('1', '78');
INSERT INTO `sys_role_permission` VALUES ('1', '79');
INSERT INTO `sys_role_permission` VALUES ('1', '81');
INSERT INTO `sys_role_permission` VALUES ('1', '82');
INSERT INTO `sys_role_permission` VALUES ('1', '83');
INSERT INTO `sys_role_permission` VALUES ('1', '84');
INSERT INTO `sys_role_permission` VALUES ('1', '86');
INSERT INTO `sys_role_permission` VALUES ('1', '91');
INSERT INTO `sys_role_permission` VALUES ('1', '92');
INSERT INTO `sys_role_permission` VALUES ('4', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '2');
INSERT INTO `sys_role_permission` VALUES ('4', '5');
INSERT INTO `sys_role_permission` VALUES ('4', '7');
INSERT INTO `sys_role_permission` VALUES ('4', '8');
INSERT INTO `sys_role_permission` VALUES ('4', '9');
INSERT INTO `sys_role_permission` VALUES ('4', '14');
INSERT INTO `sys_role_permission` VALUES ('4', '15');
INSERT INTO `sys_role_permission` VALUES ('4', '16');
INSERT INTO `sys_role_permission` VALUES ('4', '17');
INSERT INTO `sys_role_permission` VALUES ('4', '18');
INSERT INTO `sys_role_permission` VALUES ('4', '30');
INSERT INTO `sys_role_permission` VALUES ('4', '31');
INSERT INTO `sys_role_permission` VALUES ('4', '32');
INSERT INTO `sys_role_permission` VALUES ('4', '34');
INSERT INTO `sys_role_permission` VALUES ('4', '35');
INSERT INTO `sys_role_permission` VALUES ('4', '36');
INSERT INTO `sys_role_permission` VALUES ('4', '38');
INSERT INTO `sys_role_permission` VALUES ('4', '39');
INSERT INTO `sys_role_permission` VALUES ('4', '40');
INSERT INTO `sys_role_permission` VALUES ('4', '42');
INSERT INTO `sys_role_permission` VALUES ('4', '43');
INSERT INTO `sys_role_permission` VALUES ('4', '44');
INSERT INTO `sys_role_permission` VALUES ('4', '46');
INSERT INTO `sys_role_permission` VALUES ('4', '47');
INSERT INTO `sys_role_permission` VALUES ('4', '48');
INSERT INTO `sys_role_permission` VALUES ('4', '49');
INSERT INTO `sys_role_permission` VALUES ('4', '51');
INSERT INTO `sys_role_permission` VALUES ('4', '52');
INSERT INTO `sys_role_permission` VALUES ('4', '53');
INSERT INTO `sys_role_permission` VALUES ('4', '54');
INSERT INTO `sys_role_permission` VALUES ('4', '55');
INSERT INTO `sys_role_permission` VALUES ('4', '56');
INSERT INTO `sys_role_permission` VALUES ('4', '57');
INSERT INTO `sys_role_permission` VALUES ('4', '68');
INSERT INTO `sys_role_permission` VALUES ('4', '69');
INSERT INTO `sys_role_permission` VALUES ('4', '70');
INSERT INTO `sys_role_permission` VALUES ('4', '71');
INSERT INTO `sys_role_permission` VALUES ('4', '81');
INSERT INTO `sys_role_permission` VALUES ('4', '82');
INSERT INTO `sys_role_permission` VALUES ('4', '83');
INSERT INTO `sys_role_permission` VALUES ('4', '84');
INSERT INTO `sys_role_permission` VALUES ('4', '91');
INSERT INTO `sys_role_permission` VALUES ('4', '92');
INSERT INTO `sys_role_permission` VALUES ('5', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '3');
INSERT INTO `sys_role_permission` VALUES ('5', '4');
INSERT INTO `sys_role_permission` VALUES ('5', '10');
INSERT INTO `sys_role_permission` VALUES ('5', '11');
INSERT INTO `sys_role_permission` VALUES ('5', '12');
INSERT INTO `sys_role_permission` VALUES ('5', '13');
INSERT INTO `sys_role_permission` VALUES ('6', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '4');
INSERT INTO `sys_role_permission` VALUES ('6', '12');
INSERT INTO `sys_role_permission` VALUES ('6', '13');
INSERT INTO `sys_role_permission` VALUES ('7', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '5');
INSERT INTO `sys_role_permission` VALUES ('7', '6');
INSERT INTO `sys_role_permission` VALUES ('7', '14');
INSERT INTO `sys_role_permission` VALUES ('7', '15');
INSERT INTO `sys_role_permission` VALUES ('7', '16');
INSERT INTO `sys_role_permission` VALUES ('7', '17');
INSERT INTO `sys_role_permission` VALUES ('7', '18');
INSERT INTO `sys_role_permission` VALUES ('7', '21');
INSERT INTO `sys_role_permission` VALUES ('7', '22');
INSERT INTO `sys_role_permission` VALUES ('7', '23');
INSERT INTO `sys_role_permission` VALUES ('7', '30');
INSERT INTO `sys_role_permission` VALUES ('7', '31');
INSERT INTO `sys_role_permission` VALUES ('7', '32');
INSERT INTO `sys_role_permission` VALUES ('7', '34');
INSERT INTO `sys_role_permission` VALUES ('7', '35');
INSERT INTO `sys_role_permission` VALUES ('7', '36');
INSERT INTO `sys_role_permission` VALUES ('7', '38');
INSERT INTO `sys_role_permission` VALUES ('7', '39');
INSERT INTO `sys_role_permission` VALUES ('7', '40');
INSERT INTO `sys_role_permission` VALUES ('7', '42');
INSERT INTO `sys_role_permission` VALUES ('7', '43');
INSERT INTO `sys_role_permission` VALUES ('7', '44');
INSERT INTO `sys_role_permission` VALUES ('7', '46');
INSERT INTO `sys_role_permission` VALUES ('7', '47');
INSERT INTO `sys_role_permission` VALUES ('7', '48');
INSERT INTO `sys_role_permission` VALUES ('7', '49');
INSERT INTO `sys_role_permission` VALUES ('7', '51');
INSERT INTO `sys_role_permission` VALUES ('7', '52');
INSERT INTO `sys_role_permission` VALUES ('7', '53');
INSERT INTO `sys_role_permission` VALUES ('7', '54');
INSERT INTO `sys_role_permission` VALUES ('7', '55');
INSERT INTO `sys_role_permission` VALUES ('7', '56');
INSERT INTO `sys_role_permission` VALUES ('7', '57');
INSERT INTO `sys_role_permission` VALUES ('7', '73');
INSERT INTO `sys_role_permission` VALUES ('7', '74');
INSERT INTO `sys_role_permission` VALUES ('7', '75');
INSERT INTO `sys_role_permission` VALUES ('7', '76');
INSERT INTO `sys_role_permission` VALUES ('7', '77');
INSERT INTO `sys_role_permission` VALUES ('7', '78');
INSERT INTO `sys_role_permission` VALUES ('7', '79');
INSERT INTO `sys_role_permission` VALUES ('7', '86');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `rid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`rid`) USING BTREE,
  KEY `FK_203gdpkwgtow7nxlo2oap5jru` (`rid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '2');
INSERT INTO `sys_role_user` VALUES ('4', '3');
INSERT INTO `sys_role_user` VALUES ('5', '4');
INSERT INTO `sys_role_user` VALUES ('6', '5');
INSERT INTO `sys_role_user` VALUES ('7', '6');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `uloginname` varchar(255) NOT NULL,
  `uaddress` varchar(255) DEFAULT NULL,
  `usex` int(11) DEFAULT NULL,
  `uremark` varchar(255) DEFAULT NULL,
  `upwd` varchar(255) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `uhiredate` timestamp NULL DEFAULT NULL,
  `umgr` int(11) DEFAULT NULL,
  `uavailable` int(11) DEFAULT NULL,
  `uordernum` int(11) DEFAULT NULL,
  `utype` int(255) DEFAULT NULL COMMENT '用户类型[0超级管理员1，管理员，2普通用户]',
  `uimgpath` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `usalt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE KEY `uloginname` (`uloginname`) USING BTREE,
  KEY `FK_3rrcpvho2w1mx1sfiuuyir1h` (`did`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '超级管理员', 'system', '北京', '1', '超级管理员', '123456', '1', '2018-06-25 11:06:34', '1', null, null, '0', '../../static/img/headportrait/system.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES ('2', '李四', 'lisi', '武汉', '0', '管理员', '123456', '1', '2018-06-25 11:06:36', '1', null, null, '1', '../resources/images/defaultusertitle.jpg', 'FC1EE06AE4354D3FBF7FDD15C8FCDA71');
INSERT INTO `sys_user` VALUES ('3', '王五', 'ww', '武汉', '1', '管理员', '3c3f971eae61e097f59d52360323f1c8', '3', '2018-06-25 11:06:38', '2', null, null, '1', '../resources/images/defaultusertitle.jpg', '3D5F956E053C4E85B7D2681386E235D2');
INSERT INTO `sys_user` VALUES ('4', '赵六', 'zl', '武汉', '1', '程序员', '2e969742a7ea0c7376e9551d578e05dd', '4', '2018-06-25 11:06:40', '3', null, null, '1', '../resources/images/defaultusertitle.jpg', '6480EE1391E34B0886ACADA501E31145');
INSERT INTO `sys_user` VALUES ('5', '三笠', 'sq', '武汉', '1', '财务总监', '47b4c1ad6e4b54dd9387a09cb5a03de1', '5', '2018-06-25 11:06:43', '3', null, null, '1', '../resources/images/defaultusertitle.jpg', 'FE3476C3E3674E5690C737C269FCBF8E');
INSERT INTO `sys_user` VALUES ('8', '李四', 'liwei', '艾尔迪亚', null, '运营总监', '741852', '1', '2021-03-25 20:09:04', '1', null, null, null, null, null);
