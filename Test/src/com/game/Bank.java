package com.game;

public class Bank {
   
	private static Bank bank=null;
	
	private Long totalAmount ; 
	private Long defaultAddAmount ;
	private Long defaultDeductAmount ;
	
	
	private Bank() {
		totalAmount = 5000L;
		defaultAddAmount = 150L;
		defaultDeductAmount = 200L ;
	}
	
	public void addMoney() {
		totalAmount = totalAmount+defaultAddAmount;
	}
	
	public void addMoney(Long addAmount) {
		totalAmount = totalAmount+addAmount;
	}
	
	public void deductMoney() {
		totalAmount = totalAmount-defaultDeductAmount ;
	}
	
	public void deductMoney(Long deductAmount) {
		totalAmount = totalAmount-deductAmount ;
	}
	
	public static Bank getBankInstance () {
		
		if(bank == null) {
			bank = new Bank() ;
		}
		
		return bank;
	}

	public Long getDefaultAddAmount() {
		return defaultAddAmount;
	}

	public void setDefaultAddAmount(Long defaultAddAmount) {
		this.defaultAddAmount = defaultAddAmount;
	}

	public Long getDefaultDeductAmount() {
		return defaultDeductAmount;
	}

	public void setDefaultDeductAmount(Long defaultDeductAmount) {
		this.defaultDeductAmount = defaultDeductAmount;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

}
