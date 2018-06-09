package com.exercise.test;

import java.util.ArrayList;
import java.util.List;

import com.exercise.builder.JourneyBuilder;
import com.exercise.model.Journey;
import com.exercise.model.MetroCard;
import com.exercise.model.MetroStation;
import com.exercise.model.Strategy;

public class Test
{
	static List<MetroStation> stations=new ArrayList<MetroStation>();
	static Strategy forwardStrategy;
	static Strategy backwardStrategy;
	public static void main(String ar[])
	{
		createStations();
		createStrategies();
		updateStations();
		Journey journey=new Journey(stations.get(4));
		MetroCard card =new MetroCard(5, "Ashutosh", "44720", journey);
		
		JourneyBuilder builder=new JourneyBuilder(card);
		
		builder.startJourney();
		journey.setDestStation(stations.get(0));
		builder.endJourney();
	}
	
	private static void updateStations() 
	{
		for(int i=0;i<10;i++)
		{
			MetroStation station=stations.get(i);
			if(i+1<10)
			{
				station.setNextStation(stations.get(i+1));
				station.setNextStationStrategy(forwardStrategy);
				
			}
			if(i-1>=0)
			{
				station.setPreviousStation(stations.get(i-1));
				station.setPrevStationStrategy(backwardStrategy);
				
			}
		}
	}

	private static void createStrategies() 
	{
		forwardStrategy=new Strategy(5, "FORWARD");
		backwardStrategy=new Strategy(4, "BACKWARD");
	}

	private static void createStations()
	{
		for(int i=1;i<=10;i++)
		{
			MetroStation station=new MetroStation();
			station.setStattionId(i);
			stations.add(station);
		}
		
	}
}
