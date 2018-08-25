package com.businessgame.handler;

import com.businessgame.model.Player;

public class DefaultHandler implements EventHandler
{
	@Override
	public void handleEvent(Player player) 
	{
		System.out.println("Do nothing!!");
	}
	
}
