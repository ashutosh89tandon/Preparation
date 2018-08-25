package com.businessgame.handler;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.businessgame.event.parser.EventParser;
import com.businessgame.model.Bank;
import com.businessgame.model.Hotel;
import com.businessgame.model.Player;

public class JailHandlerTest {

	@Test
	public void handleEventTest()
	{
		Bank bank=new Bank(5000);
		Player player=new Player(0, 1000,new ArrayList<Hotel>(), 0);
		EventHandler handler=EventParser.getEventHandler("J", bank);
		handler.handleEvent(player);
		
		Assert.assertTrue(player.getBalance()==850);
	}
}
