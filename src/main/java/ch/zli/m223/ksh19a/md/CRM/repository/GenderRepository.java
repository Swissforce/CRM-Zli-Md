package ch.zli.m223.ksh19a.md.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.md.CRM.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{
	default Gender insert(String genderName) {
		return save(new Gender(genderName));
	}
	
	Optional<Gender> findGenderByGenderName(String genderName);	//Spring schwarze Magie
}
