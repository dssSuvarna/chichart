package com.activ8.chichart.domain.entity;

import com.activ8.chichart.constant.Platform;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PACKAGE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(callSuper = true)
@Builder
public class UserSubscription extends AbstractTimestampVersionedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonFinal
    @Setter
    String userKey;

    @NonFinal
    @Setter
    LocalDate dateOfCommencement;

    @NonFinal
    @Setter
    LocalDate dateOfExpiry;

    @NonFinal
    @Setter
    String transactionReceipt;

    @NonFinal
    @Setter
    String productIdentifier;

    @NonFinal
    @Setter
    String dataSignature;

    @NonFinal
    @Setter
    String transactionIdentifier;

    @NonFinal
    @Setter
    LocalDateTime transactionDate;

}
