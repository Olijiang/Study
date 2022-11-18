/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 16/11/2022 15:56:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tag` json NULL,
  `content` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `digest` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '基本类型原子类', '2020', 'Java', '{\"tags\": [\"Java\", \"redis\", \"rabbitmq\", \"kafka\"]}', 'articles\\2022111512420435_2020.txt', '## 基本类型原子类\n\n### 基本类型原子类介绍\n\n使用原子的方式更新基本类型\n\n- AtomicInteger：整型原子类\n- AtomicLong：长整型原子类\n- AtomicBoolean ：布尔型原子类\n\n上面三个类提供的方法几乎相同，所以我们这里以 AtomicInteger 为例子来介绍。\n\n**AtomicInteger 类常用方法**\n\n...', 'http:\\\\localhost:8888\\blogData\\imgs\\2022111512420420_2020.jpeg', '2022-11-10 12:49:28', '2022-11-16 15:02:24');
INSERT INTO `article` VALUES (2, '基本类型原子类', '2020', 'VueFrame', '{\"tags\": [\"Java\", \"redis\", \"rabbitmq\", \"kafka\"]}', 'articles\\2022111013225374_2020.txt', '## 基本类型原子类\n\n### 基本类型原子类介绍\n\n使用原子的方式更新基本类型\n\n- AtomicInteger：整型...', 'http:\\\\localhost:8888\\blogData\\imgs\\2022111013225370_2020.png', '2022-11-10 13:22:54', '2022-11-16 15:02:29');
INSERT INTO `article` VALUES (3, 'CompletableFuture入门', '2020', 'Java', '{\"tags\": [\"Java并发\"]}', 'articles\\2022111014210947_2020.txt', '自己在项目中使用 `CompletableFuture` 比较多，看到很多开源框架中也大量使用到了 `CompletableFuture` 。\n\n因此，专门写一篇文章来介绍这个 Java 8 才被引入的一个非常有用的用于异步编程的类。\n\n## 简单介绍\n\n`CompletableFuture` 同时实现了 `Future` 和 `CompletionStag...', 'http:\\\\localhost:8888\\blogData\\imgs\\2022111014210944_2020.jpeg', '2022-11-10 14:21:09', '2022-11-16 15:02:31');
INSERT INTO `article` VALUES (4, 'Java 常见并发容器总结', '2020', 'Java', '{}', 'articles\\2022111220530779_2020.txt', '---\ntitle:  Java 常见并发容器总结\ncategory: Java\ntag:\n  - Java并发\n---\n\nJDK 提供的这些容器大部分在 `java.util.concurrent` 包中。\n\n- **`ConcurrentHashMap`** : 线程安全的 `HashMap`\n- **`CopyOnWriteArrayList`** :...', 'http:\\\\localhost:8888\\blogData\\imgs\\2022111220530776_2020.jpeg', '2022-11-12 20:53:08', '2022-11-16 15:02:34');
INSERT INTO `article` VALUES (5, 'Java 并发常见面试题总结（中）', '2020', 'Java', '{\"tags\": [\"Java并发\", \"Java\"]}', 'articles\\2022111220560560_2020.txt', '---\ntitle:  Java 并发常见面试题总结（中）\ncategory: Java\ntag:\n  - Java并发\nhead:\n  - - meta\n    - name: keywords\n      content: 多线程,死锁,synchronized,ReentrantLock,volatile,ThreadLocal,线程池,CAS,AQS...', 'http:\\\\localhost:8888\\blogData\\imgs\\2022111220560549_2020.png', '2022-11-12 20:56:05', '2022-11-16 15:02:37');
INSERT INTO `article` VALUES (6, 'volatile 关键字', '2020', 'Java', '{\"tags\": [\"Java并发\", \"多线程\"]}', 'articles\\2022111315350757_2020.txt', '## volatile 关键字\n\n### 如何保证变量的可见性？\n\n在 Java 中，`volatile` 关键字可以保证变量的可见性，如果我们将变量声明为 **`volatile`** ，这就指示 JVM，这个变量是共享且不稳定的，每次使用它都到主存中进行读取。\n\n![](https://guide-blog-images.oss-cn-shenzhen....', 'http:\\\\localhost:8888\\blogData\\imgs\\2022111315350753_2020.jpeg', '2022-11-13 15:35:07', '2022-11-16 15:02:41');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `author_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `categories` json NULL,
  PRIMARY KEY (`author_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('2020', '{\"categories\": [\"Java\"]}');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `author_id` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tags` json NULL,
  PRIMARY KEY (`author_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('2020', '{\"tags\": [\"Java\", \"python\", \"kafka\", \"多线程\", \"rabbitmq\", \"Java并发\", \"redis\"]}');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `blog_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `blog_info` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `article_num` int(0) NULL DEFAULT NULL,
  `category_num` int(0) NULL DEFAULT NULL,
  `visit_num` int(0) NULL DEFAULT NULL,
  `img` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cover_img` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2020', '123', '神华锦里', '这是我的blog', 99, 99, 99, 'http://localhost:8888/blogData/imgs/2022111512420420_2020.jpeg', 'http://localhost:8888/blogData/imgs/2022111512420420_2020.jpeg');

SET FOREIGN_KEY_CHECKS = 1;
