package com.businessgame.model;

public class Bank {
	
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank [balance=" + balance + "]";
	}

	public Bank(int balance) {
		super();
		this.balance = balance;
	}	
}
