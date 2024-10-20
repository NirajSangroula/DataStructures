/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 4
Any and all work in this file is my own.
*/
package lab4;

public class NirajSangroulaLab4Q1 {

	public static void main(String[] args) {
		try {
			//Create bank account and perform various legal operations
			BankAccount ba1 = new BankAccount("GB821234", 5000);
			System.out.println(ba1);
			ba1.deposit(3000);
			System.out.println("Depositing 3000");
			System.out.println("Current balance : " + ba1.balance());
			System.out.println("Attempt withdraw 4500");
			ba1.withdraw(4500);
			System.out.println(ba1);
			

			//please comment statements that generate exception beforehand to see error outputs following them
			///**
			System.out.println("Attempt withdraw 6000");
			ba1.withdraw(6000); //Exception
			//**/
			
			//Try creating invalid bank account (Comment first statement to see error for second)
			BankAccount ba2 = new BankAccount("CA123456"); //Exception
			BankAccount ba3 = new BankAccount("GB821234", -1000); //Exception
			/**
			 * The above code is unreachable, because, withdraw 6000 stops program execution beforehand,
			 * so we need to comment that code to see, in this program
			 */
		}
		catch(BankException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

}
