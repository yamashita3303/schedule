CREATE TABLE `allschedules` (
	`id` SERIAL NOT NULL COMMENT 'ID',
	`name` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`day` DATE,
	`title` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`detail` VARCHAR(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`participant` VARCHAR(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`updated_at` DATETIME ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` DATETIME,
	`created_at` DATETIME ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;