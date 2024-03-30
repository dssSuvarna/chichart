package com.activ8.chichart.api.service;

import java.util.List;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.api.rest.resource.*;
import com.activ8.chichart.domain.entity.Registration;

public interface ChartService {
	ChartResource getChart(CalculateChartCommand command);

	List<UserWithMatchingEnergies> getAllPrivateUsersMatchingEnergiesByUserKey(CalculateChartCommand command);
	
	ChartResource getEnergies(CalculateChartCommand command, Registration registration);
}
