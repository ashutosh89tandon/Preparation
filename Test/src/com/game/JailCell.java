package com.game;


import com.util.JailCellProcessor;

public class JailCell extends AbstractBoardCell {
	
  
	public JailCell() {
	   identifier = "jail";
	   this.cellProcessor = JailCellProcessor.getInstance()  ; 
   }

	@Override
	public void process(Player player) {
		cellProcessor.process(this, player);
   }
}
