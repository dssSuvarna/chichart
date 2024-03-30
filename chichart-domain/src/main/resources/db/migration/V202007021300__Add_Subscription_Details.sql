ALTER TABLE `UserSubscription`
    ADD COLUMN `productIdentifier` VARCHAR(60) NULL AFTER transactionReceipt,
    ADD COLUMN `dataSignature` VARCHAR(1024) NULL AFTER productIdentifier,
    ADD COLUMN `transactionIdentifier` VARCHAR(60) NULL AFTER dataSignature,
    ADD COLUMN `transactionDate` TIMESTAMP NULL AFTER transactionIdentifier;
