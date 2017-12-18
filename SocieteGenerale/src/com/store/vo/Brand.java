package com.store.vo;

public class Brand {
	
	private String brandName;
	private int brandDiscountPercentage;
	
	
	public Brand(String brandName,int brandDiscountPercentage) {
		this.brandDiscountPercentage=brandDiscountPercentage;
		this.brandName= brandName;
	}
	

	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getBrandDiscountPercentage() {
		return brandDiscountPercentage;
	}
	public void setBrandDiscountPercentage(int brandDiscountPercentage) {
		this.brandDiscountPercentage = brandDiscountPercentage;
	}
	
	  @Override
	    public String toString() {
	        return "Brand [brandName=" + brandName + ", brandDiscountPercentage=" + brandDiscountPercentage + "]";
	    }

}
