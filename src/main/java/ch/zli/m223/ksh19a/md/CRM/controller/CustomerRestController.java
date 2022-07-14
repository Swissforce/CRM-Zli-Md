package ch.zli.m223.ksh19a.md.CRM.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.md.CRM.controller.dto.CustomerDto;
import ch.zli.m223.ksh19a.md.CRM.controller.dto.CustomerInputDto;
import ch.zli.m223.ksh19a.md.CRM.model.Gender;
import ch.zli.m223.ksh19a.md.CRM.repository.GenderRepository;
import ch.zli.m223.ksh19a.md.CRM.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private GenderRepository genderRepository;
	

	@GetMapping("/customers")
	List<CustomerDto> getAllCustomers(){
		return customerService.getAllCustomers().stream()
				.map(customer -> new CustomerDto(customer))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/customers/{id}")
	CustomerDto getCustomer(@PathVariable("id") Long id) {
		return new CustomerDto(customerService.getCustomer(id));
	}
	
	@PostMapping("/customers")
	CustomerDto insertCustomer(@RequestBody CustomerInputDto customerData) {
		Optional<Gender> optGender = genderRepository.findGenderByGenderName(customerData.gender);
		Gender gender;
		
		if (optGender.isPresent()) {
			gender = optGender.get();
		}
		else {
			gender = genderRepository.insert(customerData.gender);
		}

		return new CustomerDto(customerService.insertCustomer(customerData.firstname, customerData.lastname, customerData.birthdate, gender));
	}
	
	
	@DeleteMapping("/customers/{id}")
	void deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
	}
	
	

	
}
