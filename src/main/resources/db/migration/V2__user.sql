CREATE TABLE `users` (
	`id` SERIAL NOT NULL COMMENT 'ID',
	`username` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`password` TEXT NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;   