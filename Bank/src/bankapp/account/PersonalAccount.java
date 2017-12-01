package bankapp.account;

import bankapp.bank.AccountType;

/**
 * The class Account represents personal bank accounts.
 * 
 * @author david
 *
 */
public class PersonalAccount extends Account {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2110030590300170572L;
	
	/**
	 * The interest rate.
	 */
	private static final double INTEREST_RATE = 0.005;

	/**
	 * Constructs a personal bank account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 */
	public PersonalAccount(int nr, String pin, double balance) {
		super(nr, pin, balance);
	}

	@Override
	public AccountType getType() {
		return AccountType.PERSONAL;
	}

	@Override
	public double getInterestRate() {
		return INTEREST_RATE;
	}
}
