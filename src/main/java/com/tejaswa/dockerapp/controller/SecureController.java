package com.tejaswa.dockerapp.controller;

import com.tejaswa.dockerapp.service.SecureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/secure")
public class SecureController {

    private SecureService secureService;

    @Autowired
    public SecureController(SecureService secureService) {
        this.secureService = secureService;
    }
}
