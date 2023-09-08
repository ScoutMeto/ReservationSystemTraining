package com.mykettlebellproject.ragnarokproject;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Creating table with username
    // Finding note in database
    User findByUsername(String username);
    
        //Použití anotace @SuppressWarnings("unchecked") potlačuje upozornění na konverzi typu. Tímto způsobem explicitně deklarujete, že návratový typ save metody v UserRepository je User.
        @SuppressWarnings("unchecked")
        @Override
        public User save(User user);
}
