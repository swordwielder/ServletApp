package Exception;

public class InvalidCustomerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3437353294598044688L;

	public InvalidCustomerException(String errorMessage) {
		super(errorMessage);
	}
	
	public InvalidCustomerException() {
		super();
	}
	
	public InvalidCustomerException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public InvalidCustomerException(Throwable cause) {
		super(cause);
	}
	
	
}
