package bankapp;

import bankapp.atm.ATM;
import bankapp.bank.BankImpl;
import bankapp.bank.Bank;

public class Main {

	public static void main(String[] args) {
		Bank bank = new BankImpl();
		ATM atm = new ATM(bank);	
		atm.run();
	}

}
