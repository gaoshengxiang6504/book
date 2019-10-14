/*
Navicat MySQL Data Transfer

Source Server         : jdbc
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-10-14 19:01:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(50) NOT NULL,
  `author` varchar(20) DEFAULT NULL,
  `press` varchar(40) DEFAULT NULL,
  `isbn` varchar(17) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Java Web 程序设计任务教程', '黑马程序员', '人民邮电出版社', '978-7-115-43936-9', '程序设计', '56');
INSERT INTO `book` VALUES ('2', '数据系统基础', 'Ramez', '清华大学出版社', '978-0-13-608620-8', '数据库', '121');
INSERT INTO `book` VALUES ('3', '数学图像处理', '冈萨雷斯', '电子工业出版社', '978-7-121-31383-7', '图像处理', '89');
INSERT INTO `book` VALUES ('4', '挪威的森林', '村上春树', '人民邮电出版社', '978-0-121-31383-7', '程序设计', '66');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zs', '123456', 'zs@sina.com', '1980-12-04');
INSERT INTO `users` VALUES ('2', 'lisi', '123456', 'lisi@sina.com', '1980-12-04');
INSERT INTO `users` VALUES ('3', 'wangwu', '123456', 'wangwu@sina.com', '1980-12-04');
