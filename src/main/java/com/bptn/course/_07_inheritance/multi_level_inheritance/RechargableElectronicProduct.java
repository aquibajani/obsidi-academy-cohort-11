package com.bptn.course._07_inheritance.multi_level_inheritance;

public class RechargableElectronicProduct extends ElectronicProduct {

	public RechargableElectronicProduct(String productName, double price, boolean inStock, double rating) {
		super(productName, price, inStock, rating);
		
		// price -> protected in parent's parent class ElectronicProduct -> Product
		System.out.println(this.price);
		
		// productName -> private in parent class Product
		// System.out.println(this.productName);
	}

}
