package ch.zli.m223.ksh19a.md.CRM.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("serial")
@Entity(name = "AppUser")
public class AppUserImpl implements AppUser {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	private String passwordHash;
	
	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RoleImpl> roles;
	
	

	protected AppUserImpl() { // for JPA only
		roles = new ArrayList<RoleImpl>();
	}

	public AppUserImpl(String email, String password) {
		this();
		this.email = email;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.passwordHash = encoder.encode(password);
	}
	
	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getEmail() {
		return email;
	}


	@Override
	public List<RoleImpl> getRoles() {
		return roles;
	}
	
	
	public void addRoleToList(RoleImpl newRole) {
		roles.add(newRole);
	}
	
	
	
	
	//Security

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
			.map(role -> new SimpleGrantedAuthority(role.getRole()))
			.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return passwordHash;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
