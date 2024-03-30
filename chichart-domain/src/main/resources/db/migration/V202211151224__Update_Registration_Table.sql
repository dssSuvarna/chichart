SET foreign_key_checks = 0;

ALTER TABLE `Registration`
ADD COLUMN `parentUserId` INT DEFAULT NULL AFTER `lastPayment`,
ADD CONSTRAINT `registration_parent_user_fx`
  FOREIGN KEY (`parentUserId`)
  REFERENCES  `Registration` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

SET foreign_key_checks = 1;