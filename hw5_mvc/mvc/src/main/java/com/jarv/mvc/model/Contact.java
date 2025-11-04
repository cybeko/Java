package com.jarv.mvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;


@Entity
public class Contact {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "ПІБ не може бути порожнім")
	    @Size(min = 2, max = 50, message = "ПІБ має бути від 2 до 50 символів")
	    private String name;

	    @NotBlank(message = "Електронна пошта не може бути порожньою")
	    @Email(message = "Невірний формат електронної пошти")
	    private String email;

	    @NotBlank(message = "Телефон не може бути порожнім")
	    @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Телефон повинен містити від 10 до 15 цифр, можна з '+'")
	    private String phone;

	public Contact() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Contact contact = (Contact) o;
		return Objects.equals(id, contact.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}