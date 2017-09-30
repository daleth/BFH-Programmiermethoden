package bankapp.bank;

import java.util.ArrayList;
import bankapp.account.Account;

/**
 * 
 * @author david
 * 
 *         The class Bank manages bank accounts and executes bank transactions.
 */
public class Bank {
	/** The bank accounts. **/
	private ArrayList<Account> accounts = new ArrayList<>();

	/** The last account number. */
	private int lastAccountNr;
/**
 * Closes an account.
 * @param nr - the account number
 * @param pin - the PIN of the account
 * @return true if the account has been closed, or false if an error occurred
 */
	public boolean closeAccount(int nr, String pin) {
		//TODO Implementation
		return false;
	}
	/**
	 * Deposits money into an account.
	 * @param nr - the account number
	 * @param amount  - the amount of money to deposit
	 * @return true if the amount has been deposited, or false if an error occurred
	 */
	public boolean deposit(int nr, double amount) {
		//TODO Implementation
		return false;
	}
	/**
	 * Finds an account.
	 * @param nr - the account number
	 * @return the account, or null if the account does not exist
	 */
	private Account findAccount(int nr) {
		//TODO Implementation
		return null;
	}
	/**
	 * Gets the bank accounts.
	 * @return the bank accounts
	 */
	public ArrayList<Account> getAccounts() {
		// TODO Implementation
		return null;
	}
	/**
	 * Gets the balance of an account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @return the account balance, or null if an error occurred
	 */
	public Double getBalance(int nr, String pin) {
		// TODO Implementation
		return null;
	}
	/**
	 * Opens a bank account.
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 * @return the account number
	 */
	public int openAccount(String pin, double balance) {
		// TODO implementation
		return 0;
	}
	/**
	 * Withdraw money from an account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @param amount - the amount of money to withdraw
	 * @return true if the amount has been withdrawn, or false if an error occurred
	 */
	public boolean withdraw(int nr, String pin, double amount) {
		// TODO Implementation
		return false;
	}
	
}
