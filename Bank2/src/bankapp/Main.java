package bankapp;

import bankapp.bank.Bank;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		String pin = "1234";
		double AMOUNT_TO_DEPOSIT = 1000.0;
		double AMOUNT_TO_WITHDRAW = 500.0;
		int nr = bank.openAccount(pin, 0.0);
		System.out.printf("Deposit %.2f on Account #%d. Result: %b %n", AMOUNT_TO_DEPOSIT, nr,
				bank.deposit(nr, AMOUNT_TO_DEPOSIT));
		System.out.printf("Deposit %.2f on Account #%d. Result: %b %n", AMOUNT_TO_WITHDRAW, nr,
				bank.withdraw(nr,pin, AMOUNT_TO_WITHDRAW));
		System.out.printf("The resulting balance is: %d %n", bank.getBalance(nr, pin));
		bank.closeAccount(nr, pin);

	}

}
