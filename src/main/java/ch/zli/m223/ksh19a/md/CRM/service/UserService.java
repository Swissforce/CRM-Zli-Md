package ch.zli.m223.ksh19a.md.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;

/**
 * Service class for the user
 * @author mardpp1
 *
 */
public interface UserService {
	/**
	 * returns all users
	 * @return List<AppUser>
	 */
	List<AppUser> getAllUsers();

	/**
	 * returns a single user
	 * @param id
	 * @return AppUser
	 */
	AppUser getUser(Long id);

	/**
	 * inserts a new user
	 * 
	 * @param name
	 * @param password
	 * @return AppUser
	 */
	AppUser insertUser(String name, String password);
	
	/**
	 * deletetes an existing user by id
	 * @param id
	 * @return true for a successful deletion, else false
	 */
	Boolean deleteUser(Long id);
}
