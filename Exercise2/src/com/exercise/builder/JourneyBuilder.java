package com.exercise.builder;

import com.exercise.constants.Constants;
import com.exercise.model.MetroCard;
import com.exercise.model.MetroStation;

public class JourneyBuilder 
{
	MetroCard card;
	public int calculateFare()
	{
		MetroStation sourceStation=card.getJourney().getSourceStation();
		MetroStation destStation=card.getJourney().getDestStation();
		
		int fare =0;
		if(destStation.getStattionId()==sourceStation.getStattionId())
		{
			fare=sourceStation.getNextStationStrategy().getFare();
			return fare;
		}
		
		while(true)
		{
			if(card.getJourney().getDirection().equals(Constants.DIRECTION_ASC))
			{
				fare+=sourceStation.getNextStationStrategy().getFare();
				sourceStation=sourceStation.getNextStation();
			}
			else
			{
				fare+=sourceStation.getPrevStationStrategy().getFare();
				sourceStation=sourceStation.getPreviousStation();
			}
			
			if(sourceStation.getStattionId()==destStation.getStattionId())
				break;
		}
		
		System.out.println("Total fare: "+fare);
		return fare;
	}
	
	public boolean validateMinimumFare()
	{
		boolean validate=true;
		
		if(card.getJourney().getSourceStation().getNextStation()!=null)
		{
			if(card.getBalance()<card.getJourney().getSourceStation().getNextStationStrategy().getFare())
				validate=false;
		}
		if(card.getJourney().getSourceStation().getPreviousStation()!=null)
		{
			if(card.getBalance()<card.getJourney().getSourceStation().getPrevStationStrategy().getFare())
				validate=false;
		}
		
		return validate;
	}
	
	public JourneyBuilder(MetroCard card) {
		super();
		this.card = card;
	}

	public MetroCard getCard() {
		return card;
	}

	public void setCard(MetroCard card) {
		this.card = card;
	}

	public void startJourney()
	{
		if(!validateMinimumFare())
		{
			System.out.println("Minimum balance not available in card. Cannot Start!!");
			return;
		}
		
		System.out.println("Journey Started");
	}
	
	public void endJourney()
	{
		if(card.getBalance()<calculateFare())
		{
			System.out.println("Minimum balance not available in card. Cannot Exit!!");
			return;
		}
		
		System.out.println("Journey ended");
	}
	
}
