package com.businessgame.event.parser;

import com.businessgame.handler.DefaultHandler;
import com.businessgame.handler.EventHandler;
import com.businessgame.handler.HotelHandler;
import com.businessgame.handler.JailHandler;
import com.businessgame.handler.LotteryHandler;
import com.businessgame.model.Bank;

public class EventParser 
{
	public static EventHandler getEventHandler(String command,Bank bank)
	{
		if(command==null)
			return new DefaultHandler(); 
		switch(command)
		{
			case "J": return new JailHandler(bank); 
			case "H": return new HotelHandler(bank); 
			case "L": return new LotteryHandler(bank); 
			case "E": return new DefaultHandler(); 
		}
		return new DefaultHandler(); 
	}
}
