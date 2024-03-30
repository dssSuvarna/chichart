package com.activ8.chichart.api.service;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.domain.entity.*;
import com.activ8.chichart.domain.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration getByUserKey(String userKey) {
        Registration registration = registrationRepository.findFirstByUserKey(userKey);
        if (registration != null) {
            return registration;
        } else {
            throw new EntityNotFoundException(String.format("No registration found for userKey %s", userKey));
        }

    }

    @Override
    public Registration create(CreateRegistrationCommand command) {
        Registration registration = Registration.builder()
                .userKey(command.getUserKey())
                .dateOfBirth(command.getDateOfBirth())
                .timeOfBirth(command.getTimeOfBirth())
                .gender(command.getGender())
                .platform(command.getPlatform())
                .status(command.getStatus())
                .build();
        return registrationRepository.saveAndFlush(registration);
    }

    @Override
    public Registration update(UpdateRegistrationCommand command) {
        Registration registration = getByUserKey(command.getUserKey());

        registration.setDateOfBirth(command.getDateOfBirth());
        registration.setTimeOfBirth(command.getTimeOfBirth());
        registration.setGender(command.getGender());
        registration.setPlatform(command.getPlatform());
        registration.setStatus(command.getStatus());
        registration.setLastPayment(command.getLastPayment());

        return registrationRepository.saveAndFlush(registration);
    }
}
