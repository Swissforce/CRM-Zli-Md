package ch.zli.m223.ksh19a.md.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.IM_USED)
public class UserAllreadyExistsException extends RuntimeException {

	public UserAllreadyExistsException(String msg) {
		super(msg, null, false, false);
	}
	
	public UserAllreadyExistsException() {
		this("");
	}
}
