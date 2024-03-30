package com.activ8.chichart.api.rest.converter;

import com.activ8.chichart.api.rest.resource.*;
import com.activ8.chichart.domain.entity.*;
import org.springframework.core.convert.converter.*;
import org.springframework.stereotype.*;

@Component
public class RegistrationToResourceConverter implements Converter<Registration, RegistrationResource> {

    @Override
    public RegistrationResource convert(Registration source) {
        return RegistrationResource.builder()
                .userKey(source.getUserKey())
                .created(source.getCreated())
                .updated(source.getUpdated())
                .gender(source.getGender())
                .dateOfBirth(source.getDateOfBirth())
                .timeOfBirth(source.getTimeOfBirth())
                .platform(source.getPlatform())
                .status(source.getStatus())
                .lastPayment(source.getLastPayment())
                .build();
    }
}
