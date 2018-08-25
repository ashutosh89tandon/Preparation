package com.businessgame.model;

public enum HotelCategory 
{
	SILVER(200,50), GOLD(300,150), PLATINUM(500,300);
	
	private int cost;
	private int rent;
	
	public int getCost()
	{
		return cost;
	}
	
	public void setCost(int cost)
	{
		this.cost=cost;
	}
	
	public int getRent()
	{
		return rent;
	}
	
	public void setRent(int rent)
	{
		this.rent=rent;
	}

	private HotelCategory(int cost,int rent) {
		this.cost = cost;
		this.rent=rent;
	}
	
}
