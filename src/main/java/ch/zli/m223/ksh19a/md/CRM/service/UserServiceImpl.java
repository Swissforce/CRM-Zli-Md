package ch.zli.m223.ksh19a.md.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.md.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.md.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.md.CRM.exception.UserAllreadyExistsException;
import ch.zli.m223.ksh19a.md.CRM.model.AppUser;
import ch.zli.m223.ksh19a.md.CRM.repository.UserRepository;

/**
 * Implementation of the interface UserService
 * @author mardpp1
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	@Override
	public List<AppUser> getAllUsers() {
		return new ArrayList<AppUser>(userRepository.findAll());
	}


	@Override
	public AppUser getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> {
			throw new NotFoundException("User not found");
		});
	}


	@Override
	public AppUser insertUser(String name, String password) {
		if (name == null) throw new InvalidArgumentException("Name must not be null");
		if (userRepository.findUserByEmail(name).isPresent()) {
			throw new UserAllreadyExistsException ("User with name: " + name + " already exists");
		}
		return userRepository.insert(name, password);
	}
	
	/**
	 * inserts / updates an existing user
	 * 
	 * @param user
	 * @return AppUser
	 */
	public AppUser update(AppUser user) {
		return userRepository.update(user);
	}

	
	@Override
	public Boolean deleteUser(Long id) {
		if (userRepository.findById(id).isEmpty()) {
			return false;
		}
		userRepository.deleteById(id);
		return true;
	}

}
