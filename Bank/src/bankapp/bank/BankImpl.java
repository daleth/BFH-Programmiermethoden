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
public class BankImpl implements Bank {
	/** The bank accounts. **/
	private ArrayList<Account> accounts = new ArrayList<>();

	/** The last account number. */
	private int lastAccountNr = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#closeAccount(int, java.lang.String)
	 */
	public void closeAccount(int nr, String pin) throws BankException {
			Account account = this.findAccount(nr);
			account.checkPIN(pin);
			this.accounts.remove(account);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#deposit(int, double)
	 */
	public void deposit(int nr, double amount) throws BankException{
			Account account = this.findAccount(nr);
			account.deposit(amount);
	}

	/**
	 * Finds an account.
	 * 
	 * @param nr
	 *            - the account number
	 * @return the account, or null if the account does not exist
	 */
	private Account findAccount(int nr) throws BankException {
		for (Account account : accounts) {
			if (account.getNr() == nr) {
				return account;
			}
		}
		throw new BankException("Account not found");
	}

	/**
	 * Gets the bank accounts.
	 * 
	 * @return the bank accounts
	 */
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#getBalance(int, java.lang.String)
	 */
	public Double getBalance(int nr, String pin) throws BankException {
			Account account = this.findAccount(nr);
			account.checkPIN(pin);
			return account.getBalance();
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

	/**
	 * 
	 * @param pin
	 * @param balance
	 * @param type
	 * @return
	 */
	public int openAccount(AccountType type, String pin, double balance) {
		int accountNumber = 0;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#withdraw(int, java.lang.String, double)
	 */
	public void withdraw(int nr, String pin, double amount) throws BankException {
		Account account = this.findAccount(nr);
		account.checkPIN(pin);
		account.withdraw(amount);
	
	}

}
