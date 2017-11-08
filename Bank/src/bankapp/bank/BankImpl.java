package bankapp.bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class BankImpl extends Thread implements Bank {
	/**
	 * The interest period (in milliseconds).
	 */
	private static long INTEREST_PERIOD = 10000L;

	/** The name of the data file. */
	private static String DATA_FILE;

	/** The bank accounts. **/
	private HashMap<Integer, Account> accounts;

	/** The last account number. */
	private int lastAccountNr = 0;

	/**
	 * Constructs a bank.
	 */
	public BankImpl() {
		// TODO Laden des File nur in der loadData()
		DATA_FILE = "data/" + this.getClass().getName();
		File file = new File(DATA_FILE);
		if (file.exists()) {
			this.loadData();
		} else {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accounts = new HashMap<>();
			this.saveData();
			

		}	
		// Initializing the Thread that pays interests periodically. 
		Thread interestPayment = new Thread(this);
		interestPayment.start();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#closeAccount(int, java.lang.String)
	 */
	public void closeAccount(int nr, String pin) throws BankException {
		Account account = this.findAccount(nr);
		account.checkPIN(pin);
		this.accounts.remove(nr);
		this.saveData();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankapp.bank.Bank#deposit(int, double)
	 */
	public void deposit(int nr, double amount) throws BankException {
		Account account = this.findAccount(nr);
		account.deposit(amount);
		this.saveData();

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

		// if (accounts.containsKey(nr))
		// return account.get(nr);
	}

	/**
	 * Gets the bank accounts.
	 * 
	 * @return the bank accounts
	 */
	public List<Account> getAccounts() {
		return new ArrayList<>(accounts.values());
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

	@Override
	public List<Transaction> getTransactions(int nr, String pin) throws BankException {
		// TODO Auto-generated method stub
		Account account = this.findAccount(nr);
		account.checkPIN(pin);
		return account.getTransactions();
	}

	/**
	 * Loads the data of the bank from a file.
	 */
	@SuppressWarnings("unchecked")
	private void loadData() {
		// TODO Implement loadData()

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
			this.lastAccountNr = in.readInt();
			this.accounts = (HashMap<Integer, Account>) in.readObject();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Alternativ im Catch-Block die Objekte initialisieren, wenn kein File
		// existiert.

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
		this.saveData();
		return lastAccountNr;
	}

	/**
	 * Periodically pays interests to the bank accounts.
	 */
	@Override
	public void run() {
		while (!interrupted()) {
			try {
				sleep(INTEREST_PERIOD);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Account acc : getAccounts()) {
				acc.payInterests();
			}
			this.saveData(); // Do not forget to save the data!
		}
	}

	/**
	 * Saves the data of the bank to a file.
	 */
	private void saveData() {
		// TODO Implement saveData()
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
			out.writeInt(lastAccountNr);
			out.writeObject(accounts);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: " + e);
		}

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
		this.saveData();

	}

}
