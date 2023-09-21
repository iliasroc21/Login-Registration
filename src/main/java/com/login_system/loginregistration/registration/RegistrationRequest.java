package com.login_system.loginregistration.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor

@ToString
@EqualsAndHashCode
public class RegistrationRequest {
    private final  String firstName ; 
    private final String lastName ; 
    private final String password ; 
    private final String email ; 

    
}
