package com.bptn.course._05_oop_basics.payment_example;

public class Payment {
	
	// Data / Properties
	String accountHolderName;
	float accountBalance;
	public static final float INTEREST_RATE = 0.5f;
	static int count = 0;
	
	// Constructor
	public Payment(String accountHolderName, float accountBalance) {
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		count++;
	}
	
	// Static Method
	static void showInterest() {
		System.out.println("The interest rate is : "+INTEREST_RATE);
	}
	
	static void showCount() {
		System.out.println("The count is : "+count);
	}
	
	// Functionality / Behaviour
	void checkDetails() {
		System.out.println("This account belongs to "+this.accountHolderName+" and has a balance of "+ this.accountBalance);
	}
	
	boolean makePayment(float amount) {
		if(amount <= this.accountBalance) {
			System.out.println("Payment successful!");
			return true;
		} else {
			System.out.println("Payment failed!");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Payment [accountHolderName=" + accountHolderName + ", accountBalance=" + accountBalance + "]";
	}
	
	
	
}
