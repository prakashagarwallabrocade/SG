package com.store.data;

import java.util.HashMap;
import java.util.Map;

import com.store.vo.Category;

public class CategoryMapper {
	
	/*
	 * This class sets up the category hierarchy.
	 */

	private Map<String,Category> categoryMap;
	
	public Map<String, Category> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<String, Category> categoryMap) {
		this.categoryMap = categoryMap;
	}

	public final void setupCategory() {
		
		Category mensWear= new Category("Men's wear", 0, null);
		Category shirts=new Category("Shirts", 0, mensWear);
		Category trousers=new Category("Trousers", 0, mensWear);
		Category casuals =new Category("Casuals", 30, trousers);
		Category jeans=new Category("Jeans", 20, trousers);
		
		Category womensWear=new Category("Women's wear", 50, null);
		Category dresses=new Category("Dresses", 0, womensWear);
		Category footwear=new Category("Footwear", 0, womensWear);
		
		Map<String,Category> categoryMapL= new HashMap<String,Category>();
		categoryMapL.put("Men's wear",mensWear);
		categoryMapL.put("Shirts",shirts);
		categoryMapL.put("Trousers",trousers);
		categoryMapL.put("Casuals",casuals);
		categoryMapL.put("Jeans",jeans);
		categoryMapL.put("Women's wear",womensWear);
		categoryMapL.put("Dresses",dresses);
		categoryMapL.put("Footwear",footwear);
		
		categoryMap= categoryMapL;
		
		
	}
}
