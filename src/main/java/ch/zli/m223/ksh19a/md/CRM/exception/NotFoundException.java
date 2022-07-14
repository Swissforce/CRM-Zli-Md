package ch.zli.m223.ksh19a.md.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	public NotFoundException(String msg) {
		super(msg, null, false, false);
	}
	
	public NotFoundException() {
		this("");
	}
}
