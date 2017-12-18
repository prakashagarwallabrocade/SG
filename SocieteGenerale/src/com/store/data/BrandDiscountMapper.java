package com.store.data;

import java.util.HashMap;
import java.util.Map;

import com.store.vo.Brand;

public class BrandDiscountMapper {
	
	
	/*
	 * This class sets up the category hierarchy.
	 */

	private Map<String,Brand> brandMap;

	public Map<String, Brand> getBrandMap() {
		return brandMap;
	}



	public void setBrandMap(Map<String, Brand> brandMap) {
		this.brandMap = brandMap;
	}



	public  final void setupBrand() {
		
	Brand wrangler= new Brand("Wrangler",10);
	Brand arrow= new Brand("Arrow",20);
	Brand veroModa= new Brand("Vero Moda",60);
	Brand ucb = new Brand("UCB",0);
	Brand adidas= new Brand("Adidas",5);
	Brand provogue= new Brand("Provogue",20);
	
		Map<String,Brand> brandMapL= new HashMap<String,Brand>();
		brandMapL.put("Wrangler",wrangler);
		brandMapL.put("Arrow",arrow);
		brandMapL.put("Vero Moda",veroModa);
		brandMapL.put("UCB",ucb);
		brandMapL.put("Adidas",adidas);
		brandMapL.put("Provogue",provogue);
		brandMap=brandMapL; 
		
	}

}
