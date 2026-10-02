package com.bptn.course._05_oop_basics.cafe_revenue_calculator;

public class CafeCalculator {
	
	static double calculateItemRevenue(double pricePerItem, int numberOfItemsSold) {
		return pricePerItem * numberOfItemsSold;
	}
	
	static double calculateDailyTotalRevenue(double coffeeRevenue, double pastryRevenue) {
		return coffeeRevenue + pastryRevenue;
	}

    public static void main(String[] args) {

        // --- Step 1: Calculate revenue for each item type using our custom method ---
    	double coffeeRevenue = calculateItemRevenue(7.5, 100);
    	double pastryRevenue = calculateItemRevenue(13, 10);

        // --- Step 2: Calculate the total daily revenue using another custom method ---
    	double totalDailyRevenue = calculateDailyTotalRevenue(coffeeRevenue, pastryRevenue);

        // --- Step 3: Print out the results ---
    	System.out.println("Daily Coffee Revenue: $"+coffeeRevenue);
    	System.out.println("Daily Pastry Revenue: $"+pastryRevenue);
    	System.out.println("Total Daily Revenue: $"+totalDailyRevenue);

    }
}