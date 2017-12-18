package com.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.store.data.BrandDiscountMapper;
import com.store.data.CategoryMapper;
import com.store.vo.Brand;
import com.store.vo.Category;
import com.store.vo.Inventory;
import com.store.vo.Product;

public class CalculateDiscount {

	private static final String COMMA_DELIMITER = ",";

	static CategoryMapper categoryMapper = new CategoryMapper();
	static BrandDiscountMapper brandDiscountMapper = new BrandDiscountMapper();
	static Inventory inventory;

	private static void dataSetup() {

		categoryMapper.setupCategory();
		brandDiscountMapper.setupBrand();
	}

	private static Brand getBrand(String brandName) {
		// BrandDiscountMapper brandDiscountMapper = new BrandDiscountMapper();
		Map<String, Brand> allBrands = brandDiscountMapper.getBrandMap();
		return allBrands.get(brandName);
	}

	private static Category getCategory(String categoryName) {
		// CategoryMapper categoryMapper = new CategoryMapper();
		Map<String, Category> allCategoris = categoryMapper.getCategoryMap();
		return allCategoris.get(categoryName);
	}

	private static Product getProdct(String prodId) {
		System.out.println("product id to get::" + prodId);
		// Inventory inventory = new Inventory();
		List<Product> products = inventory.getProducts();
		Product selectedProduct = null;
		for (Product product : products) {
			if (product.getId() == Integer.valueOf(prodId)) {
				selectedProduct = product;
			}
		}
		return selectedProduct;
	}

	private static void readCSVAndSetupInventory() {
		BufferedReader br = null;
		try {
			// Reading the csv file
			br = new BufferedReader(new FileReader("C:/Inventory.txt"));

			inventory = new Inventory();
			List<Product> products = new ArrayList<Product>();

			String line = "";

			while ((line = br.readLine()) != null) {
				String[] inventoryDetails = line.split(COMMA_DELIMITER);

				if (inventoryDetails.length > 0) {

					Integer prodId = Integer.parseInt(inventoryDetails[0]);
					String brandName = inventoryDetails[1];
					String categoryName = inventoryDetails[2];
					int price = Integer.parseInt(inventoryDetails[3]);

					Product product = new Product(prodId, CalculateDiscount.getBrand(brandName),
							CalculateDiscount.getCategory(categoryName), price);

					products.add(product);
				}
			}

			inventory.setProducts(products);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ie) {
				System.out.println("Error occured while closing the BufferedReader");
				ie.printStackTrace();
			}
		}

	}

	private static int calculateDiscount(String[] selectedProductIDs) {

		int totalPrice = 0;
		int discountedPrice = 0;

		for (String selectedProdId : selectedProductIDs) {

			Product product = getProdct(selectedProdId);
			Brand brand = product.getBrand();
			System.out.println("brand:: " + brand);
			Category category = product.getCategory();
			System.out.println("category:: " + category);
			int highestDiscountPercentage = brand.getBrandDiscountPercentage() > category.getDiscount()
					? brand.getBrandDiscountPercentage()
					: category.getDiscount();
			System.out.println("getParentCategory:: " + category.getParentCategory());
			System.out.println("highestDiscountPercentage:: " + highestDiscountPercentage);

			while (category.getParentCategory() != null) {
				Category parentCategory = category.getParentCategory();
				highestDiscountPercentage = parentCategory.getDiscount() > highestDiscountPercentage
						? parentCategory.getDiscount()
						: highestDiscountPercentage;
				System.out.println("highestDiscountPercentage in while:: " + highestDiscountPercentage);
				category = category.getParentCategory();
			}
			if (0 != highestDiscountPercentage) {
				discountedPrice = (product.getPrice()) - (product.getPrice() * highestDiscountPercentage / 100);
				System.out.println("actual price:: " + product.getPrice() + "  discountedPrice:: " + discountedPrice);
			} else {
				discountedPrice = product.getPrice();
			}
			totalPrice = totalPrice + discountedPrice;
		}

		return totalPrice;

	}

	public static void main(String args[]) {
		System.out.println("main started");
		dataSetup();
		readCSVAndSetupInventory();
		System.out.println("data setup done..");
		System.out.println("Please enter comma separated ids of selected products. For example : 1,3,4");

		Scanner scanner = new Scanner(System.in);
		String line;
		String[] selectedProductIDs;
		line = scanner.nextLine();
		scanner.close();
		// separate all values by comma
		selectedProductIDs = line.split(",");

		int totalPrice = calculateDiscount(selectedProductIDs);

		System.out.println("totalPrice:: " + totalPrice);

	}

}
