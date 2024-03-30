package com.activ8.chichart.api.rest.controller;

import com.activ8.chichart.api.rest.resource.*;
import com.activ8.chichart.api.service.*;
import com.activ8.chichart.domain.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.convert.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    private final ConversionService chichartConversionService;

    @Autowired
    public RegistrationController(RegistrationService registrationService, ConversionService chichartConversionService) {
        this.registrationService = registrationService;
        this.chichartConversionService = chichartConversionService;
    }


    @GetMapping("{userKey}")
    public RegistrationResource getRegistration(@PathVariable String userKey) {

        Registration registration = registrationService.getByUserKey(userKey);

        return chichartConversionService.convert(registration, RegistrationResource.class);
    }

    @PostMapping
    public ResponseEntity createRegistration(@RequestBody @Valid CreateRegistrationResource registrationResource) {

        Registration createdEntity = registrationService.create(registrationResource);
        return ControllerHelper.generateCreatedResponse(createdEntity.getId());
    }

    @PutMapping("{userKey}")
    public ResponseEntity updateRegistration(@PathVariable String userKey, @RequestBody @Valid UpdateRegistrationResource registrationResource) {

        registrationResource.setUserKey(userKey);
        registrationService.update(registrationResource);
        return ResponseEntity.ok().build();
    }

}
