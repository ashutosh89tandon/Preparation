package com.game;


import com.util.LotteryCellProcessor;

public class LotteryCell extends AbstractBoardCell {
	
	public LotteryCell() {
		 identifier = "lottery";
		 this.cellProcessor = LotteryCellProcessor.getInstance()  ; 
	}

	@Override
	public void process(Player player) {
		cellProcessor.process(this, player);
	}

}
