package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.game.Bank;
import com.game.Player;
import com.util.PlayGame;

public class Client {

	public static void main(String[] args) {

		Random random = new Random();
	
		
		final int rounds = 3 ;
		@SuppressWarnings("serial")
		final List<Player> playerList = new ArrayList<Player>() {{
			
			add(new Player()); //player 1
			add(new Player()); //player 2
			
		}};
		
		final PlayGame playGame= PlayGame.getPlayGameInstance() ; 
	
		for(int i = 0 ;i<rounds;i++) {
			
		
			int move = random.nextInt((6-1)+1)+1;
			
			for(Player p : playerList) {
				
				System.out.println(p+" Move : "+move);
				
				if(p.isValidPlayer()) {
				  playGame.play(p,move);
				}else {
				  System.out.println(p+" could not play further");
				}
				
			}
			
		}
		
		
		System.out.println(playerList);  
		System.out.println("Bank amount : "+Bank.getBankInstance().getTotalAmount());  
	
	}

}
