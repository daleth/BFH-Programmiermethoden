package bankapp.atm;

import java.util.Comparator;

import bankapp.account.Account;

public class AccountComparator implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) {
		Account a1 = (Account) o1;
		Account a2 = (Account) o2;
		
		return (int) (a1.getBalance()-a2.getBalance());

	}

}
