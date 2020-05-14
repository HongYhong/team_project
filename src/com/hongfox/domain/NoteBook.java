package com.hongfox.domain;

public class NoteBook implements Equitment{
	private String model;
	private double price;
	
	
	
	public NoteBook() {
		super();
	}



	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}



	@Override
	public String getDescription() {
		return model + "(" + price + ")";
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
