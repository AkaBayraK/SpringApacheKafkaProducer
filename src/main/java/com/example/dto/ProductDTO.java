package com.example.dto;

public class ProductDTO {

    public String title;
    public String description;
    public String color;
    public int price;
    public boolean isInStock;
    
	public ProductDTO(String title, String description, String color, int price, boolean isInStock) {
		this.title = title;
		this.description = description;
		this.color = color;
		this.price = price;
		this.isInStock = isInStock;
	}
    

}
