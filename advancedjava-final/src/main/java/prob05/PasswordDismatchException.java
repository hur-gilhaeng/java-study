package prob05;

public class PasswordDismatchException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordDismatchException(){
		super("PasswordDismatchException Occurs");
	}
	
	public PasswordDismatchException(String message){
		super(message);
	}
}
