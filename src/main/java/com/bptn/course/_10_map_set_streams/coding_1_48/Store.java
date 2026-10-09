package com.bptn.course._10_map_set_streams.coding_1_48;

import java.util.HashMap;
import java.util.Map;

public class Store {
    
    // create the map instance variable
	private HashMap<String, Integer> products = new HashMap<>();
    
    public Store() {
        // Initialize the products map with default values       
    	products.put("apple", 10);
    	products.put("banana", 5);
    	products.put("orange", 0);
    }

    public void purchase(String product, int quantity) throws OutOfStockException {
        // Check if the product is available in the store. Hint: Use the map
        if(!products.containsKey(product)) {
        	throw new OutOfStockException("Product is unavailable!");
        }
        // Check if there is enough stock for the desired quantity. Hint: Use the map
        //  System.out.print(products.get(product));
    	if (products.get(product)<quantity){
            // If not, throw an OutOfStockException with a message indicating the product is not available.
            throw new OutOfStockException("Product is out of stock!");
        }
    }
}
