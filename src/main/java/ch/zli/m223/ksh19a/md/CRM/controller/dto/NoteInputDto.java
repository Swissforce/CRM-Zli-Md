package ch.zli.m223.ksh19a.md.CRM.controller.dto;

/**
 * Stripped Note for input purposes
 * @author mardpp1
 *
 */
public class NoteInputDto {
	public final Long appUserId;
	public final String note;
	
	/**
	 * Constructor
	 * @param appUserId
	 * @param note
	 */
	public NoteInputDto(Long appUserId, String note) {
		this.appUserId = appUserId;
		this.note = note;
	}
}
