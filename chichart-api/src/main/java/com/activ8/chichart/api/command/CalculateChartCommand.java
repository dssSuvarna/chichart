package com.activ8.chichart.api.command;

import java.time.*;

public interface CalculateChartCommand {
	String getUserKey();

	void setUserKey(String userKey);

	LocalDate getChartDate();

	String getProductKey();

	Long getPrivateUserId();
	
	void setPrivateUserId(Long privateUserId);
}
