package ch.zli.m223.ksh19a.md.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;
import ch.zli.m223.ksh19a.md.CRM.model.AppUserImpl;

public interface UserRepository extends JpaRepository<AppUserImpl, Long> {
	// public List<AppUser> findAll();

	default AppUser insert(String userName, String password) {
		AppUserImpl user = new AppUserImpl(userName, password);
		return save(user); // TODO
	}
	
	Optional<AppUserImpl> findUserByEmail(String userName);	//Spring schwarze Magie
}