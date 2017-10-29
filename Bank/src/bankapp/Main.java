package bankapp;

import bankapp.bank.BankImpl;
import bankapp.bank.Bank;

public class Main {

	public static void main(String[] args) {
		Bank bank = new BankImpl(); // Es kann irgendeine Bank definiert werden, hauptsache, sie implmentiert das Interface Bank
//		bankapp.atmgui.ATM atm = new bankapp.atmgui.ATM(bank);	
//		atm.run();
		bankapp.atm.ATM atm2 = new bankapp.atm.ATM(bank);	
		atm2.run();
	}
}
