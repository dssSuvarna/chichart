CREATE TABLE `Registration`
(
  `id`      INT         NOT NULL AUTO_INCREMENT,
  `userKey` VARCHAR(45) NOT NULL,
  `dateOfBirth` DATE NULL,
  `timeOfBirth` VARCHAR(20),
  `gender` VARCHAR(10) NULL,
  `created` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP   NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userKey_UNIQUE` (`userKey` ASC)
);
