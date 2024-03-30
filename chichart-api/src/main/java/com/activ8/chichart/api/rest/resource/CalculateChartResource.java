package com.activ8.chichart.api.rest.resource;

import com.activ8.chichart.api.command.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.*;

import javax.validation.constraints.*;
import java.time.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateChartResource implements CalculateChartCommand {

    @JsonIgnore
    @Setter
    String userKey;

    @NotNull
    LocalDate chartDate;

    String productKey;
    
    @JsonIgnore
    @Setter
    Long privateUserId;
}
