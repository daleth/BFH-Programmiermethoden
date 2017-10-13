package bankapp.account;

import bankapp.bank.AccountType;
import bankapp.bank.BankException;

public abstract class Account {
	/**
	 * The number of the account.
	 */
	protected int nr;
	/**
	 * The PIN of the account.
	 */
	protected String pin;
	/**
	 * The account balance.
	 */
	protected double balance;

	/**
	 * Constructs a bank account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 */
	public Account(int nr, String pin, double balance) {
		this.nr = nr;
		this.pin = pin;
		this.balance = balance;
	}

	/**
	 * Constructs an empty bank account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 */
	public Account(int nr, String pin) {
		this(nr, pin, 0.0);
	}

	/**
	 * Checks the PIN of the account.
	 * 
	 * @param pin
	 *            - the PIN to check
	 * 
	 * @return true if the PIN is valid, false otherwise
	 */
	public void checkPIN(String pin) throws BankException {
		if (!this.pin.equals(pin)) {
			throw new BankException("Wrong PIN.");
		} 
	}

	/**
	 * Deposits money into the account.
	 * 
	 * @param amount
	 *            - the amount of money to deposit
	 * @return true if the deposit was successful, false otherwise
	 */
	public void deposit(double amount) throws BankException{
		if (amount < 0) {
			throw new BankException("Not possible to deposit negative amounts");
		} else {
			this.balance = this.balance + amount;
		}
	}

	/**
	 * Gets the balance of the account.
	 * 
	 * @return the account balance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Gets the number of the account.
	 * 
	 * @return the account number
	 */
	public int getNr() {
		return this.nr;
	}

	/**
	 * Gets the type of the account.
	 * 
	 * @return the account type
	 */
	public abstract AccountType getType();

	/**
	 * Withdraws money from the account.
	 * 
	 * @param amount
	 *            - the amount of money to withdraw
	 * @return true if the withdrawal was successful, false otherwise
	 */
	public void withdraw(double amount) throws BankException {
		if (amount < 0) {
			throw new BankException("Not possible to withdraw negative amount.");
		}
		// else if (amount > this.getBalance()) {
		// return false;
		// }
		else {
			this.balance = this.balance - amount;
		}
	}

	/**
	 * Checks if the account is equal to an another object.
	 * 
	 * @param object
	 *            - the other object
	 * @return true if the accounts are equal, false otherwise
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Account)) {
			return false;
		}
		Account a = (Account) object;
		return a.nr == nr;
	}

	/**
	 * Computes a hash code of the account.
	 * 
	 * @return the hash code of the account
	 */
	@Override
	public int hashCode() {
		return this.nr;
	}

	/**
	 * Generates a string representation of the account.
	 * 
	 * @return a string representation of the account
	 */
	@Override
	public String toString() {
		return String.format("AccountType = %s, nr = %d, balance = %.2f", this.getType(), this.nr, this.balance);
	}
}
