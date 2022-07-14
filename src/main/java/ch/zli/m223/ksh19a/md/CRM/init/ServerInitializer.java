package ch.zli.m223.ksh19a.md.CRM.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.ksh19a.md.CRM.model.AppUser;
import ch.zli.m223.ksh19a.md.CRM.model.CustomerImpl;
import ch.zli.m223.ksh19a.md.CRM.model.Gender;
import ch.zli.m223.ksh19a.md.CRM.model.NoteImpl;
import ch.zli.m223.ksh19a.md.CRM.repository.CustomerRepository;
import ch.zli.m223.ksh19a.md.CRM.repository.GenderRepository;
import ch.zli.m223.ksh19a.md.CRM.repository.RoleRepository;
import ch.zli.m223.ksh19a.md.CRM.repository.UserRepository;
import ch.zli.m223.ksh19a.md.CRM.roles.AppRoles;

@Component
public class ServerInitializer implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private GenderRepository genderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		//User
		roleRepository.insert(AppRoles.USER, userRepository.insert("Markus", "12345"));
		
		AppUser martin = userRepository.insert("Martin", "12345");
		roleRepository.insert(AppRoles.ADMIN, martin);
		roleRepository.insert(AppRoles.USER, martin);
		
		//Customer
		Gender m = genderRepository.insert("Männlich");
		Gender w = genderRepository.insert("Weiblich");
		Gender a = genderRepository.insert("Arbisa");
		
		
		CustomerImpl arbias = new CustomerImpl("Arbias", "Imeri", "ka", a);
		arbias.addNoteToList(new NoteImpl("Ginger", martin, arbias));
		customerRepository.insert(arbias);
		customerRepository.insert("Yannis", "Lee", "ka^2", m);
		

	}

}
