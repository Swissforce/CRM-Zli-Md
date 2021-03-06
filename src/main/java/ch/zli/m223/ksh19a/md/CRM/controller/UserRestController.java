package ch.zli.m223.ksh19a.md.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.md.CRM.controller.dto.RoleDto;
import ch.zli.m223.ksh19a.md.CRM.controller.dto.UserDto;
import ch.zli.m223.ksh19a.md.CRM.controller.dto.UserInputDto;
import ch.zli.m223.ksh19a.md.CRM.service.CustomerService;
import ch.zli.m223.ksh19a.md.CRM.service.UserService;
/**
 * Rest controller for the user
 * @author mardpp1
 *
 */
@RestController
@RequestMapping("/api/v1")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/users")
	List<UserDto> getAllUsers() {
		return userService.getAllUsers().stream()
				.map(user -> new UserDto(user))
				.collect(Collectors.toList());
	}

	@GetMapping("/users/{id}")
	UserDto getUser(@PathVariable("id") Long id) {
		return new UserDto(userService.getUser(id));
	}
	
	@PostMapping("/users")
	UserDto insertUser(@RequestBody UserInputDto userData) {
		return new UserDto(userService.insertUser(userData.email, userData.password));
	}
	
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable("id") Long id) {
		for (var customers : customerService.getAllCustomers()) {
			for (var note : customers.getNotes()) {
				if (note.getAppUser() != null) {
					if (note.getAppUser().getId() == id) {
						note.changeOwnerToNull();
					}
				}
			}
		}
		
		userService.deleteUser(id);
	}
	
	@GetMapping("/users/{id}/roles")
	List<RoleDto> getRolesForUser(@PathVariable("id") Long id){
		var user = userService.getUser(id);
		return user.getRoles().stream()
			.map(role -> new RoleDto(role))
			.collect(Collectors.toList());
	}
}
