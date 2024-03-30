package com.activ8.chichart.web;

import com.ibm.icu.util.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class ChiChartWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChiChartWebApplication.class, args);
    }

    @Bean
    public ChineseCalendar chineseCalendar() {
        return (ChineseCalendar) Calendar.getInstance(new ULocale("en_AU@calendar=chinese"));
    }

}
