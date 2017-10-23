package bankapp.account;

import java.time.LocalDate;

/**
 * The class represents a bank transaction
 * @author david
 *
 */
public class Transaction {
	/** The amount of the transaction */
	private double amount; 
	/** The current account balance*/
	private double balance;
	/** The valuta of the transaction */
	private LocalDate valuta;
	/**
	 * Constructs a bank transaction
	 * @param amount - the amount of the transaction
	 * @param balance - the current account balance
	 */
	public Transaction(double amount, double balance) {
		valuta = LocalDate.now();
		this.amount = amount; 
		this.balance = balance;
		
	}
	/**
	 * Gets the amount of the transaction
	 * @return the amount of the transaction
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * Gets the balance of the transaction
	 * @return the balance of the transaction
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Gets the valuta of the transaction
	 * @return the valuta of the transaction
	 */
	public LocalDate getValuta() {
		return this.valuta;
	}
	/**
	 * Generates a string representation of the transaction
	 * @return a string representation of the transaction
	 */
	@Override 
	public String toString() {
		return String.format("-%s: %+12.2f, %+12.2f", valuta.toString(), amount, balance);
	}
	
	
	
}
