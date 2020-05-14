package com.hongfox.domain;

import com.hongfox.services.Status;

public class Architect extends Designer {
	private double stock;

	public Architect(int id, String name, int age, double salary, Equitment equitment, Status status, double bonus,
			double stock) {
		super(id, name, age, salary, equitment, status, bonus);
		this.stock = stock;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public String toString() {
		return getId()+"\t"+getName() + "\t" + getAge() + "\t" + getSalary() + "\t" + "架构师" + "\t" +super.getStatus().getName()+"\t" +getBonus()+"\t" +getStock() + "\t" + getEquitment().getDescription();
	}
}
