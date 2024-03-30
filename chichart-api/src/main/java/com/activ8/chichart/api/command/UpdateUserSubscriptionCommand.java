package com.activ8.chichart.api.command;



import com.activ8.chichart.constant.Platform;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface UpdateUserSubscriptionCommand {

    String getUserKey();

    LocalDate getDateOfCommencement();
    void setDateOfCommencement(LocalDate dateOfCommencement);

    LocalDate getDateOfExpiry();
    void setDateOfExpiry(LocalDate dateOfExpiry);

    String getTransactionReceipt();
    void setTransactionReceipt(String transactionReceipt);

    String getProductIdentifier();
    void setProductIdentifier(String productIdentifier);

    String getDataSignature();
    void setDataSignature(String dataSignature);

    String getTransactionIdentifier();
    void setTransactionIdentifier(String transactionIdentifier);

    LocalDateTime getTransactionDate();
    void setTransactionDate(LocalDateTime transactionDate);

}
