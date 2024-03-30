package com.activ8.chichart.api.rest.resource;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.constant.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.*;

import java.time.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class UpdateRegistrationResource implements UpdateRegistrationCommand {

    @JsonIgnore
    String userKey;

    LocalDate dateOfBirth;

    HourPeriod timeOfBirth;

    Gender gender;

    Platform platform;

    Status status;

    LocalDateTime lastPayment;

}
