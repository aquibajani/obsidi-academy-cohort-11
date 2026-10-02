package com.bptn.course._05_oop_basics.payment_example;

public class Payment {
	
	// Data / Properties
	String accountHolderName;
	float accountBalance;
	
	// Constructor
	Payment(String accountHolderName, float accountBalance) {
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
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
	
}
