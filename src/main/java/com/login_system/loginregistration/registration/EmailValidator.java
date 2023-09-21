package com.login_system.loginregistration.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class EmailValidator implements Predicate<String>{

    @Override
    public boolean test(String arg0) {
        return true ; 
        

    }

}

