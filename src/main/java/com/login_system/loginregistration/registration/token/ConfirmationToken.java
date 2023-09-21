package com.login_system.loginregistration.registration.token;

import java.time.LocalDateTime;

import com.login_system.loginregistration.appUser.AppUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 
    @Column(nullable=false)
    private String token ; 
    @Column(nullable = false)

    private LocalDateTime createdAt;
    @Column(nullable = false)

    private LocalDateTime expiredAt ; 
    private LocalDateTime confirmedAt ;
    @ManyToOne
    @JoinColumn(nullable=false , name="app_user_id" )
    private AppUser appUser ;

    public ConfirmationToken(
        String token, 
        LocalDateTime createdAt, 
        LocalDateTime expiredAt,
        AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.appUser=appUser;
    } 

}
