package com.util;

import com.game.AbstractBoardCell;
import com.game.Bank;
import com.game.Player;

public interface CellProcessor {
	Bank bank = Bank.getBankInstance() ;
	
	 void process(AbstractBoardCell boardCell  , Player player); 
}
