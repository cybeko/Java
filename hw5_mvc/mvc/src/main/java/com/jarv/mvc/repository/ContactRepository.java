package com.jarv.mvc.repository;

import com.jarv.mvc.model.Contact;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 


public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findByEmail(String email);
    Optional<Contact> findByPhone(String phone);
}