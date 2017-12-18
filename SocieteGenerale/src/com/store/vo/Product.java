package com.store.vo;

public class Product {
	
	private int id;
	
	private int price;
	
	private Brand brand;	
	
	private Category category;
	
	public Product(int id,Brand brand,Category category,int price) {
		this.id=id;
		this.brand=brand;
		this.category= category;
		this.price= price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

}
