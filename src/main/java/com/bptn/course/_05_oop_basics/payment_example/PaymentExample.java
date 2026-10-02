package com.bptn.course._05_oop_basics.payment_example;

public class PaymentExample {
	public static void main(String[] args) {
		Payment creditPayment = new Payment("Jane Doe", 5000.00f);
		Payment debitPayment = new Payment("Test User", 1000.00f);
		
		creditPayment.checkDetails();
		
		debitPayment.makePayment(50);
		
		Payment.showInterest();
		Payment.showCount();
	}
}