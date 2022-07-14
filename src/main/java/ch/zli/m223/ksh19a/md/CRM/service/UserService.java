package ch.zli.m223.ksh19a.md.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;

public interface UserService {
	List<AppUser> getAllUsers();

	AppUser getUser(Long id);

	AppUser insertUser(String name, String password);
	
	Boolean deleteUser(Long id);
}
