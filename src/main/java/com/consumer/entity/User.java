package com.consumer.entity;


public class User {
	private int id;
	private double amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User(int id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", amount=" + amount + "]";
	}
	
	

}
