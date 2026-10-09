package com.bptn.course._10_map_set_streams.coding_1_48;

public class Main {
	//Do not modify this code
		public static void main(String[] args) {
		    Store store = new Store();
		    try {
		        store.purchase("apple",8);
		        System.out.println("Purchase successful!");
		    } catch (OutOfStockException e) {
		        System.out.println(e.getMessage());
		    }
		}
	}

