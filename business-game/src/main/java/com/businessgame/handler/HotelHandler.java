package com.businessgame.handler;


import com.businessgame.model.Bank;
import com.businessgame.model.Hotel;
import com.businessgame.model.HotelCategory;
import com.businessgame.model.Player;

public class HotelHandler implements EventHandler
{
	private Bank bank;
	private Hotel hotel;
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public HotelHandler(Bank bank) {
		super();
		this.bank = bank;
	}
	
	public HotelHandler(Bank bank, Hotel hotel) {
		super();
		this.bank = bank;
		this.hotel = hotel;
	}

	public void handleEvent(Player player) 
	{
		if (hotel==null)
			return;
		
		if(!hotel.isHotelOwned())
		{
			buyHotel(player);
		}
		else if(hotel.isHotelOwned())
		{
			//If current user is the owner
			if(player.equals(hotel.getOwner()))
			{
				upgradeHotel(player);
			}
			else
			{
				rentHotel(player);
			}
		}
	}

	private void buyHotel(Player player) 
	{
		if(player.getBalance()>=HotelCategory.SILVER.getCost())
		{
			bank.setBalance(bank.getBalance()+HotelCategory.SILVER.getCost());
			player.setBalance(player.getBalance()-HotelCategory.SILVER.getCost());
			hotel.setOwner(player);
			hotel.setHotelOwned(true);
			player.getHotels().add(hotel);
		}
	}

	private void upgradeHotel(Player player) 
	{
		
		int upgradeMoney=0;
		HotelCategory upgradeCategory=hotel.getCategory();
		
		if(hotel.getCategory().equals(HotelCategory.SILVER))
		{
			upgradeMoney=HotelCategory.GOLD.getCost()-HotelCategory.SILVER.getCost();
			upgradeCategory=HotelCategory.GOLD;
		}
		else if(hotel.getCategory().equals(HotelCategory.GOLD))
		{
			upgradeMoney=HotelCategory.PLATINUM.getCost()-HotelCategory.GOLD.getCost();
			upgradeCategory=HotelCategory.PLATINUM;
		}
		
		if(player.getBalance()>=upgradeMoney)
		{
			player.setBalance(player.getBalance()-upgradeMoney);
			bank.setBalance(bank.getBalance()+upgradeMoney);
			hotel.setCategory(upgradeCategory);
		}
	}

	private void rentHotel(Player player) 
	{
		player.setBalance(player.getBalance()-hotel.getCategory().getRent());
		hotel.getOwner().setBalance(hotel.getOwner().getBalance()+hotel.getCategory().getRent());
	}
}
