package ch.zli.m223.ksh19a.md.CRM.controller.dto;

import ch.zli.m223.ksh19a.md.CRM.model.Role;

public class RoleDto {
	public final String role;
	
	public RoleDto(Role role) {
		this.role = role.getRole();
	}
}
