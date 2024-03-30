package com.activ8.chichart.api.rest.controller;

import org.springframework.http.*;
import org.springframework.web.servlet.support.*;

import java.net.*;

interface ControllerHelper {

    static ResponseEntity generateCreatedResponse(Long id){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();

        return ResponseEntity.created(location).build();
    }

}
