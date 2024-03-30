package com.activ8.chichart.api.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.converter.*;
import org.springframework.core.convert.support.*;

import java.util.*;

@Configuration
public class AddingConvertersConfig {

    @Autowired
    public void setConverters(@Qualifier("chichartConversionService") GenericConversionService chichartConversionService,
                              Set<Converter<?,?>> converters){
        converters.forEach(chichartConversionService::addConverter);
    }
}
