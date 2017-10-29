package bankapp.account;

import bankapp.bank.AccountType;
import bankapp.bank.BankException;

/**
 * The class Account represents savings bank accounts.
 * 
 * @author david
 *
 */
public class SavingsAccount extends Account {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8515025198645702073L;
	/**
	 * The withdraw limit.
	 */
	public static final double WITHDRAW_LIMIT = 1000.0;

	/**
	 * Constructs a savings bank account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 */
	public SavingsAccount(int nr, String pin, double balance) {
		super(nr, pin, balance);
	}
	
	public AccountType getType() {
		return AccountType.SAVINGS;
	}

	@Override
	public void withdraw(double amount) throws BankException {

		if (amount > balance)
			throw new BankException("Balance not sufficient");
		if (amount > WITHDRAW_LIMIT)
			throw new BankException("Withdraw limit reached");

		else {
			super.withdraw(amount);
			// CAVE: Must explicit invoke super.withdraw() otherwise
			// java.lang.StackOverflowError!
		}
	}

}
