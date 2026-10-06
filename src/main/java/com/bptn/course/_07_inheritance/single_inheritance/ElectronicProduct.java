package com.bptn.course._07_inheritance.single_inheritance;

public class ElectronicProduct extends Product {

	public ElectronicProduct(String productName, double price, boolean inStock, double rating) {
		super(productName, price, inStock, rating);
		System.out.println(this.getProductName());
		this.setProductName("test1");
		this.showTotal();
	}
	
	
	
}
