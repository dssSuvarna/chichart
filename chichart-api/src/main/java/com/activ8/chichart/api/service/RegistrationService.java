package com.activ8.chichart.api.service;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.domain.entity.*;

public interface RegistrationService {
    Registration getByUserKey(String userKey);
    Registration create(CreateRegistrationCommand command);
    Registration update(UpdateRegistrationCommand command);
}
