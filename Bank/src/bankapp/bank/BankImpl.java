package bankapp.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bankapp.account.Account;
import bankapp.account.PersonalAccount;
import bankapp.account.SavingsAccount;
import bankapp.account.Transaction;

/**
 * 
 * @author david
 * 
 *         The class Bank manages bank accounts and executes bank transactions.
 */
public class BankImpl implements Bank {
	/** The bank accounts. **/
	private HashMap<Integer, Account> accounts = new HashMap<>();

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
		this.accounts.remove(nr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#deposit(int, double)
	 */
	public void deposit(int nr, double amount) throws BankException {
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
		Account acc = accounts.get(nr);
		if (acc != null)
			return acc;
		throw new BankException("Account not found");
	}

	/**
	 * Gets the bank accounts.
	 * 
	 * @return the bank accounts
	 */
	public List<Account> getAccounts() {
		return new ArrayList<Account>(accounts.values());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#getBalance(int, java.lang.String)
	 */
	public double getBalance(int nr, String pin) throws BankException {
		Account account = this.findAccount(nr);
		account.checkPIN(pin);
		return account.getBalance();
	}

	/**
	 * Opens a bank account.
	 * 
	 * @param pin
	 *            - the PIN of the account
	 * @param balance
	 *            - the initial balance
	 * @param type
	 *            - the account type
	 * @return the account number
	 */
	public int openAccount(AccountType type, String pin, double balance) {
		switch (type) {
		case PERSONAL:
			accounts.put(++this.lastAccountNr, new PersonalAccount(this.lastAccountNr, pin, balance));
			break;
		case SAVINGS:
			accounts.put(++this.lastAccountNr, new SavingsAccount(this.lastAccountNr, pin, balance));
			break;
		default:
			break;
		}
		return lastAccountNr;
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

	@Override
	public List<Transaction> getTransactions(int nr, String pin) throws BankException {
		// TODO Auto-generated method stub
		Account account = this.findAccount(nr); 
		account.checkPIN(pin);
		return account.getTransactions(); 
	}
	
	

}
