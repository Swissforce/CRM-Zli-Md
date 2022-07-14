package ch.zli.m223.ksh19a.md.CRM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String genderName;
	
	
	public Gender(String genderName) {
		this.genderName = genderName;
	}
	
	protected Gender() {
		//for JPA only
	}
	
	
	public String getGenderName() {
		return genderName;
	}
}
