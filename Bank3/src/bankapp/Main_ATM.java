package bankapp;

import bankapp.atm.ATM;
import bankapp.bank.Bank;

public class Main_ATM {

	public static void main(String[] args) {
		Bank bank = new Bank();
		ATM atm = new ATM(bank);	
		atm.run();
	}

}
