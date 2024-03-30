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
@RequestMapping(value = "/api/v1/subscription")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;

    private final ConversionService chichartConversionService;

    @Autowired
    public UserSubscriptionController(UserSubscriptionService userSubscriptionService, ConversionService chichartConversionService) {
        this.userSubscriptionService = userSubscriptionService;
        this.chichartConversionService = chichartConversionService;
    }


    @GetMapping("{userKey}")
    public UserSubscriptionResource getUserSubscription(@PathVariable String userKey) {

        UserSubscription userSubscription = userSubscriptionService.getByUserKey(userKey);

        return chichartConversionService.convert(userSubscription, UserSubscriptionResource.class);
    }

    @PostMapping
    public ResponseEntity createUserSubscription(@RequestBody @Valid CreateUserSubscriptionResource userSubscriptionResponse) {

        UserSubscription createdEntity = userSubscriptionService.create(userSubscriptionResponse);
        return ControllerHelper.generateCreatedResponse(createdEntity.getId());
    }

    @PutMapping("{userKey}")
    public ResponseEntity updateUserSubsctiption(@PathVariable String userKey, @RequestBody @Valid UpdateUserSubscriptionResource userSubscriptionResource) {

        userSubscriptionResource.setUserKey(userKey);
        userSubscriptionService.update(userSubscriptionResource);
        return ResponseEntity.ok().build();
    }


}
