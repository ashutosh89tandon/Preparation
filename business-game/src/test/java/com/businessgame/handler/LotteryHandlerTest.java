package com.businessgame.handler;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.businessgame.event.parser.EventParser;
import com.businessgame.model.Bank;
import com.businessgame.model.Hotel;
import com.businessgame.model.Player;

public class LotteryHandlerTest {

	@Test
	public void eventHandlerTest() {
		Bank bank=new Bank(5000);
		Player player=new Player(0, 1000, new ArrayList<Hotel>(), 0);
		EventHandler handler=EventParser.getEventHandler("L", bank);
		handler.handleEvent(player);
		
		Assert.assertTrue(player.getBalance()==1200);
		Assert.assertTrue(bank.getBalance()==4800);
	}
	
	@Test
	public void eventHandlerNullTest() {
		Bank bank=new Bank(5000);
		Player player=new Player(0, 1000,new ArrayList<Hotel>(), 0);
		EventHandler handler=EventParser.getEventHandler(null, bank);
		handler.handleEvent(player);
		
		Assert.assertTrue(player.getBalance()==1000);
	}


}
