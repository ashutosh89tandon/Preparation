package com.util;

import java.util.Map;

import com.game.AbstractBoardCell;
import com.game.BusinessHouseBoard;
import com.game.Player;

public final class PlayGame {
	
	
	private static PlayGame playGame = null ;
	
	
	BusinessHouseBoard houseBoard ;
	
	
	private PlayGame() {
		houseBoard = new BusinessHouseBoard(); 
	}
	
	public static PlayGame getPlayGameInstance() {
		if(playGame ==null) {
			playGame = new PlayGame(); 
		}
		
		return playGame ; 
	}
	
	public void play(Player player , int move) {
		
		 Map<Integer,AbstractBoardCell> cellMap =  houseBoard.getCellMap() ; 
		 
		 int cellKey= player.getCellKey() ; 
		 cellKey = (cellKey+move)%cellMap.size() ; 
		 
		 cellKey = cellKey==0?1:cellKey ;
		 AbstractBoardCell boardCell = cellMap.get(cellKey) ; 
		 boardCell.process(player);
		 
		 player.setCellKey(cellKey);
	}
	
	

	
}
