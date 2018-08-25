package com.util;

import com.game.AbstractBoardCell;
import com.game.Player;

public class JailCellProcessor implements CellProcessor {
	
	private static JailCellProcessor jailCellProcessor = null ;
	
    private JailCellProcessor() {
		
	}
	
	public static JailCellProcessor getInstance() {
		if(jailCellProcessor == null) {
			jailCellProcessor = new JailCellProcessor() ; 
		}
		
		return jailCellProcessor ; 
	}

	@Override
	public void process(AbstractBoardCell boardCell, Player player) {
		System.out.println("JailCellProcessor for player : "+player);
		//JailCell jailCell = (JailCell) boardCell;
		
		Long defaultAddAmount = bank.getDefaultAddAmount() ; 
		
		bank.addMoney();
		player.setTotalAmount(player.getTotalAmount()-defaultAddAmount);
	}

}
