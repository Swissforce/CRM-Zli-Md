package ch.zli.m223.ksh19a.md.CRM.controller.dto;

/**
 * Stripped Customer for input purposes
 * @author mardpp1
 *
 */
public class CustomerInputDto {
	public final String firstname;
	public final String lastname;
	public final String birthdate;
	public final String gender;
	
	/**
	 * Constructor
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 * @param gender
	 */
	public CustomerInputDto(String firstname, String lastname, String birthdate, String gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.gender = gender;
	}
}
