package com.jarv.mvc.service;

import com.jarv.mvc.model.Contact;
import com.jarv.mvc.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public boolean existsByEmail(String email) {
        return contactRepository.findByEmail(email).isPresent();
    }

    public boolean existsByPhone(String phone) {
        return contactRepository.findByPhone(phone).isPresent();
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
