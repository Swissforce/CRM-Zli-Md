package ch.zli.m223.ksh19a.md.CRM.controller.dto;

import ch.zli.m223.ksh19a.md.CRM.model.Role;

/**
 * Stripped Role for displaying purposes
 * @author mardpp1
 *
 */
public class RoleDto {
	public final String role;
	
	/**
	 * Constructor
	 * @param role
	 */
	public RoleDto(Role role) {
		this.role = role.getRole();
	}
}
