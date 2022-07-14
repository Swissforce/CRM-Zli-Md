package ch.zli.m223.ksh19a.md.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.md.CRM.model.Customer;
import ch.zli.m223.ksh19a.md.CRM.model.CustomerImpl;
import ch.zli.m223.ksh19a.md.CRM.model.Gender;

public interface CustomerRepository extends JpaRepository<CustomerImpl, Long>{
	default Customer insert(String firstname, String lastname, String birthdate, Gender gender) {
		return save(new CustomerImpl(firstname, lastname, birthdate, gender));
	}
	
	default Customer insert(CustomerImpl customer) {
		return save(customer);
	}
	
	

}
