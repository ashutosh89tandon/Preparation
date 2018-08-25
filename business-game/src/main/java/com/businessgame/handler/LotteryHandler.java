package com.businessgame.handler;

import com.businessgame.model.Bank;
import com.businessgame.model.Player;

public class LotteryHandler implements EventHandler
{

	private Bank bank;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public LotteryHandler(Bank bank) {
		super();
		this.bank = bank;
	}

	public void handleEvent(Player player) {
		//Deducting amount from bank's balance and adding that in player's balance
		bank.setBalance(bank.getBalance()-200);
		player.setBalance(player.getBalance()+200);

	}

}
