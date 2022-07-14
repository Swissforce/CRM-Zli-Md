package ch.zli.m223.ksh19a.md.CRM.controller.dto;

public class NoteInputDto {
	public final Long appUserId;
	public final String note;
	
	public NoteInputDto(Long appUserId, String note) {
		this.appUserId = appUserId;
		this.note = note;
	}
}
