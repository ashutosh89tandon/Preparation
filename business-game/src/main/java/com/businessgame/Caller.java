package com.businessgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.businessgame.event.parser.EventParser;
import com.businessgame.handler.EventHandler;
import com.businessgame.handler.HotelHandler;
import com.businessgame.model.Bank;
import com.businessgame.model.Hotel;
import com.businessgame.model.HotelCategory;
import com.businessgame.model.Player;

public class Caller 
{
	public static void main(String[] args) throws IOException 
	{
		Bank bank=new Bank(5000);
		List<Hotel> hotelList=new ArrayList<Hotel>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Cells");
		String cells=br.readLine();
		String[] cellsArray=cells.split(",");
		
		System.out.println("Enter dice output");
		String diceOutput=br.readLine();
		String[] diceOutputArray=diceOutput.split(",");
		
		System.out.println("Enter number of players");
		int numberOfPlayers=Integer.parseInt(br.readLine());
		List<Player> players=new ArrayList<Player>();
		
		for(int i =0;i<numberOfPlayers;i++)
		{
			players.add(new Player(i, 1000, new ArrayList<Hotel>(),0,-1));
		}
		
		for(int i=0;i<diceOutputArray.length;i++)
		{
			Player player=players.get(i%numberOfPlayers);
			if(player.getChance()==10)
				continue;
			int currentPosition=(player.getLastPosition()+Integer.parseInt(diceOutputArray[i]))%cellsArray.length;
			player.setLastPosition(currentPosition);
			String cellValue=cellsArray[currentPosition];
			EventHandler handler=EventParser.getEventHandler(cellValue, bank);
			if(cellValue.equals("H"))
			{
				Hotel hotel=getHotel(hotelList,currentPosition%cellsArray.length);
				((HotelHandler)handler).setHotel(hotel);
			}
			
			handler.handleEvent(player);
			player.setChance(player.getChance()+1);
		}
		
		System.out.println("Bank Balance: "+bank.getBalance());
		for(Player player: players)
			System.out.println("Player "+player.getId()+" balance "+player.getBalance());
	}

	private static Hotel getHotel(List<Hotel> hotelList, int id) 
	{
		Hotel hotel=hotelList.stream().filter(h->h.getId()==id).findFirst().orElse(null);
		if(hotel==null)
		{
			hotel=new Hotel(id, null, HotelCategory.SILVER, false);
			hotelList.add(hotel);
		}
		
		return hotel;
	}
}
