package com.businessgame.handler;

import com.businessgame.model.Bank;
import com.businessgame.model.Player;

public class JailHandler implements EventHandler
{
	private Bank bank;
	private static final int FINE=150;
	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public JailHandler(Bank bank) {
		super();
		this.bank = bank;
	}

	public void handleEvent(Player player) {
		//Deducting amount from player's balance and adding that in bank's balance
		bank.setBalance(bank.getBalance()+FINE);
		player.setBalance(player.getBalance()-FINE);
	}

}
