package com.activ8.chichart.domain.entity;

import com.activ8.chichart.constant.*;
import lombok.*;
import lombok.experimental.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@NoArgsConstructor(access = AccessLevel.PACKAGE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(callSuper = true)
@Builder
public class Registration extends AbstractTimestampVersionedEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@NonFinal
	@Setter
	String userKey;

	@NonFinal
	@Setter
	LocalDate dateOfBirth;

	@NonFinal
	@Setter
	@Enumerated(EnumType.STRING)
	HourPeriod timeOfBirth;

	@NonFinal
	@Setter
	@Enumerated(EnumType.STRING)
	Gender gender;

	@NonFinal
	@Setter
	@Enumerated(EnumType.STRING)
	Platform platform;

	@NonFinal
	@Setter
	@Enumerated(EnumType.STRING)
	Status status;
	
	@NonFinal
	@Setter
	String relationship;

	@NonFinal
	@Setter
	LocalDateTime lastPayment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentUserId", referencedColumnName = "id", updatable = false)
	private Registration parentUser;
}
