package bankapp.atm;

import java.util.ArrayList;
import java.util.Scanner;

import bankapp.account.Account;
import bankapp.bank.AccountType;
import bankapp.bank.Bank;
import bankapp.bank.BankException;

/**
 * The class ATM implements the user interface of an automated teller machine.
 * 
 * @author david
 *
 */
public class ATM {
	/** The scanner used to read the console input. */
	private Scanner scanner = new Scanner(System.in);
	/** The bank to which the ATM is connected. */
	private Bank bank; // Unbedingt über Bank Interface ansprechen, damit die Implementierung stimmt. 
	/** The default initial balance when creating a new BankAccount */
	private static final double DEFAULT_INITIAL_BALANCE = 0.0; 

	/**
	 * Construct an automated teller machine.
	 * 
	 * @param bank
	 *            - the bank to which the ATM is connected
	 */
	public ATM(Bank bank) {
		this.bank = bank;
	}

	public void run() {
		while (true) {
			System.out.println("   A   TTTTTTT M     M");
			System.out.println("  A A     T    MM   MM");
			System.out.println(" AAAAA    T    M M M M");
			System.out.println("A     A   T    M  M  M");
			System.out.println();
			System.out.println("A  Open Account");
			System.out.println("B  Get Balance");
			System.out.println("C  Deposit");
			System.out.println("D  Withdraw");
			System.out.println("E  Close Account");
			System.out.println("X  Exit");
			System.out.println();
			System.out.print("> ");
			String choice = scanner.nextLine().toUpperCase();
			switch (choice) {
			case "A":
				openAccount();
				break;
			case "B":
				getBalance();
				break;
			case "C":
				deposit();
				break;
			case "D":
				withdraw();
				break;
			case "E":
				closeAccount();
				break;
			case "X":
				listAccounts();
				System.exit(0);
			default:
				System.out.println("Invalid input");
			}
			System.out.println("Hit Enter to continue...");
			scanner.nextLine();
		}
	}

	private void openAccount() {
		System.out.println("Creating bankaccount. Please Choose the Account type: ");
		System.out.println("P: Personal Account");
		System.out.println("S: Savings Account");
		String choice = scanner.nextLine().toUpperCase();
		int nr = 0;
		switch (choice) {
		case "P":
			nr = bank.openAccount( AccountType.PERSONAL, this.scanPin(), DEFAULT_INITIAL_BALANCE);
			break;
		case "S":
			nr = bank.openAccount(AccountType.SAVINGS, this.scanPin(), DEFAULT_INITIAL_BALANCE);
			break;
		default:
			System.out.println("Invalid input");
		}
		System.out.printf("Account with accountnumber %d created %n", nr);
	}
	
	private void getBalance() {
		System.out.println("You chose to display the balance: ");
		try {
			System.out.printf("The balance of your account is: %.2f %n", bank.getBalance(this.scanNr(), this.scanPin()));
		} catch (BankException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	private void deposit() {
		System.out.println("You chose to deposit money on your account. ");
		try {
			bank.deposit(this.scanNr(), this.scanAmount());
			System.out.println("Deposit successful. ");
		} catch (BankException e){
			System.err.println("Error: " + e.getMessage());
		}
	}

	private void withdraw() {
		System.out.println("You chose to withdraw money of your account. ");
		
		try {
			int nr = this.scanNr();
			String pin = this.scanPin();
			double amount = this.scanAmount();
			bank.withdraw(nr, pin, amount);
			System.out.println("Successful withdrawal.");
		} catch (BankException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private void closeAccount() {
		try {
			bank.closeAccount(this.scanNr(), this.scanPin());
			System.out.println("Your account has been closed");
		} catch (BankException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private void listAccounts() {
		
		ArrayList<Account> accounts = bank.getAccounts();
		accounts.sort(new AccountComparator());
		//Collections.sort(bank.getAccounts(), new AccountComparator());
				
		for (Account account : accounts) {
			
			
//			System.out.println(account.toString());
			System.out.printf("Account Type: %-10s Number: %-4d%+12.2f\n", account.getType(), account.getNr(), account.getBalance());
		}
	}

	private int scanNr() {
		System.out.print("Please enter your Account number: ");
		return Integer.parseInt(scanner.nextLine());
	}

	private String scanPin() {
		System.out.print("Please enter your PIN: ");
		return scanner.nextLine();
	}

	private double scanAmount() {
		System.out.print("Please enter the amount: ");
		return Double.parseDouble(scanner.nextLine());
	}
}
