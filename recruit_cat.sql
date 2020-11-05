/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : recruit_cat

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2020-11-05 20:44:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat_content
-- ----------------------------
DROP TABLE IF EXISTS `chat_content`;
CREATE TABLE `chat_content` (
  `Content_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '内容编号',
  `Rid` int(11) DEFAULT NULL COMMENT '房间号',
  `Rattach_id` int(11) DEFAULT NULL COMMENT '内容发起者编号',
  `Content` varchar(255) DEFAULT NULL COMMENT '聊天内容',
  `Ccreate_time` timestamp NULL DEFAULT NULL COMMENT '发起时间',
  PRIMARY KEY (`Content_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of chat_content
-- ----------------------------

-- ----------------------------
-- Table structure for corp
-- ----------------------------
DROP TABLE IF EXISTS `corp`;
CREATE TABLE `corp` (
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(255) DEFAULT NULL,
  `Cpass` varchar(255) DEFAULT NULL,
  `Cphone` varchar(255) DEFAULT NULL,
  `Cimg` varchar(255) DEFAULT NULL,
  `Cemail` varchar(255) DEFAULT NULL,
  `Jid` text,
  `Jname` text,
  `Caddress` varchar(255) DEFAULT NULL,
  `Cdescribe` varchar(255) DEFAULT NULL,
  `Ctype` varchar(255) DEFAULT NULL COMMENT '企业所在行业类型',
  `Cscale` varchar(255) DEFAULT NULL COMMENT '企业规模',
  `Cbusiness_status` varchar(255) DEFAULT NULL COMMENT '经营状态',
  `Crecruitment_status` varchar(255) DEFAULT NULL COMMENT '招聘状态',
  PRIMARY KEY (`Cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of corp
-- ----------------------------
INSERT INTO `corp` VALUES ('1', 'DataSupermacy', '123456', '18302223082', '../../../assets/images/band/band1.jpg', '2318795835@qq.com', ',1,2,3,4,5', ',java开发,php开发,高级数据分析师,用户分析,用户分析,算法工程师', '上海', '资本的走狗', '软件计算机', '500\r\n\r\n-999人', 'C轮', '热招java15-20k');
INSERT INTO `corp` VALUES ('2', '宏深资本', '123456', '18420310128', null, '2318795835@qq.com', ',6,7,8,9,10', ',C++软件开发工程师,项目经理,Android架构师,解决方案经理,数据分析师', '北京', '这也是资本的走狗', '金融债券', '9-500人', '已上市', '热招数据挖掘20-30k');
INSERT INTO `corp` VALUES ('3', '神州出行', '123456', '18420310128', null, '2318795835@qq.com', '11,12,13,14,15', ',Java开发工程师,C语言研发工程师,ava开发工程师,初级Java开发工程师,Web开发', '北京', '神州出行是卓越的一站式移动出行平台；为5.5亿用户提供出租车、快车、专车、豪华车、公交、代驾、企业级、共享单车、共享电单车、共享汽车、外卖等多元化的出行和运输服务。在滴滴平台，超过3100万车主及司机获得灵活的工作和收入机会。', '互联网', '20-99', '不需要融资', '热招算法研发30-50k');

-- ----------------------------
-- Table structure for favorites_list
-- ----------------------------
DROP TABLE IF EXISTS `favorites_list`;
CREATE TABLE `favorites_list` (
  `Fid` int(11) NOT NULL AUTO_INCREMENT,
  `Uid` int(11) DEFAULT NULL,
  `Jid` int(255) DEFAULT NULL,
  `Jname` varchar(255) DEFAULT NULL,
  `Fupdate_time` timestamp NULL DEFAULT NULL,
  `Jsal` varchar(255) DEFAULT NULL,
  `Cid` int(11) DEFAULT NULL,
  `Cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Fid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of favorites_list
-- ----------------------------
INSERT INTO `favorites_list` VALUES ('1', '1', '1', 'java开发', '2020-10-29 10:33:30', '6000', '1', 'DataSupermacy');
INSERT INTO `favorites_list` VALUES ('2', '2', '2', 'php开发', '2020-10-29 10:35:19', '5000', '1', 'DataSupermacy');
INSERT INTO `favorites_list` VALUES ('3', '2', '3', '数据分析', '2020-10-29 10:35:19', '5000', '1', 'DataSupermacy');
INSERT INTO `favorites_list` VALUES ('4', '1', '4', '用户分析', '2020-11-04 16:12:44', '20-40K·15薪', '1', 'DataSupermacy');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `Jid` int(11) NOT NULL AUTO_INCREMENT,
  `Jname` varchar(255) DEFAULT NULL,
  `Jtype` varchar(255) DEFAULT NULL,
  `Jdescribe` varchar(255) DEFAULT NULL,
  `Jeducation` varchar(255) DEFAULT NULL COMMENT '要求的学历',
  `Jexperience` varchar(255) DEFAULT NULL COMMENT '要求的工作经验',
  `Jsal` varchar(255) DEFAULT NULL,
  `Jtreatment` varchar(255) DEFAULT NULL,
  `Jaddress` varchar(255) DEFAULT NULL,
  `Cid` int(11) DEFAULT NULL,
  `Jupdate_time` date DEFAULT NULL,
  PRIMARY KEY (`Jid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', 'java开发', '后端开发', '5674843123', '本科', '一年以内', '6000', '五险一金，007，福报+大饼', '北京', '1', '2020-10-24');
INSERT INTO `job` VALUES ('2', 'php开发', '架构师', '7894561369745', '本科', '1-3年', '5000', '五险一金，007，福报+大饼', '北京', '1', '2020-10-24');
INSERT INTO `job` VALUES ('3', '高级数据分析师', '数据分析', '针对国际外卖商家端的业务场景，建立数据体系规划、效果评估和迭代优化；', '研究生', '3-5年', '25-50K·15薪', '五险一金,补充医疗保险,定期体检,年终奖,股票期权', '北京海淀区用友产业园西区西区一号楼3层', '1', '2020-10-24');
INSERT INTO `job` VALUES ('4', '用户分析', '数据分析', '负责用户规模增长的运营策略，通过对目标的数据拆解，定位业务、用户、产品的问题和机会点', '博士', '5-10年', '20-40K·15薪', '五险一金补充,医疗保险,定期体检,年终奖,带薪年假,餐补,交通补助,节日福利', '北京市 朝阳区 东煌大厦', '1', '2020-10-24');
INSERT INTO `job` VALUES ('5', '算法工程师', '算法相关', '开发和优化AIOps算法，解决时序数据预测、异常检测、聚类、根因定位、因果分析等领域内实际问题；', '研究生', '一年以内', '20-40K·13薪', '五险一金,补充医疗保险,定期体检,年终奖,股票期权,带薪年假,节日福利,住房补贴,零食下午茶,生日会', '北京朝阳区华瑞大厦11层', '1', '2020-10-28');
INSERT INTO `job` VALUES ('6', 'C++软件开发工程师', '后端开', '2021届本、硕、博在校生，计算机、信息管理、自动化、算法、数学等相关专业,热爱编程，爱专研，自学能力强,熟练使用 C++', '本科', '1-3年', '12-18K·13薪', '五险一金补充,医疗保险,定期体检,年终奖,带薪年假,餐补,交通补助,节日福利', '北京市 海淀区 中关村软件园1期\r\n', '2', '2020-09-29');
INSERT INTO `job` VALUES ('7', '项目经理', '项目经理', '负责遵循公司标准项目管理流程，梳理项目需求，制定项目计划，把控项目进度和质量，识别应对项目风险，为项目顺利交付负责，并保证业务方满意度。', '本科', '3-5年', '20-40K', '五险一金补充,医疗保险,定期体检,加班补助,全勤奖,年终奖,股票期权,带薪年假', '北京大兴区京东大厦科创十一街18号院', '2', '2020-09-29');
INSERT INTO `job` VALUES ('8', 'Android架构师', '架构师', '负责Android端产品的架构设计和核心模块业务开发,梳理并优化现有代码，提高APP的性能和稳定性,抽像业务，实现业务组件化落地,负责移动端相关新技术的预研、应用、推进工作,参与产品的设计和改进', '本科', '5-10年', '35-50K·15薪', '五险一金补充,医疗保险,定期体检,加班补助,全勤奖,年终奖,股票期权,带', '北京市 朝阳区 望京(南B1口) 东煌大厦', '2', '2020-09-08');
INSERT INTO `job` VALUES ('9', '解决方案经理', '方案经理', '1、主导智慧城市/数字城市和安防类业务方向项目售前咨询、业务规划及方案设计工作；\r\n2、负责项目方案全生命周期管理，深入挖掘行业用户需求，负责需求引导及业务交流汇报，为用户提供定制化解决方案；\r\n3、负责安防类和智慧城市行业市场环境及业务竞争分析、生态圈分析，把握业务发展趋势、技术发展趋势，确保方案竞争力；\r\n4、结合公司方案、产品以及相关服务，联合相关行业生态，负责项目顺利推进以及成功落地。', '研究生', '一年以内', '18-25K·14薪', '五险一金,补充医疗保险,定期体检,加班补助,全勤奖,年终奖,带薪年假,员工旅游', '北京西城区太平金融中心2层', '2', '2020-10-05');
INSERT INTO `job` VALUES ('10', '数据分析师', '数据分析', '1、负责包括研产供销服业务在内的公司核心业务的数据分析工作；\r\n2、深度梳理公司核心业务的数据需求，制定数据指标，开发报表，支持业务日常运营工作；\r\n3、通过深度分析挖掘数据价值，并与数据产品、技术研发、业务运营等团队紧密配合，推动数据分析结果应用到实际业务，真正做到数据驱动业务、助力业务决策；\r\n4、通过数据分析和挖掘，发现潜在机会，探索新业务模式，前瞻性地引导业务发展；', '博士', '1-3年', '90-120K·14薪', '五险一金,加班补助,全勤奖,年终奖,带薪年假,节日福利', '北京市 海淀区 小米移动互联网产业园 小米移动互联网产业园', '2', '2020-10-06');
INSERT INTO `job` VALUES ('11', 'Java开发工程师', '后端开发', '如果你想了解JAVA开发在朗新体系中无与伦比的应用广度与深度；\r\n如果你对基础技术感兴趣，你可以参与基础软件的设计、开发和维护，如分布式文件系统、数据库、Linux操作系统和Java优化等；\r\n如果你热衷于高性能分布式技术，你可以参与高性能分布式服务端程序的系统设计，为朗新的业务提供强有力的后台支持，在海量的网络访问和数据处理中，设计并设施最强大的解决方案；', '研究生', '3-5年', '7-12K', '五险一金补充,医疗保险,定期体检,年终奖,带薪年假,餐补,交通补助,节日福利', '天津市 和平区 天津大都汇保利御景阁 天津市和平区保利天汇中心写字楼17层', '3', '2020-09-30');
INSERT INTO `job` VALUES ('12', 'C语言研发工程师', '后端开发', '、研发具有自主知识产权的数据库系统；\r\n2、负责数据库内核功能设计与开发；\r\n3、研究业界主流数据库新进展新技术；\r\n4、解决数据库产品功能缺陷；', '本科', '5-10年', '7-10K', '五险一金补充,医疗保险,定期体检,年终奖,带薪年假,餐补,交通补助,节日福利', '天津南开区榕苑路鑫茂科技园', '3', '2020-09-28');
INSERT INTO `job` VALUES ('13', 'java开发工程师', '后端开发', '1.根据需求进行web前端及平台的设计与开发；\r\n2.参与项目的产品设计、分析、开发以及维护；\r\n3.参与服务端的接口开发，架构设计；\r\n4.独立完成开发工作，进行模块测试，保证代码的质量；\r\n5.将学习和研究到新的移动互联网技术应用到产品中进行创新；\r\n6.修正并验证测试中发现的问题；\r\n7.可以保证产品的正常运行以及维护升级；', '本科', '一年以内', '7-10K', '五险一金,补充医疗保险,定期体检,加班补助,全勤奖,年终奖,带薪年假,员工旅游', '天津南开区联通tv中心1151号', '3', '2020-09-07');
INSERT INTO `job` VALUES ('14', '初级Java开发工程师', '后端开发', '参与需求分析，完成功能模块设计\r\n完成软件系统代码实现，编写代码注释和开发文档\r\n对现有功能进行持续优化\r\n工作期间会频繁到北京与用户和同事开会沟通，可视表现和个人意愿选择常驻北京工作。\r\n职位要求：\r\n软件工程或相关专业全日制本科及以上学历\r\n良好的工作态度和沟通习惯，主动解决问题的意识\r\n吃苦耐劳，对相关技术有较强的学习意愿\r\n逻辑性强，追求优雅的技术方案', '本科', '1-3年', '7-12K·13薪', '五险一金', '天津市 河东区 万达中心 1805', '3', '2020-08-04');
INSERT INTO `job` VALUES ('15', 'Web开发', '全栈开发', '1、参与Web项目的设计、开发；\r\n2、维护及优化后台Java代码、确保代码运行良好；\r\n3、能够与软、硬件团队协作，完成系统联调、联试、部署等工作。', '研究生', '3-5年', '12-20K', '五险一金,定期体检,年终奖,带薪年假,免费班车,包吃,节日福利,探亲假', '天津市 滨海新区 天津七一二通信广播股份有限公司(北大街)', '3', '2020-08-04');

-- ----------------------------
-- Table structure for post_list
-- ----------------------------
DROP TABLE IF EXISTS `post_list`;
CREATE TABLE `post_list` (
  `Pid` int(11) NOT NULL AUTO_INCREMENT,
  `Cid` int(11) DEFAULT NULL,
  `Jid` int(11) DEFAULT NULL,
  `Jname` varchar(255) DEFAULT NULL,
  `Pupdate_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of post_list
-- ----------------------------
INSERT INTO `post_list` VALUES ('1', '1', '1', 'java开发', '2020-10-24 00:00:00');
INSERT INTO `post_list` VALUES ('2', '1', '2', 'php开发', '2020-10-24 00:00:00');
INSERT INTO `post_list` VALUES ('3', '1', '3', '高级数据分析师', '2020-10-24 00:00:00');
INSERT INTO `post_list` VALUES ('4', '1', '4', '数据分析', '2020-10-24 00:00:00');
INSERT INTO `post_list` VALUES ('5', '1', '5', '算法工程师', '2020-10-28 00:00:00');

-- ----------------------------
-- Table structure for rchat_room
-- ----------------------------
DROP TABLE IF EXISTS `rchat_room`;
CREATE TABLE `rchat_room` (
  `Rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间号',
  `Rjoin_id` int(11) DEFAULT NULL COMMENT '参与者编号',
  `Rcreate_time` timestamp NULL DEFAULT NULL COMMENT '聊天创建时间',
  PRIMARY KEY (`Rid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rchat_room
-- ----------------------------

-- ----------------------------
-- Table structure for rchat_user
-- ----------------------------
DROP TABLE IF EXISTS `rchat_user`;
CREATE TABLE `rchat_user` (
  `Rid` int(11) NOT NULL COMMENT '房间号',
  `Rjoin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参与者编号',
  `Rsend_count` double DEFAULT NULL COMMENT '发送消息总数',
  `Runread_count` double DEFAULT NULL COMMENT '未读消息总数',
  `Rulastchat_time` timestamp NULL DEFAULT NULL COMMENT '用户最后会话时间',
  `Rrlastchat_time` timestamp NULL DEFAULT NULL COMMENT '房间最后会话时间',
  PRIMARY KEY (`Rjoin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rchat_user
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Uid` int(11) NOT NULL AUTO_INCREMENT,
  `Uname` varchar(255) DEFAULT NULL,
  `Ugender` varchar(255) DEFAULT NULL,
  `Uphone` varchar(255) DEFAULT '',
  `Uemail` varchar(255) DEFAULT NULL,
  `Upass` varchar(255) DEFAULT NULL,
  `Ubirth` date DEFAULT NULL,
  `Uportrait` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `Uidentify` varchar(255) DEFAULT NULL COMMENT '目前身份，(学生，或其他)',
  `Ujob_status` varchar(255) DEFAULT NULL COMMENT '当前求职状态',
  `Uexperience` varchar(255) DEFAULT NULL COMMENT '工作经验',
  `Uqualifications` varchar(255) DEFAULT NULL COMMENT '资格证书',
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王五', null, '18202223082', null, '123456', null, null, null, null, null, null);
