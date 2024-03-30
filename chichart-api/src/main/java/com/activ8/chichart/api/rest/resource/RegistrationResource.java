package com.activ8.chichart.api.rest.resource;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.constant.*;
import lombok.*;
import lombok.experimental.*;

import javax.validation.constraints.*;
import java.time.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResource implements CreateRegistrationCommand {

    @NonNull
    @NotBlank
    String userKey;

    LocalDate dateOfBirth;

    HourPeriod timeOfBirth;

    Gender gender;

    Platform platform;

    Status status;

    LocalDateTime lastPayment;

    LocalDateTime created;

    LocalDateTime updated;
}
