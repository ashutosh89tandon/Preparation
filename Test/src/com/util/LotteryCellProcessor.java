package com.util;

import com.game.AbstractBoardCell;
import com.game.Player;

public class LotteryCellProcessor implements CellProcessor {
	
	private static LotteryCellProcessor lotteryCellProcessor = null ;
	
    private LotteryCellProcessor() {
		
	}
    
	public static LotteryCellProcessor getInstance() {
		if(lotteryCellProcessor == null) {
			lotteryCellProcessor = new LotteryCellProcessor() ; 
		}
		
		return lotteryCellProcessor ; 
	}

	@Override
	public void process(AbstractBoardCell boardCell, Player player) {
	   System.out.println("LotteryCellProcessor for player : "+player);
       Long defaultDeductAmount = bank.getDefaultDeductAmount();
		
		bank.deductMoney();
		player.setTotalAmount(player.getTotalAmount()+defaultDeductAmount);
		
	}

}
