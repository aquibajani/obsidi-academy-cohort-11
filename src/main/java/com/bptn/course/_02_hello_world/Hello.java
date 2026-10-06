package com.bptn.course._02_hello_world;

import com.bptn.course._05_oop_basics.payment_example.Payment;

public class Hello {
	
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        Payment p = new Payment("test", 100.00f);
        
        System.out.print(Payment.INTEREST_RATE);
    }
}