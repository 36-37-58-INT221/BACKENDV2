package int221.project.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

	public static enum ERROR_CODE {
		PRODUCT_DOES_NOT_EXIST, PRODUCT_ALREADY_EXIST, DOES_NOT_FIND_ID, DUPICATE_IN_PRODUCTS,
		CAN_NOT_UPLOAD_THIS_FILETYPE;

		ERROR_CODE() {
		};

	}

	private ERROR_CODE errorCode;
	private String message;
	private LocalDateTime dateTime;

	public ExceptionResponse(ERROR_CODE errorCode, String message, LocalDateTime dateTime) {
		this.errorCode = errorCode;
		this.message = message;
		this.dateTime = dateTime;
	}

	public ERROR_CODE getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}