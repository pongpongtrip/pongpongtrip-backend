-- FK : board.article_no, members.user_id
-- PK: comment_no 그냥 index
-- content
-- register_time

use attraction;

CREATE TABLE IF NOT EXISTS `attraction`.`comments` (
  `comment_no` INT AUTO_INCREMENT PRIMARY KEY,
  `article_no` INT,
  `user_name` VARCHAR(20),
  `content` varchar(10000), 
  `register_time` TIMESTAMP,
  FOREIGN KEY (`article_no`) REFERENCES `attraction`.`board`(`article_no`)
);