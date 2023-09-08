package com.mykettlebellproject.ragnarokproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public String getUsername() {
            return username;
        }

    public String getPassword() {
            return password;
        }

    public String setUsername(String username) {
        return username;
    }

    public String setPassword(String password) {
        return password;
    }

}
