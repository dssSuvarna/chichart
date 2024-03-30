package com.activ8.chichart;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.web.servlet.support.*;

@SpringBootApplication
public class ChiChartApiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ChiChartApiApplication.class);
	}

    public static void main(String[] args) {
		SpringApplication.run(ChiChartApiApplication.class, args);
	}
}
