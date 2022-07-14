package ch.zli.m223.ksh19a.md.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;
import ch.zli.m223.ksh19a.md.CRM.model.AppUserImpl;
import ch.zli.m223.ksh19a.md.CRM.model.Role;
import ch.zli.m223.ksh19a.md.CRM.model.RoleImpl;

public interface RoleRepository extends JpaRepository<RoleImpl, Long>{
	default Role insert(String role, AppUser appUser) {
		AppUserImpl userImpl = (AppUserImpl)appUser;
		RoleImpl newRole = new RoleImpl(role, userImpl);
		RoleImpl roleImpl = save(newRole);
		userImpl.addRoleToList(newRole);
		
		
		
		return save(newRole);
	}
}
