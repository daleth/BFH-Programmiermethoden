package bankapp.bank;

public class BankException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6771100771304461682L;

	/**
	 * Constructs a bank exception.
	 * 
	 * @param message
	 *            - the error message
	 */
	public BankException(String message) {
		super(message); 
	}
}
