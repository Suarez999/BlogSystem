 CREATE DATABASE blog_system DEFAULT CHARACTER SET utf8;

USE blog_system;

CREATE TABLE `blogger` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博主id',
  `username` VARCHAR(50) NOT NULL COMMENT '博主姓名',
  `password` VARCHAR(100) NOT NULL COMMENT '博主密码',
  `profile` TEXT COMMENT '博主信息',
  `nickname` VARCHAR(50) DEFAULT NULL COMMENT '博主昵称',
  `sign` VARCHAR(100) DEFAULT NULL COMMENT '博主签名',
  `imagename` VARCHAR(100) DEFAULT NULL COMMENT '博主头像路径',
  attention INT DEFAULT NULL COMMENT '关注人个数',  
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
ALTER TABLE blogger ADD COLUMN fans INT(11) DEFAULT NULL COMMENT '粉丝数';
ALTER TABLE blogger ADD COLUMN wordHit INT(11) DEFAULT 0 COMMENT '留言次数'
ALTER TABLE blogger ADD COLUMN chatNum INT(11) DEFAULT 0 COMMENT '私信次数'


INSERT INTO blogger(username,PASSWORD,nickname,fans) VALUES('yy','123','yy',7);
INSERT INTO blogger(username,PASSWORD,nickname,fans) VALUES('zz','123','zz',3);
INSERT INTO blogger(username,PASSWORD,nickname,fans) VALUES('qq','123','qq',5);
INSERT INTO blogger(username,PASSWORD,nickname,fans) VALUES('ww','123','ww',1);
UPDATE blogger SET fans=11 WHERE id=1;

DROP TABLE blogger;
SELECT * FROM blogger;
UPDATE blogger SET fans=11 WHERE id=1;

CREATE TABLE blogtype(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客类型id',
  `typeName` VARCHAR(30) DEFAULT NULL COMMENT '博客类别',
  `orderNum` INT(11) DEFAULT NULL COMMENT '博客排序',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

SELECT * FROM blogtype;

ALTER TABLE blogtype ADD COLUMN blogger_id INT(11) DEFAULT NULL;


ALTER TABLE blogtype ADD CONSTRAINT t_blogtype_ibfk_1 FOREIGN KEY(blogger_id) REFERENCES blogtype(id) ON DELETE CASCADE ON UPDATE CASCADE;

UPDATE blogtype SET blogger_id=1 WHERE id=2;

CREATE TABLE blog(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `title` VARCHAR(200) NOT NULL COMMENT '博客题目',
  `summary` VARCHAR(400) DEFAULT NULL COMMENT '博客摘要',
  `releaseDate` DATETIME DEFAULT NULL COMMENT '发布日期',
  `clickHit` INT(11) DEFAULT NULL COMMENT '查看次数',
  `replyHit` INT(11) DEFAULT NULL COMMENT '回复次数',
  goodHit INT(11) DEFAULT NULL COMMENT '点赞次数', 
  payHit INT(11) DEFAULT NULL COMMENT '打赏次数',  
  `content` TEXT COMMENT '博客内容',
  `keyWord` VARCHAR(200) DEFAULT NULL COMMENT '关键字',
  `type_id` INT(11) DEFAULT NULL COMMENT '外键关联博客类别',
   PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

ALTER TABLE blog ADD COLUMN blogger_id INT(11) DEFAULT NULL;

ALTER TABLE blog DROP COLUMN blogger_id;
ALTER TABLE blog DROP COLUMN wordHit;


CREATE TABLE t_comment(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '评论表id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '评论者的ip',
  `content` VARCHAR(1000) DEFAULT NULL COMMENT '评论内容',
  `commentDate` DATETIME DEFAULT NULL COMMENT '评论日期',
  `state` INT(11) DEFAULT NULL COMMENT '审核状态',
  `blog_id` INT(11) DEFAULT NULL COMMENT '外键关联具体博客',
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

ALTER t_comment ADD COLUMN blogger_id INT(11) DEFAULT NULL;

SELECT * FROM t_comment;

CREATE TABLE pay(
 id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '打赏表id',
 `userIp` VARCHAR(50) DEFAULT NULL COMMENT '打赏者的ip',
 payMoney VARCHAR(10) DEFAULT NULL COMMENT '打赏金额',
 payDate DATETIME DEFAULT NULL COMMENT '打赏日期',
 blog_id INT(11) DEFAULT NULL COMMENT '外键关联具体博客'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
ALTER TABLE pay ADD CONSTRAINT t_pay_ibfk_1 FOREIGN KEY(blog_id) REFERENCES blog(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE pay DROP FOREIGN KEY t_pay_ibfk_1;
SELECT * FROM pay;

CREATE TABLE word(
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '留言表id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '留言者的ip',
  `content` VARCHAR(1000) DEFAULT NULL COMMENT '留言内容',
  `wordDate` DATETIME DEFAULT NULL COMMENT '留言日期',
  `state` INT(11) DEFAULT NULL COMMENT '审核状态',
  `blogger_id` INT(11) DEFAULT NULL COMMENT '外键关联具体博客'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
ALTER TABLE word ADD CONSTRAINT t_word_ibfk_1 FOREIGN KEY(blogger_id) REFERENCES blogger(id) ON DELETE CASCADE ON UPDATE CASCADE;

SELECT * FROM word;

CREATE TABLE good(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '点赞表id',
`userIp` VARCHAR(50) DEFAULT NULL COMMENT '点赞者的ip',
`goodDate` DATETIME DEFAULT NULL COMMENT '点赞日期',
`blog_id` INT(11) DEFAULT NULL COMMENT '外键关联具体博客'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
ALTER TABLE good ADD CONSTRAINT t_good_ibfk_1 FOREIGN KEY(blog_id) REFERENCES blog(id);

CREATE TABLE attention(
  `id` INT(11) PRIMARY KEY  AUTO_INCREMENT COMMENT 'id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '关注者的ip',
  `attentionDate` DATETIME DEFAULT NULL COMMENT '关注日期',
   blogger_id INT(11) DEFAULT NULL
);
ALTER TABLE attention ADD CONSTRAINT t_attention_ibfk_1 FOREIGN KEY(blogger_id) REFERENCES blogger(id);

CREATE TABLE fans(
  `id` INT(11) PRIMARY KEY  AUTO_INCREMENT COMMENT 'id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '关注者的ip',
  `attentionDate` DATETIME DEFAULT NULL COMMENT '关注日期',
   blogger_id INT(11) DEFAULT NULL
)
ALTER TABLE fans ADD CONSTRAINT t_fans_ibfk_1 FOREIGN KEY(blogger_id) REFERENCES blogger(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE fans DROP FOREIGN KEY t_fans_ibfk_1;

SELECT * FROM fans;

DELETE FROM fans WHERE blogger_id=1;

CREATE TABLE admin(
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '管理员id',
  `username` VARCHAR(50) NOT NULL COMMENT '管理员姓名',
  `password` VARCHAR(100) NOT NULL COMMENT '管理员密码'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

SELECT * FROM admin;
INSERT INTO admin(username,PASSWORD) VALUES('qq','123');
DELETE FROM admin WHERE PASSWORD='2';



INSERT INTO blogtype(typeName,orderNum) VALUES('文学',1);
INSERT INTO blogtype(typeName,orderNum) VALUES('科技',2);

SELECT * FROM blog;
DELETE FROM blog WHERE id=18;
DROP TABLE  blog;

ALTER TABLE blog DROP FOREIGN KEY t_blog_ibfk_2;

ALTER TABLE blog ADD CONSTRAINT t_blog_ibfk_1 FOREIGN KEY(type_id) REFERENCES blogtype(id) ON DELETE CASCADE ON UPDATE CASCADE;  

ALTER TABLE t_comment DROP FOREIGN KEY t_comment_ibfk_1;
ALTER TABLE t_comment ADD CONSTRAINT t_comment_ibfk_1 FOREIGN KEY(blog_id) REFERENCES blog(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE blog ADD CONSTRAINT t_blog_ibfk_2 FOREIGN KEY(blogger_id) REFERENCES blogger(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE t_commment ADD CONSTRAINT t_comment_ibfk_2 FOREIGN KEY(blogger_id) REFERENCES blogger(id) ON DELETE CASCADE ON UPDATE CASCADE;


SELECT * FROM t_comment;
UPDATE blog SET blogger_id=1 WHERE id=7;

DELETE FROM blog WHERE id=8;

CREATE TABLE `link` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '友情链接表id',
  `linkname` VARCHAR(100) DEFAULT NULL COMMENT '友情链接名',
  `linkurl` VARCHAR(200) DEFAULT NULL COMMENT '友情链接url',
  `orderNum` INT(11) DEFAULT NULL COMMENT '链接排序',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
 
SELECT * FROM link;

CREATE TABLE chat(
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '私信表id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '私信者的ip',
  `content` VARCHAR(1000) DEFAULT NULL COMMENT '私信内容',
  `chatDate` DATETIME DEFAULT NULL COMMENT '私信日期',
  `blogger_id` INT(11) DEFAULT NULL COMMENT '外键关联具体博客'
)
ALTER TABLE chat ADD CONSTRAINT t_chat_ibfk_1 FOREIGN KEY(blogger_id) REFERENCES blogger(id) ON DELETE CASCADE ON UPDATE CASCADE;

SELECT * FROM chat;

CREATE TABLE sensitive_word(
   id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',	
   word VARCHAR(50) DEFAULT NULL COMMENT '敏感词汇'
);

INSERT INTO sensitive_word(word) VALUES('骂人');
INSERT INTO sensitive_word(word) VALUES('sb');
INSERT INTO sensitive_word(word) VALUES('二五');
INSERT INTO sensitive_word(word) VALUES('三八');

SELECT * FROM sensitive_word;

