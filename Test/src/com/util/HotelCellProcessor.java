package com.util;

import com.game.AbstractBoardCell;
import com.game.HotelCell;
import com.game.HotelTypeEnum;
import com.game.Player;

public class HotelCellProcessor implements CellProcessor {
	
	private static HotelCellProcessor hotelCellProcessor = null ;
	private HotelCellProcessor() {
		
	}
	
	public static HotelCellProcessor getInstance() {
		if(hotelCellProcessor == null) {
			hotelCellProcessor = new HotelCellProcessor() ; 
		}
		
		return hotelCellProcessor ; 
	}
  
	public void process(AbstractBoardCell boardCell  , Player player) {
		System.out.println("HotelCellProcessor for player : "+player);
		
		HotelCell hotelCell = (HotelCell) boardCell;
		Player owner = hotelCell.getOwner() ;
		HotelTypeEnum hotelType = hotelCell.getHotelType() ;
		Long totalAmount = player.getTotalAmount() ; 
		Long hotelTypeValue = Long.valueOf(HotelTypeEnum.getValue(hotelType));
		
		if(owner == null) {
			
			if(totalAmount>=hotelTypeValue) {
				bank.addMoney(hotelTypeValue);
				player.setTotalAmount((totalAmount-hotelTypeValue));
				hotelCell.setOwner(player);
			}
			
		}else if (owner.equals(player)) {
			
			HotelTypeEnum targetHotelType = HotelTypeEnum.nextUpgradeHotelType(hotelType);
			Long targetHotelTypeValue = Long.valueOf(HotelTypeEnum.getValue(hotelType));
			Long delta = targetHotelTypeValue-hotelTypeValue ;
			
			if(delta.longValue()>0L && totalAmount.longValue()>=delta.longValue()) {
				bank.addMoney(delta);
				player.setTotalAmount(totalAmount-delta);
				hotelCell.setHotelType(targetHotelType);
			}
			
			
		}else if(!owner.equals(player)) {
			Long hotelTypeRent = Long.valueOf(HotelTypeEnum.getRent(hotelType));
			
			if(totalAmount>=hotelTypeRent) {
				player.setTotalAmount((totalAmount-hotelTypeRent));
				owner.setTotalAmount(owner.getTotalAmount()+hotelTypeRent);
			}
		}
	}
}
