package com.activ8.chichart.api.rest.resource;

import com.activ8.chichart.api.command.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.*;

import java.time.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class UpdateUserSubscriptionResource implements UpdateUserSubscriptionCommand {

    @JsonIgnore
    String userKey;

    LocalDate dateOfCommencement;

    LocalDate dateOfExpiry;

    String transactionReceipt;

    String ProductIdentifier;

    String DataSignature;

    String TransactionIdentifier;

    LocalDateTime TransactionDate;

}
