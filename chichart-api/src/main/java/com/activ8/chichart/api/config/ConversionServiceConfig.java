package com.activ8.chichart.api.config;

import org.springframework.context.annotation.*;
import org.springframework.core.convert.support.*;

@Configuration
public class ConversionServiceConfig {

    @Bean(name="chichartConversionService")
    public GenericConversionService createConversionService() {
        return new GenericConversionService();
    }

}
