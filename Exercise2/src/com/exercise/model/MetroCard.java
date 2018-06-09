package com.exercise.model;

public class MetroCard 
{
	private int balance;
	private String name;
	private String cardId;
	private	Journey journey;
	
	
	public Journey getJourney() {
		return journey;
	}
	
	public MetroCard(int balance, String name, String cardId, Journey journey) {
		super();
		this.balance = balance;
		this.name = name;
		this.cardId = cardId;
		this.journey = journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public MetroCard(int balance, String name, String cardId) {
		super();
		this.balance = balance;
		this.name = name;
		this.cardId = cardId;
	}
	
}
