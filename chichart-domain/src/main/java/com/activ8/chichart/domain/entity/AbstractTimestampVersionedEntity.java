package com.activ8.chichart.domain.entity;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.time.*;

@Getter
@MappedSuperclass
abstract class AbstractTimestampVersionedEntity {

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime created;

	@UpdateTimestamp
	private LocalDateTime updated;
}
