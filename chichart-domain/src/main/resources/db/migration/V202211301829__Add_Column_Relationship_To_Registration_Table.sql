ALTER TABLE `Registration`
ADD COLUMN `relationship` VARCHAR(60) DEFAULT NULL AFTER `parentUserId`;