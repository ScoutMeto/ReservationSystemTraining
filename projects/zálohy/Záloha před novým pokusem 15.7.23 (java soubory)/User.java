package com.mykettlebellproject.ragnarokproject;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@EntityScan("com.mykettlebellproject.ragnarokproject")
@Table(name = "users")
public class User {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(name = "username")
    private String username;
  
    @Column(name = "password")
    private String password;
  
    // Gettery a settery, další atributy, konstruktory, atd.
  
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
    this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}