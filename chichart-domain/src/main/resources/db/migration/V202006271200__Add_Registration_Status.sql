ALTER TABLE `Registration`
    ADD COLUMN `platform` VARCHAR(20) NULL AFTER gender,
    ADD COLUMN `status` VARCHAR(20) NULL AFTER platform,
    ADD COLUMN `lastPayment` TIMESTAMP NULL AFTER status;