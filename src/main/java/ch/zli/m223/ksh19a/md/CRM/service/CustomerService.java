package ch.zli.m223.ksh19a.md.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19a.md.CRM.model.Customer;
import ch.zli.m223.ksh19a.md.CRM.model.Gender;

/**
 * Service class of the customer
 * @author mardpp1
 *
 */
public interface CustomerService {
	/**
	 * returns all customer
	 * @return List<Customer>
	 */
	List<Customer> getAllCustomers();
	
	/**
	 * returns a customer by id
	 * @param id
	 * @return Customer
	 */
	Customer getCustomer(Long id);
	
	/**
	 * inserts a new customer
	 * 
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 * @param gender
	 * @return Customer
	 */
	Customer insertCustomer(String firstname, String lastname, String birthdate, Gender gender);
	
	/**
	 * inserts / updates a customer
	 * 
	 * @param customer
	 * @return Customer
	 */
	Customer update(Customer customer);
	
	/**
	 * deletes an existing user by id
	 * 
	 * @param id
	 * @return true when succesfully deleted, else false
	 */
	Boolean deleteCustomer(Long id);
}
