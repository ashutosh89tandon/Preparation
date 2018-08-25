package com.businessgame.model;

public class Hotel
{
	private int id;
	private Player owner;
	private HotelCategory category;
	private boolean isHotelOwned;
	

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player userId) {
		this.owner = userId;
	}

	public boolean isHotelOwned() {
		return isHotelOwned;
	}

	public void setHotelOwned(boolean isHotelOwned) {
		this.isHotelOwned = isHotelOwned;
	}

	public int getId() {
		return id;
	}
	
	public HotelCategory getCategory() {
		return category;
	}
	public void setCategory(HotelCategory category) {
		this.category = category;
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
		Hotel other = (Hotel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Hotel(int id, Player userId, HotelCategory category, boolean isHotelOwned) {
		super();
		this.id = id;
		this.owner = userId;
		this.category = category;
		this.isHotelOwned = isHotelOwned;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", owner=" + owner + ", category=" + category + ", isHotelOwned=" + isHotelOwned
				+ "]";
	}
	
	
}
