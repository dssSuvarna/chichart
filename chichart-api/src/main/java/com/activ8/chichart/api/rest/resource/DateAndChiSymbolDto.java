package com.activ8.chichart.api.rest.resource;

import java.time.LocalDate;
import com.activ8.chichart.core.domain.ChiSymbol;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of", access = AccessLevel.PUBLIC)
@EqualsAndHashCode(of = { "date", "chiSymbol" })
public class DateAndChiSymbolDto {
	
	LocalDate date;

	ChiSymbol chiSymbol;

}
