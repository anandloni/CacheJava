package cache.exception;

import java.text.MessageFormat;

public class NotFoundException extends Exception {
	
	public NotFoundException(String message, Object... param) {
		super(MessageFormat.format(message, param));
	}
}
