package bankapp.bank;

import java.util.ArrayList;
import bankapp.account.Account;
import bankapp.account.PersonalAccount;
import bankapp.account.SavingsAccount;

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
	private int lastAccountNr = 0;

	/**
	 * Closes an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @return true if the account has been closed, or false if an error occurred
	 */
	public boolean closeAccount(int nr, String pin) {
		Account account = this.findAccount(nr);
		if (account != null && account.checkPIN(pin)) {
			return this.accounts.remove(account);
		} else {
			return false;
		}
	}

	/**
	 * Deposits money into an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param amount
	 *            - the amount of money to deposit
	 * @return true if the amount has been deposited, or false if an error occurred
	 */
	public boolean deposit(int nr, double amount) {
		Account account = this.findAccount(nr);
		if (account != null) {
			return account.deposit(amount);
		} else {
			return false;
		}
	}

	/**
	 * Finds an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @return the account, or null if the account does not exist
	 */
	private Account findAccount(int nr) {
		for (Account account : accounts) {
			if (account.getNr() == nr) {
				return account;
			}
		}
		return null;
	}

	/**
	 * Gets the bank accounts.
	 * 
	 * @return the bank accounts
	 */
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	/**
	 * Gets the balance of an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @return the account balance, or null if an error occurred
	 */
	public Double getBalance(int nr, String pin) {
		Account account = this.findAccount(nr);
		if (account != null && account.checkPIN(pin)) {
			return account.getBalance();
		} else {
			return null;
		}
	}

	/**
	 * Opens a personal bank account.
	 * 
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 * @return the account number
	 */
	private int openPersonalAccount(String pin, double balance) {
		accounts.add(new PersonalAccount(++this.lastAccountNr, pin, balance));
		return this.lastAccountNr; 
	}

	/**
	 * Opens a savings bank account.
	 * 
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 * @return the account number
	 */
	private int openSavingsAccount(String pin, double balance) {
		accounts.add(new SavingsAccount(++this.lastAccountNr, pin, balance));
		return this.lastAccountNr;
	}

	public int openAccount(String pin, double balance, AccountType type) {
		int accountNumber=0;
		switch (type) {
		case PERSONAL:
			accountNumber = openPersonalAccount(pin, balance);
			break;
		case SAVINGS: 
			accountNumber = openSavingsAccount(pin, balance);
			break;
		default:
			break;
		} 
		return accountNumber;
	}
	
	
	
	/**
	 * Withdraw money from an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @param pin
	 *            - the PIN of the account
	 * @param amount
	 *            - the amount of money to withdraw
	 * @return true if the amount has been withdrawn, or false if an error occurred
	 */
	public boolean withdraw(int nr, String pin, double amount) {
		Account account = this.findAccount(nr);
		if (account != null && account.checkPIN(pin)) {
			return account.withdraw(amount);
		}
		return false;
	}

}
