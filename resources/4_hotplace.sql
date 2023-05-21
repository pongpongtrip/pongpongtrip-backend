use attraction;

CREATE TABLE IF NOT EXISTS `attraction`.`hotplace` (
  `content_id` INT NOT NULL,
  `hit` INT NULL DEFAULT 0,
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_hotplace_content_id_pk` (`content_id` ASC) VISIBLE,
  CONSTRAINT `attraction_to_hotplace_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `attraction`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO hotplace (content_id, hit)
SELECT t.content_id, 1
FROM attraction_info AS t;

UPDATE hotplace
SET hit = hit + 1
WHERE content_id IN (
    SELECT content_id
    FROM (
        SELECT content_id
        FROM hotplace
        ORDER BY RAND()
        LIMIT 9
    ) AS random_hotplaces
);

CREATE TABLE attraction_info_description AS
SELECT A.*, B.homepage, B.overview, B.telname
FROM attraction_info AS A
JOIN attraction_description AS B ON A.content_id = B.content_id
GROUP BY A.content_id;

