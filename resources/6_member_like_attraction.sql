use attraction;

CREATE TABLE IF NOT EXISTS `attraction`.`member_like_place` (
  `user_id` varchar(16) NOT NULL,
  `content_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `content_id`),
  CONSTRAINT `member_like_place_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `attraction`.`members` (`user_id`)
);

select * from member_like_place;