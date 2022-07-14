package ch.zli.m223.ksh19a.md.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Role")
public class RoleImpl implements Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String role;
	
	@ManyToOne
	private AppUserImpl appUser;
	
	
	
	public RoleImpl(String role, AppUserImpl appUser) {
		this.role = role;
		this.appUser = appUser;
	}
	
	protected RoleImpl() {
		// for JPA only
	}
	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getRole() {
		return role;
	}

}
