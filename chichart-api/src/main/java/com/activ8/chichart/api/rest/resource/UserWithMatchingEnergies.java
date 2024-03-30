package com.activ8.chichart.api.rest.resource;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of", access = AccessLevel.PUBLIC)
@EqualsAndHashCode(of = { "userKey", "dateAndChiSymbols" })
public class UserWithMatchingEnergies {
	
	String userKey;
	
	List<DateAndChiSymbolDto> dateAndChiSymbols;
	
}
