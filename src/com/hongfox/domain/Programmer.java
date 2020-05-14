package com.hongfox.domain;

import com.hongfox.services.Status;

public class Programmer extends Employee {
	public Programmer(int id, String name, int age, double salary,Equitment equitment,Status status) {
		super(id, name, age, salary);
		this.equitment = equitment;
		this.status = status;
	}
	private int memberId;
	private Equitment equitment;
	private Status status = Status.FREE;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Equitment getEquitment() {
		return equitment;
	}
	public void setEquitment(Equitment equitment) {
		this.equitment = equitment;
	}
	public  Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String toString() {
		return super.toString() + "\t程序员\t" + status.getName() + "\t\t\t" + equitment.getDescription();
	}
	
}
