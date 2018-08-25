package com.game;

public class EmptyCell extends AbstractBoardCell {
   
	public EmptyCell() {
		 identifier = "empty";
	}

	@Override
	public void process(Player player) {
		// do nothing
		
	}
}
