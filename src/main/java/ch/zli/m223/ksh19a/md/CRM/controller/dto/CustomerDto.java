package ch.zli.m223.ksh19a.md.CRM.controller.dto;

import ch.zli.m223.ksh19a.md.CRM.model.Customer;

public class CustomerDto {
	public final Long id;
	public final String firstname;
	public final String lastname;
	public final String birthdate;
	public final String gender;
	
	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.firstname = customer.getFirstname();
		this.lastname = customer.getLastname();
		this.birthdate = customer.getBirthdate();
		this.gender = customer.getGender().getGenderName();
	}
	
	
}
