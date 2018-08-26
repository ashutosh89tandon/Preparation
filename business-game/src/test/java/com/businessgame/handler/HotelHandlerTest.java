package com.businessgame.handler;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.businessgame.event.parser.EventParser;
import com.businessgame.model.Bank;
import com.businessgame.model.Hotel;
import com.businessgame.model.HotelCategory;
import com.businessgame.model.Player;

public class HotelHandlerTest {
	@Test
	public void eventHandlerTest() {
		Bank bank=new Bank(5000);
		Player player=new Player(0, 1000, new ArrayList<Hotel>(), 0,-1);
		Hotel hotel=new Hotel(0,null, HotelCategory.SILVER, false);
		EventHandler handler=EventParser.getEventHandler("H", bank);
		((HotelHandler)handler).setHotel(hotel);
		handler.handleEvent(player);
		Assert.assertTrue(player.getBalance()==800);
	}
}
