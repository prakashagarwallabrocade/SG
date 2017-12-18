package com.store.vo;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private List<Product> products= new ArrayList<Product>();

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	

}
