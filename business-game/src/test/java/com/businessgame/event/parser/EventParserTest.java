package com.businessgame.event.parser;

import org.junit.Assert;
import org.junit.Test;

import com.businessgame.handler.EventHandler;
import com.businessgame.handler.HotelHandler;
import com.businessgame.handler.JailHandler;
import com.businessgame.handler.LotteryHandler;
import com.businessgame.model.Bank;

public class EventParserTest {

	@Test
	public void eventHandlerTest() {
		Bank bank=new Bank(5000);
		EventHandler handler=EventParser.getEventHandler("L", bank);
		
		Assert.assertTrue(handler instanceof LotteryHandler);
	}
	
	@Test
	public void eventHandlerTest1() {
		Bank bank=new Bank(5000);
		EventHandler handler=EventParser.getEventHandler("J", bank);
		
		Assert.assertTrue(handler instanceof JailHandler);
	}
	
	@Test
	public void eventHandlerTest2() {
		Bank bank=new Bank(5000);
		EventHandler handler=EventParser.getEventHandler("H", bank);
		
		Assert.assertTrue(handler instanceof HotelHandler);
	}
}
