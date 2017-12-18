package com.store.vo;

public class Category {
	
	private String categoryName;
	
	private int discount;
	
	private Category parentCategory;
	
	public Category( String categoryName, int discount,Category parentCategory ) {
		this.categoryName=categoryName;
		this.discount=discount;
		this.parentCategory= parentCategory;
	}
	


	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	  @Override
	    public String toString() {
	        return "Category [categoryName=" + categoryName + ", discount=" + discount + "]";
	    }
	
	

}
