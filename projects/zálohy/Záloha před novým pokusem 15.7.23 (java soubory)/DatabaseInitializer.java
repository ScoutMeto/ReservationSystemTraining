package com.mykettlebellproject.ragnarokproject;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


@Component
public class DatabaseInitializer {

    private final UserRepository userRepository;

    public DatabaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {

        User firstUser = new User();
        firstUser.setUsername("firstuser");
        firstUser.setPassword("firstpassword");

        userRepository.save(firstUser);
    }
}
