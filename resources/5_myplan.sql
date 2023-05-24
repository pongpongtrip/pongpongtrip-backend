use attraction;

CREATE TABLE IF NOT EXISTS `attraction`.`plan` (
  `index` INT AUTO_INCREMENT PRIMARY KEY,
  `plan_id` INT NOT NULL,
  `plan_name` VARCHAR(20) NOT NULL,
  `content_id` INT, 
  `time` TIME,
  `user_id` VARCHAR(16),
  `user_name` VARCHAR(20),
  FOREIGN KEY (`content_id`) REFERENCES `attraction`.`attraction_info`(`content_id`),
  FOREIGN KEY (`user_id`) REFERENCES `attraction`.`members`(`user_id`)
);

ALTER TABLE `attraction`.`plan` ADD `delflag` tinyint(1) NOT NULL DEFAULT 0;