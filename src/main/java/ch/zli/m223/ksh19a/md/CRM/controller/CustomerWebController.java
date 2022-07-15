package ch.zli.m223.ksh19a.md.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.zli.m223.ksh19a.md.CRM.model.Customer;
import ch.zli.m223.ksh19a.md.CRM.service.CustomerService;

/**
 * Webcontroller for the customer
 * @author mardpp1
 *
 */
@Controller
public class CustomerWebController {
	
	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/customerlist")
	String getCustomerList(Model model) {
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customers", customerList);
		return "customerList";
	}
	
}
