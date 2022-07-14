package ch.zli.m223.ksh19a.md.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {
	public InvalidArgumentException(String msg) {
		super(msg, null, false, false);
	}
	
	public InvalidArgumentException() {
		this("");
	}
}
