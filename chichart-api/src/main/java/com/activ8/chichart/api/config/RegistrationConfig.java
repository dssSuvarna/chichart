package com.activ8.chichart.api.config;

import com.activ8.chichart.api.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class RegistrationConfig {

    @Bean
    public RegistrationLogic registrationLogic(@Value("${registration.trialPeriodDays}") int trialPeriodDays) {
        return new RegistrationLogic(trialPeriodDays);
    }

}
