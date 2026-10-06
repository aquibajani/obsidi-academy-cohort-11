package com.bptn.course._07_exception_handling;
import java.util.Scanner;

public class ExceptionsDemo {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the index you want to access : ");
		int index = input.nextInt();
		
		try {
			System.out.println(arr[index]);
			try {
				System.out.println(arr[3]/0);
			} catch(ArithmeticException e) {
				System.out.println("Cannot divide by zero!");
			} catch(Exception e) {
				System.out.println("Something went wrong!");
			} 
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter a valid index!");
		} catch(Exception e) {
			System.out.println("Something went wrong!");
		} finally {
			input.close();
			System.out.println("Inside finally!");
		}
		
	}
	
}
