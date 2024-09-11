package com.example.ults;


public class Product {

	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	public int getMinStockThreshold() {
		return minStockThreshold;
	}
	public void setMinStockThreshold(int minStockThreshold) {
		this.minStockThreshold = minStockThreshold;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private String name;
	private int currentStock;
	private int minStockThreshold;
	private String category;
	
}
