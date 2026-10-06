package com.bptn.course._07_inheritance.multi_level_inheritance;

public class ElectronicProduct extends Product {

	public ElectronicProduct(String productName, double price, boolean inStock, double rating) {
		super(productName, price, inStock, rating);
		System.out.println(this.getProductName());
		this.setProductName("test1");
		this.showTotal();
		
		// price -> protected in parent class Product
		System.out.println(this.price);
		
		// productName -> private in parent class Product
		// System.out.println(this.productName);
	}
	
	
	
}
