package ch.zli.m223.ksh19a.md.CRM.controller.dto;

/**
 * Stripped Customer for input purposes
 * @author mardpp1
 *
 */
public class UserInputDto {
	public final String email;
	public final String password;
	
	/**
	 * Constructor
	 * @param email
	 * @param password
	 */
	public UserInputDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
