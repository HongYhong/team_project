package com.hongfox.domain;

public class Printer implements Equitment {
	private String name;
	private String type;
	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Printer() {
		super();
	}
	@Override
	public String getDescription() {
		return name + "(" + type + ")";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
