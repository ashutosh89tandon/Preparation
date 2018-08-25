package com.game;


import com.util.HotelCellProcessor;

public class HotelCell extends AbstractBoardCell {
	
	private HotelTypeEnum hotelType ;
	private Player owner; 
	
	public HotelCell() {
		
		 identifier = "hotel";
		 hotelType = HotelTypeEnum.SILVER ;
		 owner = null ;
		 this.cellProcessor = HotelCellProcessor.getInstance()  ; 
	}
	

	public HotelTypeEnum getHotelType() {
		return hotelType;
	}

	public void setHotelType(HotelTypeEnum hotelType) {
		this.hotelType = hotelType;
	}


	public Player getOwner() {
		return owner;
	}


	public void setOwner(Player owner) {
		this.owner = owner;
	}


	@Override
	public void process(Player player) {
		cellProcessor.process(this, player);
	}


	
	

}
