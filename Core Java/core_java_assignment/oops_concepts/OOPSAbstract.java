package oops_concepts;

/**
 * Abstraction -
 * 1. abstract keyword and abstract class
 * 2. Inheriting a abstract class
 * 3. abstract method
 */

abstract class Bank {
    private String bankName;
    private String branchLocation;

    public Bank(String bankName, String branchLocation) {
        this.bankName = bankName;
        this.branchLocation = branchLocation;
    }

    // Abstract method for processing transactions
    public abstract void processTransaction(double amount);

    // Concrete method to display bank details
    public void displayDetails() {
    	System.out.println("Bank Name: " + bankName);
    	System.out.println("Branch Location: " + branchLocation + "\n");
   }
}

// Subclass 1 - SavingsAccount
class SavingsAccount extends Bank {
     private double balance;

     public SavingsAccount(String bankName, String branchLocation, double balance) {
         super(bankName, branchLocation);
         this.balance = balance;
      }

      @Override  
      public void processTransaction(double amount) {   
          System.out.println("Processing savings account transaction...");
          balance += amount;
          System.out.println("Amount " + amount +  " deposited.\nNew balance: " + balance + ".\n");
      } 
}

// Subclass 2 - LoanAccount
class LoanAccount extends Bank {
   private double loanAmount;
   

   public LoanAccount(String bankName, String branchLocation, double loanAmount) { 
       super(bankName,branchLocation); 
       this.loanAmount = loanAmount; 
   }

   @Override  
   public void processTransaction(double amount) {  
       System.out.println("Processing loan account transaction...");   
       loanAmount -= amount;
       System.out.println("Monthly EMI " + amount +  " received.\nRemaining Loan Amount: " + loanAmount + " with 10.65% interest.\n");
   }    
} 

public class OOPSAbstract {
	
	public static void main(String[] args) {

		Bank savingsAcct = new SavingsAccount("ABC Bank", "New York", 5000.00);
	 	savingsAcct.processTransaction(100);
	   	savingsAcct.displayDetails();

	    Bank loanAcct = new LoanAccount("XYZ Bank", "London", 100000.00);
	  	loanAcct.processTransaction(5000); 
	 	loanAcct.displayDetails(); 
	}

}
