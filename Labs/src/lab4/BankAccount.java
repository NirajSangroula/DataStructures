/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 4
Any and all work in this file is my own.
*/
package lab4;

public class BankAccount {
	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountNumber) {
		if(verify(accountNumber)) {
			this.accountNumber = accountNumber;
			//Balance must be set 0
			balance = 0;
		}
		else
			throw new BankException("Account number is invalid");
	}
	
	public BankAccount(String accountNumber, double initialBalance) {
		if(verify(accountNumber)) {
			this.accountNumber = accountNumber;
		}
		else
			throw new BankException("Account number is invalid");
		
		if(initialBalance >= 0) {
			this.balance = initialBalance;
		}
		else
			throw new BankException("Initial Balance must be positive");
		
	}
	
	//Deposit adds to the balance
	public void deposit(double amount) {
		balance += amount;
	}
	
	//Withdraw subtracts from the balance
	public void withdraw(double amount) throws BankException{
		if(amount <= balance)
			balance -= amount;
		else
			throw new BankException("Insufficient balance");
	}
	
	public double balance() {
		return balance;
	}
	@Override
	public String toString() {
		return "BankAccount[accountNumber=" + accountNumber + ", balance=$" + balance + "]";
	}
	
	private boolean verify(String accountNumber) {
		//Check length
		if(accountNumber.length() != 8)
			return false;
		else {
			//Move first 4 characters to the end of the string
			String firstPart = accountNumber.substring(0, 4);
			String secondPart = accountNumber.substring(4);
			String joinedString = secondPart + firstPart;

			//Replace A with 10, B with 11 and so on
			/**
			 * A = 10,
			 * B = 11
			 * 
			 * (B - A) = 1
			 * 
			 * B = A + (B - A)
			 * 
			 * Difference is automatically calculated using char subtraction...
			 * So we can find (B-A) part by subtracting characters
			 * 
			 * We can then,
			 * B = 10 + (B-A)
			 * For any alphabet
			 */
			String interpretedNumber = "";
			for(int i = 0; i < joinedString.length(); i++) {
				char currentChar = joinedString.charAt(i);
				if(Character.isDigit(currentChar)) {
					interpretedNumber += currentChar;
				}
				else if(Character.isLetter(currentChar)){
					interpretedNumber += String.valueOf(10 + (currentChar - 'A'));
				}
				else{
					//For invalid characters found
					return false;
				}
			}
			if(Long.parseLong(interpretedNumber) % 11 == 1)
				return true;
			else
				return false;
		}
	}
}
