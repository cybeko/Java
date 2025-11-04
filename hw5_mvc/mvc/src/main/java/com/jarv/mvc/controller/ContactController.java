package com.jarv.mvc.controller;
import com.jarv.mvc.Logger;

import com.jarv.mvc.model.Contact;
import com.jarv.mvc.service.ContactService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // цей клас є контролером Spring MVC, який обробляє http запити
@RequestMapping("/contacts") // встановлення базового url для всіх методів у цьому контролері
public class ContactController {

	@Autowired // автоматичне впровадження екземпляра ContactService в контролер
	private ContactService contactService;

	@GetMapping // обробка HTTP GET-запиту за url /contacts
	public String listContacts(Model model) {
		model.addAttribute("contacts", contactService.getAllContacts()); // додавання списку контактів у модель
		return "contact-list"; // повернення імені представлення (шаблону), яке буде відображено
	}

	@GetMapping("/add") // обробка GET-запиту за url /contacts/add
	public String addContactForm(Model model) {
		model.addAttribute("contact", new Contact()); // створення нового об'єкта Contact і додавання його в модель
		return "contact-form";
	}

	@PostMapping("/add")
    public String addContact(@Valid @ModelAttribute Contact contact,
                             BindingResult result,
                             Model model) {
        try {
            if (contactService.existsByEmail(contact.getEmail())) {
                result.rejectValue("email", "error.contact", "Контакт з таким email вже існує");
            }

            if (contactService.existsByPhone(contact.getPhone())) {
                result.rejectValue("phone", "error.contact", "Контакт з таким телефоном вже існує");
            }

            if (result.hasErrors()) {
                Logger.log("Failed to add contact: validation errors");
                return "contact-form";
            }

            contactService.saveContact(contact);
            Logger.log("Added new contact: " + contact.getName() + " (" + contact.getEmail() + ")");
        } catch (Exception e) {
            Logger.log("Error adding contact: " + e.getMessage());
        }
        return "redirect:/contacts";
    }

	@GetMapping("/edit/{id}") 
	public String editContactForm(@PathVariable("id") Long id, Model model) {
		Optional<Contact> contact = contactService.getContactById(id); 
		if (contact.isPresent()) { 
			model.addAttribute("contact", contact.get()); 
			return "contact-form";
		} else {
			return "redirect:/contacts"; 
		}
	}

	@PostMapping("/edit/{id}")
    public String editContact(@PathVariable("id") Long id,
                              @Valid @ModelAttribute Contact contact,
                              BindingResult result,
                              Model model) {
        try {
            Optional<Contact> existing = contactService.getContactById(id);

            if (existing.isPresent()) {
                Contact old = existing.get();

                if (!old.getEmail().equals(contact.getEmail()) &&
                    contactService.existsByEmail(contact.getEmail())) {
                    result.rejectValue("email", "error.contact", "Contact with this email already exists");
                }

                if (!old.getPhone().equals(contact.getPhone()) &&
                    contactService.existsByPhone(contact.getPhone())) {
                    result.rejectValue("phone", "error.contact", "Contact with this phone number already exists");
                }
            }

            if (result.hasErrors()) {
                Logger.log("Failed to edit contact id " + id + ": validation errors");
                return "contact-form";
            }

            contact.setId(id);
            contactService.saveContact(contact);
            Logger.log("Edited contact id: " + id + " (" + contact.getName() + ")");
        } catch (Exception e) {
            Logger.log("Error editing contact id " + id + ": " + e.getMessage());
        }

        return "redirect:/contacts";
    }

	@GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        try {
            contactService.deleteContact(id);
            Logger.log("Deleted contact id: " + id);
        } catch (Exception e) {
            Logger.log("Error deleting contact id " + id + ": " + e.getMessage());
        }
        return "redirect:/contacts";
    }
}