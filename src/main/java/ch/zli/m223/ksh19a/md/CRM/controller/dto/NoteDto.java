package ch.zli.m223.ksh19a.md.CRM.controller.dto;

import ch.zli.m223.ksh19a.md.CRM.model.Note;

/**
 * Stripped Note for displaying purposes
 * @author mardpp1
 *
 */
public class NoteDto {
	public final Long id;
	public final Long appUserId;
	public final String note;
	public final long timestamp;
	
	/**
	 * Constructor
	 * @param note
	 */
	public NoteDto(Note note) {
		this.id = note.getId();
		this.appUserId = note.getAppUser().getId();
		this.note = note.getNote();
		this.timestamp = note.getTimeStamp();
	}
	
}
