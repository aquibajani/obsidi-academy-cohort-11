package com.bptn.course._02_hello_world;

import java.util.Scanner;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input a number: ");
		int number = scanner.nextInt();
		System.out.println("The factorial of " + number + " is: " + factorial(number));
		
	}
	// The method below is a non-recursive method that returns the factorial of the number provided by the user
	//The user's input is passed as an argument to the function
	public static int factorial(int num) {
		int fact = 1;
		// The users input is used to create a for loops that decrements the user's input by one after multiplying it against another variable "fact"
		//fact stores the product of the user's input and every other number till the loop hits 0;
		for (int i = num; i>0; i--) {
			fact *= i;
		}
		return fact;
	}

}