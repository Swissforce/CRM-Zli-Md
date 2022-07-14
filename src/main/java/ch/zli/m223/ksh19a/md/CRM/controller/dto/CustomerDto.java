package ch.zli.m223.ksh19a.md.CRM.controller.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19a.md.CRM.model.Customer;

public class CustomerDto {
	public final Long id;
	public final String firstname;
	public final String lastname;
	public final String birthdate;
	public final String gender;
	public List<NoteDto> noteList;
	
	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.firstname = customer.getFirstname();
		this.lastname = customer.getLastname();
		this.birthdate = customer.getBirthdate();
		this.gender = customer.getGender().getGenderName();
		
		noteList = new ArrayList<>();
		for (var note : customer.getNotes()) {
			noteList.add(new NoteDto(note));
		}
		
	}
	
	
}
