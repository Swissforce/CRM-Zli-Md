package ch.zli.m223.ksh19a.md.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19a.md.CRM.model.Customer;
import ch.zli.m223.ksh19a.md.CRM.model.Gender;

public interface CustomerService {
	List<Customer> getAllCustomers();
	
	Customer getCustomer(Long id);
	
	Customer insertCustomer(String firstname, String lastname, String birthdate, Gender gender);
	
	Customer update(Customer customer);
	
	Boolean deleteCustomer(Long id);
}
