package com.activ8.chichart.api.command;

import com.activ8.chichart.constant.Platform;
import java.time.*;


public interface CreateUserSubscriptionCommand {
    String getUserKey();
    LocalDate getDateOfCommencement();
    LocalDate getDateOfExpiry();
    String getTransactionReceipt();
    String getProductIdentifier();
    String getDataSignature();
    String getTransactionIdentifier();
    LocalDateTime getTransactionDate();
}
