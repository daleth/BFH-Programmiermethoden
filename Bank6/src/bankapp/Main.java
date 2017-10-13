package bankapp;

import bankapp.atmgui.ATM; // Change to atmgui
import bankapp.bank.BankImpl;
import bankapp.bank.Bank;

public class Main {

	public static void main(String[] args) {
		Bank bank = new BankImpl(); // Es kann irgendeine Bank definiert werden, hauptsache, sie implmentiert das Interface Bank
		ATM atm = new ATM(bank);	
		atm.run();
		ATM atm2 = new ATM(bank);	
		atm2.run();
		
		
	}

}
