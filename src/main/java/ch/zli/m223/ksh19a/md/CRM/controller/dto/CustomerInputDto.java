package ch.zli.m223.ksh19a.md.CRM.controller.dto;

public class CustomerInputDto {
	public final String firstname;
	public final String lastname;
	public final String birthdate;
	public final String gender;
	
	public CustomerInputDto(String firstname, String lastname, String birthdate, String gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.gender = gender;
	}
}
