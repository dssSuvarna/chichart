CREATE TABLE `UserSubscription`
(
  `id`      INT         NOT NULL AUTO_INCREMENT,
  `userKey` VARCHAR(45) NOT NULL,
  `dateOfCommencement` DATE NULL,
  `dateOfExpiry` DATE NULL,
  `created` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP   NULL,
  `transactionReceipt` VARCHAR(2048) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userKey_UNIQUE` (`userKey` ASC)
);