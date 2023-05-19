use attraction;

ALTER TABLE `attraction`.`members`ADD `email` VARCHAR(20) NULL DEFAULT NULL;
ALTER TABLE `attraction`.`members`ADD `token` VARCHAR(1000) NULL DEFAULT NULL;
ALTER TABLE `attraction`.`members`ADD `delflag` tinyint(1) NOT NULL DEFAULT 0;