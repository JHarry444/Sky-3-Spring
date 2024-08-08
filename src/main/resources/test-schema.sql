DROP TABLE IF EXISTS `cat` CASCADE;
DROP TABLE IF EXISTS `person` CASCADE;


CREATE TABLE `person`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `age` INTEGER,
    `name` VARCHAR(255),
    `job` VARCHAR(255)
);

CREATE TABLE `cat`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `age` INTEGER,
    `name` VARCHAR(255) UNIQUE,
    `fur_colour` VARCHAR(255),
    `owner_id` INTEGER,
    FOREIGN KEY (`owner_id`) REFERENCES `person` (`id`) ON DELETE CASCADE
);

