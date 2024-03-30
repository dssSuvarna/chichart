package com.activ8.chichart.api.rest.resource;

import com.activ8.chichart.api.command.*;
import lombok.*;
import lombok.experimental.*;

import javax.validation.constraints.*;
import java.time.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSubscriptionResource implements CreateUserSubscriptionCommand {

    @NonNull
    @NotBlank
    String userKey;

    LocalDate dateOfCommencement;

    LocalDate dateOfExpiry;

    String transactionReceipt;

    String productIdentifier;

    String dataSignature;

    String transactionIdentifier;

    LocalDateTime transactionDate;

    LocalDateTime created;

    LocalDateTime updated;
}
