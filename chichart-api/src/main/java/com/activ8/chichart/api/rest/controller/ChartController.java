package com.activ8.chichart.api.rest.controller;

import com.activ8.chichart.api.rest.resource.*;
import com.activ8.chichart.api.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.*;

@RestController
@RequestMapping(value = "/api/v1/{userKey}/chart")
public class ChartController {

	private final ChartService chartService;

	public ChartController(ChartService chartService) {
		this.chartService = chartService;
	}

	@PostMapping
	public ChartResource calculateChart(@PathVariable String userKey,
			@RequestBody @Valid CalculateChartResource command) {
		command.setUserKey(userKey);
		return chartService.getChart(command);
	}
	
	@PostMapping("/{privateUserId}")
	public ChartResource calculateChartForPrivateUser(@PathVariable String userKey, @PathVariable Long privateUserId,
			@RequestBody @Valid CalculateChartResource command) {
		command.setUserKey(userKey);
		command.setPrivateUserId(privateUserId);
		return chartService.getChart(command);
	}

	@PostMapping("/matchingEnergies")
	public List<UserWithMatchingEnergies> getAllPrivateUsersMatchingEnergiesByUserKey(@PathVariable String userKey,
			@RequestBody @Valid CalculateChartResource command) {
		command.setUserKey(userKey);
		return chartService.getAllPrivateUsersMatchingEnergiesByUserKey(command);
	}
}
