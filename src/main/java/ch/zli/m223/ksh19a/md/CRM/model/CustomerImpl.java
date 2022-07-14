package ch.zli.m223.ksh19a.md.CRM.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Customer")
public class CustomerImpl implements Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	private String birthdate;
	
	@ManyToOne
	private Gender gender;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<NoteImpl> notes;

	
	
	protected CustomerImpl() {
		//for JPA only
		notes = new ArrayList<NoteImpl>();
	}
	
	
	public CustomerImpl(String firstname, String lastname, String birthdate, Gender gender) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.gender = gender;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public String getLastname() {
		return lastname;
	}
	
	@Override
	public String getBirthdate() {
		return birthdate;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public List<NoteImpl> getNotes() {
		return notes;
	}


	@Override
	public CustomerImpl addNoteToList(NoteImpl note) {
		if (!notes.contains(note)) {
			notes.add(note);
		}
		return this;
	}


}
