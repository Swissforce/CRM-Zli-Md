package ch.zli.m223.ksh19a.md.CRM.model;

import java.util.List;

public interface Customer {
	public Long getId();
	public String getFirstname();
	public String getLastname();
	public String getBirthdate();
	public Gender getGender();
	public List<NoteImpl> getNotes();
	public CustomerImpl addNoteToList(NoteImpl note);
}