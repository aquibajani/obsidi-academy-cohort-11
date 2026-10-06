package com.bptn.course._07_inheritance.coding_1_29_savings_account;

public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
       this.name = name;
       this.balance = balance;
    }

    //Step 1 and Step 2
    
    
    public static void main(String[] args) {

        // Code to test classes
        Account a1 = new Account("Illa", 500000);
        Account a2 = new Account("Javier", 10000);
        Account a3 = new Account("Javier", 50000);
        Account a4 = new Account("Illa", 50000);

        // toString Account
        System.out.println("toString() Account");
        System.out.println("a1 " + a1);
        System.out.println("a2 " + a2);

        System.out.println("\nequals() Account");
        // equals Account
        System.out.println("a2 and a3 are equal? " + a2.equals(a3));
        System.out.println("a1 and a4 are equal? " + a1.equals(a4));

        SavingsAccount sa1 = new SavingsAccount("Illa", 500000, 0.5);
        SavingsAccount sa2 = new SavingsAccount("Javier", 10000, 0.3);
        SavingsAccount sa3 = new SavingsAccount("John", 500000, 0.5);
        SavingsAccount sa4 = new SavingsAccount("Illa", 500000, 0.5);

        System.out.println("\ntoString() Savings account");
        // toString Savings account
        System.out.println("sa1 " + sa1);
        System.out.println("sa2 " + sa2);
        System.out.println("sa3 " + sa3);
        System.out.println("sa4 " + sa4);

        System.out.println("\nequals() Savings account");
        // equals Savings account
        System.out.println("sa1 and sa2 are equal? " + sa1.equals(sa2));
        System.out.println("sa1 and sa3 are equal? " + sa1.equals(sa3));
        System.out.println("sa2 and sa3 are equal? " + sa2.equals(sa3));
        System.out.println("sa1 and sa4 are equal? " + sa1.equals(sa4));
    }
}

