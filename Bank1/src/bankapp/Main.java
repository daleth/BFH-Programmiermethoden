package bankapp;

import bankapp.account.Account;

public class Main {

	public static void main(String[] args) {
		Account acc = new Account(1, "1234"); 
		acc.checkPIN("1234"); 
		acc.deposit(500.0);
		acc.withdraw(250.0);
		System.out.printf("The account with number %d has the balance of %.2f.", acc.getNr(), acc.getBalance());
	}

}
