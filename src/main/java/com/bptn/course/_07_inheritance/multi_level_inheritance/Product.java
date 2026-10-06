package com.bptn.course._07_inheritance.multi_level_inheritance;

public class Product {
	
	private String productName;
	protected double price;
	boolean inStock;
	public double rating;
	
	public Product(String productName, double price, boolean inStock, double rating) {
		this.productName = productName;
		this.price = price;
		this.inStock = inStock;
		this.rating = rating;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		if(productName.isEmpty()) {
			System.out.print("Product Name cannot be empty!");
		} else {
			this.productName = productName;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", inStock=" + inStock + ", rating="
				+ rating + "]";
	}
	
	private void calculateTotal() {
		System.out.print("You are now seeing the cart!");
	}
	
	public void showTotal() {
		this.calculateTotal();
	}
	
	
}
