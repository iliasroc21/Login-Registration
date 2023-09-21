package com.login_system.loginregistration.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.login_system.loginregistration.appUser.AppUserService;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final AppUserService appUserService; 
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        
        http
        
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            .requestMatchers("/api/v*/registration/**").permitAll()
            .anyRequest().authenticated()
            
        ).formLogin(Customizer.withDefaults()); // You can customize form login if needed
        
    http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/v*/registration/**")); // Ignore CSRF for registration endpoints
    
        
        return http.build(); 




    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationConfigurer(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider; 

    }

    
    
}
