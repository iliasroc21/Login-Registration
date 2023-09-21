package com.login_system.loginregistration.registration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService ; 


    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request) ; 
    }

    @GetMapping("/confirm/{token}")
    public String confirm(@PathVariable String token){
        return registrationService.confirmToken(token);
    }
}
