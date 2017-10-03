package bankapp.account;
/**
 * The class Account represents savings bank accounts.
 * @author david
 *
 */
public class SavingsAccount extends Account{
	/**
	 * The withdraw limit.
	 */
	public static final double WITHDRAW_LIMIT = 1000.0; 
	/**
	 * Constructs a savings bank account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 */
	public SavingsAccount(int nr,
            String pin,
            double balance) {
		super(nr, pin, balance);
	}

	
	@Override
	public boolean withdraw(double amount) {
		if (amount > WITHDRAW_LIMIT) {
			return false;
		} else if (amount > getBalance()) {
			return false; 			
		} else {
			return super.withdraw(amount); 
			// CAVE: Must explicit invoke super.withdraw() otherwise java.lang.StackOverflowError! 
		}
	}

}