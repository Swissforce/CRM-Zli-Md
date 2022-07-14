package ch.zli.m223.ksh19a.md.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Note")
public class NoteImpl implements Note{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String note;
	private long timestamp;
	
	@ManyToOne
	private AppUserImpl appUser;
	
	@ManyToOne
	private CustomerImpl customer;
	
	
	
	protected NoteImpl() {
		//for JPA only
		this.timestamp = System.currentTimeMillis();
	}
	
	
	public NoteImpl(String note, AppUser appUser, Customer customer) {
		this();
		this.note = note;
		this.appUser = (AppUserImpl)appUser;
		this.customer = (CustomerImpl)customer;
	}
	

	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getNote() {
		return note;
	}

	@Override
	public Long getTimeStamp() {
		return timestamp;
	}

	@Override
	public AppUser getAppUser() {
		return appUser;
	}



}
