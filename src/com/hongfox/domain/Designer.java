package com.hongfox.domain;

import com.hongfox.services.Status;

public class Designer extends Programmer {
	private double bonus;
	
	public Designer(int id, String name, int age, double salary,  Equitment equitment, Status status,double bonus) {
		super(id, name, age, salary, equitment, status);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String toString() {
		return getId()+"\t"+getName() + "\t" + getAge() + "\t" + getSalary() + "\t" + "设计师" + "\t" +super.getStatus().getName()+"\t"+ getBonus() + "\t\t" + getEquitment().getDescription();
	}
}
