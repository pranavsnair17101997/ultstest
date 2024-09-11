package com.example.ults;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class StockHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantityChanged() {
		return quantityChanged;
	}
	public void setQuantityChanged(int quantityChanged) {
		this.quantityChanged = quantityChanged;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private long productId;
	private int quantityChanged;
	private String date;
	
}
