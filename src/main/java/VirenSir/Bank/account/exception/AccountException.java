package VirenSir.Bank.account.exception;

public class AccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountException() {
	}

	public AccountException(String message) {
		super(message);
	}

	public AccountException(Throwable cause) {
		super(cause);
	}


}
