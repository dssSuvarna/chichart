package com.activ8.chichart.web;

import org.springframework.boot.builder.*;
import org.springframework.boot.web.servlet.support.*;

/**
 * Runtime servlet configuration as a replacement for the traditional servlet.xml.
 */
public class ChiChartWebApplicationWebXml extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ChiChartWebApplication.class);
    }
}
