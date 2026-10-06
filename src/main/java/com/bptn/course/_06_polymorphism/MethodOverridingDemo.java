package com.bptn.course._06_polymorphism;

import java.sql.Date;

class Product {
	
	private String productName;
	private double productPrice;
	private int quantity;
	
	
	
	public Product(String name, double price, int quantity) {
		this.productName = name;
		this.productPrice = price;
		this.quantity = quantity;
	}
	
	boolean checkQuantity(Product productName) {
		System.out.println("Parent method called!");
		if(this.getQuantity() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}

class PerishableProduct extends Product {
	
	String expiry;
	
	public PerishableProduct(String name, double price, int quantity, String expiry){
		super(name, price, quantity);
		this.expiry = expiry;
	}
	
	@Override
	boolean checkQuantity(Product productName) {
		// give an updated definition here
//		this.quantity = 100;
		super.checkQuantity(productName);
		System.out.println("Overriden method called!");
		return true;
	}
}


public class MethodOverridingDemo {
	public static void main(String[] args) {
		PerishableProduct p = new PerishableProduct("Yogurt", 14.99, 2, "2026-10-20");
		
		p.checkQuantity(p);
		
		Product p1 = new Product("Battery", 20.99, 5);
		p1.checkQuantity(p1);
	}
}