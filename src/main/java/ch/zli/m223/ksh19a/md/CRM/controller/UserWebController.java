package ch.zli.m223.ksh19a.md.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;
import ch.zli.m223.ksh19a.md.CRM.service.UserService;

@Controller
public class UserWebController {

	@Autowired
	private UserService userService;

	@GetMapping("/userlist")
	String getUserList(Model model) {
		List<AppUser> userList = userService.getAllUsers();
		model.addAttribute("users", userList);
		return "userList"; // templates/userList.html
	}
	
	
	@GetMapping("/admin")
	String gotoAdminPage() {
		return "admin_page";
	}
	
	@GetMapping("/user")
	String gotoUserPage() {
		return "user_page";
	}
	
	@GetMapping("/loged_in")
	String gotoLogedInPage() {
		return "loged_in_page";
	}
}

