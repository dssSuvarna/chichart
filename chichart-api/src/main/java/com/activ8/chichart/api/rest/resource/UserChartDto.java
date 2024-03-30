package com.activ8.chichart.api.rest.resource;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of", access = AccessLevel.PUBLIC)
@EqualsAndHashCode(of = { "userKey", "chart" })
public class UserChartDto {
	
	String userKey;
	
	ChartResource chart;
	
}
