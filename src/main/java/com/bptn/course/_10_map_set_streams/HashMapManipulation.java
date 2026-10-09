package com.bptn.course._10_map_set_streams;

import java.util.HashMap;
import java.util.Map;

public class HashMapManipulation {
	public static void main(String[] args) {
		// Create a HashMap and populate it with initial key-value pairs
		HashMap<String,Integer> map = new HashMap<>();
    map.put("A",1);
    map.put("B",2);
    map.put("C",3);

		// Print the size of the map
		System.out.println("Map size: " + map.size());

		// Use a for-each loop to print the key-value pairs in the map
		for(Map.Entry<String,Integer> entry : map.entrySet()){
      System.out.println("Key : "+ entry.getKey() + "\t\t|\tValue : "+ entry.getValue());
    }

		// Use get() method to get the value of key "A"
    System.out.println("Value of key 'A': " + map.get("A")); 

    // use put() method to add a new key-value pair to the map
		map.put("D", 4);
    System.out.println("Map after adding a new key-value pair: "+map);

		// Use the containsKey() method to check if the key "C" exists in the map
    System.out.println(map.containsKey("C"));

	}
}
