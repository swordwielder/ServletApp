package Exception;

public class IncorrectQueryInputException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4007839953803900592L;

	public IncorrectQueryInputException(String errorMessage) {
		super(errorMessage);
	}
	
	public IncorrectQueryInputException() {
		super();
	}
	
	public IncorrectQueryInputException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public IncorrectQueryInputException(Throwable cause) {
		super(cause);
	}

}
