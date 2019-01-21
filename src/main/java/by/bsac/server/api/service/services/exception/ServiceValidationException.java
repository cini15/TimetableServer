package by.bsac.server.api.service.services.exception;

public class ServiceValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceValidationException(String message) {
		super(message);
	}
}