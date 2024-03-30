package com.activ8.chichart.api.rest.resource;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.constant.Platform;
import lombok.*;
import lombok.experimental.*;

import java.time.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserSubscriptionResource implements CreateUserSubscriptionCommand {

    @NonNull
    @Setter
    String userKey;

    LocalDate dateOfCommencement;

    LocalDate dateOfExpiry;

    String transactionReceipt;

    String productIdentifier;

    String dataSignature;

    String transactionIdentifier;

    LocalDateTime transactionDate;

}
