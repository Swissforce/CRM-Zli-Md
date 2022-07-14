package ch.zli.m223.ksh19a.md.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.Validate;

import ch.zli.m223.ksh19a.md.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.md.CRM.model.Customer;
import ch.zli.m223.ksh19a.md.CRM.model.Gender;
import ch.zli.m223.ksh19a.md.CRM.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	

	@Override
	public List<Customer> getAllCustomers() {
		return new ArrayList<Customer>(customerRepository.findAll());
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> {
			throw new NotFoundException("Customer not found");
		});
	}

	@Override
	public Customer insertCustomer(String firstname, String lastname, String birthdate, Gender gender) {
		Validate.notNull(firstname, "Firstname must not be null");
		Validate.notNull(lastname, "Lastname must not be null");
		Validate.notNull(birthdate, "Birthdate must not be null");
		Validate.notNull(gender, "Gender must not be null");
		
		return customerRepository.insert(firstname, lastname, birthdate, gender);
	}

	@Override
	public Boolean deleteCustomer(Long id) {
		if (customerRepository.findById(id).isEmpty()) {
			return false;
		}
		customerRepository.deleteById(id);
		return true;
	}

}
