package bankapp.atm;

import java.util.Comparator;

import bankapp.account.Account;
/**
 * 
 * @author david
 *
 */
public class AccountComparator implements Comparator<Account> {
/**
 * 
 */
	
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Account o1, Account o2) {

		Account a1 = (Account) o1;
		Account a2 = (Account) o2;
		
		return (int) (a1.getBalance()-a2.getBalance());
		// Oder Double.compare(balance1, balance2);

	}

	/*
	 * Oder (Lösung von Dozent) 
	 * 	public int compare(Object o1, Object o2) {
		double balance1 = ((Account) o1).getBalance();
		double balance2 = ((Account) o2).getBalance();
		return (int) (balance1 - balance2);
		}
	 */
}
