package com.businessgame.model;

import java.util.List;

public class Player 
{
	private int id;
	private int balance;
	private List<Hotel> hotels;
	private int chance;
	private int lastPosition;
	
	public int getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}


	public int getId() {
		return id;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public List<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	

	public Player(int id, int balance, List<Hotel> hotels, int chance,int lastPosition) {
		super();
		this.id = id;
		this.balance = balance;
		this.hotels = hotels;
		this.chance = chance;
		this.lastPosition=lastPosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", balance=" + balance + ", hotelId=" + hotels + ", chance=" + chance + "]";
	}
	
}
