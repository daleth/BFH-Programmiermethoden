package bankapp.account;

import java.util.ArrayList;
import java.util.List;

import bankapp.bank.AccountType;
import bankapp.bank.BankException;
/**
 * The class Account represents bank accounts.
 * @author david
 *
 */
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
	 * The transactions of the account.
	 */
	private List<Transaction> transactions = new ArrayList<>();

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
	 * @throws BankException
	 *             - if the account does not exist or the pin is invalid
	 */
	public void checkPIN(String pin) throws BankException {
		if (!this.pin.equals(pin)) {
			throw new BankException("Wrong PIN.");
		}
		return; //
	}

	/**
	 * Deposits money into the account.
	 * 
	 * @param amount
	 *            - the amount of money to deposit
	 * @throws BankException
	 *             - if the deposit failed
	 */
	public void deposit(double amount) throws BankException {
		if (amount < 0) {
			throw new BankException("Not possible to deposit negative amounts");
		} else { // Dieses else wäre nicht notwendig. 
			this.balance = this.balance + amount;
			this.transactions.add(new Transaction(amount, this.balance));
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
	 * @throws BankException
	 *             - if the withdrawal failed
	 */
	public void withdraw(double amount) throws BankException {
		if (amount < 0) {
			throw new BankException("Not possible to withdraw negative amount.");
		} else {
			this.balance = this.balance - amount;
			this.transactions.add(new Transaction(-amount, this.balance));

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
	/**
	 * Gets the transactions of the account
	 * @return the account transactions
	 */
	public List<Transaction> getTransactions() {
		return this.transactions;
	}
}
