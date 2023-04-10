CREATE TABLE IF NOT EXISTS 'user' (
    `id` INT(10) UNSIGNED NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL
    `phone` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `IDX_EMAIL` (`email`)
)
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS 'movie' (
    `id` INT(10) UNSIGNED NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `bannerUrl` VARCHAR(255) NOT NULL,
    `genre` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS 'theater' (
    `id` INT(10) UNSIGNED NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS 'seat' (
    `id` INT(10) UNSIGNED NOT NULL,
    `theaterId` INT(10) UNSIGNED NOT NULL,
    `row` VARCHAR(255) NOT NULL,
    `column` INT(10) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `IDX_THEATER_ID` (`theaterId`),
    INDEX `IDX_ROW_COLUMN` (`row`, `column`)
)
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS 'showing' (
    `id` INT(10) UNSIGNED NOT NULL,
    `movieId` INT(10) UNSIGNED NOT NULL,
    `theaterId` INT(10) UNSIGNED NOT NULL,
    `date` date NOT NULL,
    `time` time NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `IDX_MOVIE_ID` (`movieId`),
    INDEX `IDX_THEATER_ID` (`theaterId`),
    INDEX `IDX_DATE` (`date`)
)
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS 'reservation' (
    `id` INT(10) UNSIGNED NOT NULL,
    `userId` INT(10) UNSIGNED NOT NULL,
    `showingId` INT(10) UNSIGNED NOT NULL,
    `seatId` INT(10) UNSIGNED NOT NULL,
    `createAt` timestamp NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `IDX_USER_ID` (`userId`)
)
ENGINE=InnoDB
;

CREATE TABLE IF NOT EXISTS 'payment' (
    `id` INT(10) UNSIGNED NOT NULL,
    `reservationId` INT(10) UNSIGNED NOT NULL,
    `status` VARCHAR(255) NOT NULL,
    `amount` decimal(19, 0) NOT NULL,
    `paymentMethod` VARCHAR(255) NOT NULL,
    `createAt` timestamp NOT NULL,
    `completedAt` timestamp NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `IDX_RESERVATION_ID` (`reservationId`)
)
ENGINE=InnoDB
;
