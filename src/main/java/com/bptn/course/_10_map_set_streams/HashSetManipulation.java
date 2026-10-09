package com.bptn.course._10_map_set_streams;

import java.util.HashSet;
import java.util.Set;

public class HashSetManipulation {
	public static void main(String[] args) {
		// Create a HashSet and populate it with initial values
		HashSet<String> mySet = new HashSet<String>();
		mySet.add("A");
		mySet.add("B");
		mySet.add("C");
		
		// Print the size of the set
		System.out.println("The size of the set is : "+mySet.size());

		// Use for loop to print the values in the set
		for(String s : mySet) {
			System.out.print(s+"\t");
		}

		// Use add() method to add a new value to the set
		System.out.println("");
		System.out.println(mySet.add("D"));
		System.out.println(mySet);

		// Use remove() method to remove a value from the set
		System.out.println(mySet.remove("C"));
		System.out.println(mySet);

		// Use contains() method to check if the value "C" exists in the set
		System.out.println(mySet.contains("A"));
		
	}
}
