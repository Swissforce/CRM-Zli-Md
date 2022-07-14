package ch.zli.m223.ksh19a.md.CRM.controller.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;

public class UserDto {
	public final Long id;
	public final String email;
	public List<String> roleList;
	
	public UserDto(AppUser user) {
		this.id = user.getId();
		this.email = user.getEmail();
		roleList = new ArrayList<>();
		
		for (var role : user.getRoles()) {
			roleList.add(role.getRole());
		}
	}
}
