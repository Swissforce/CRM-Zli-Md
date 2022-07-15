package ch.zli.m223.ksh19a.md.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;
import ch.zli.m223.ksh19a.md.CRM.model.AppUserImpl;

public interface UserRepository extends JpaRepository<AppUserImpl, Long> {

	default AppUser insert(String userName, String password) {
		AppUserImpl user = new AppUserImpl(userName, password);
		return save(user);
	}
	
	default AppUser update(AppUser user) {
		return save((AppUserImpl)user);
	}
	
	Optional<AppUserImpl> findUserByEmail(String userName);	//Spring schwarze Magie
}