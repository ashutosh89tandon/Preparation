package com.practice.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.practice.datamapper.FlightMapper;
import com.practice.model.Criteria;
import com.practice.model.FlightDetail;

public class FlightDetailsTest 
{
	@SuppressWarnings("resource")
	public static void main(String[] a)
	{
		Criteria[] criterias=Criteria.values();
		Map<Criteria,Object> criteriaMap=new HashMap<>();
		for(int i=0; i<criterias.length;i++)
		{
			System.out.println("Enter : "+criterias[i]);
			Scanner scanner=new Scanner(System.in);
			String value=scanner.nextLine();
			
			if(value!=null && !value.isEmpty())
			{
				criteriaMap.put(criterias[i], value);
			
			}
		}
		System.out.println("MAP : "+criteriaMap);
		List<FlightDetail> details;
		try 
		{
			details = new FlightMapper().getFlightDetails(criteriaMap);


			if(details.isEmpty())
			{
				System.out.println("Sorry no fliht found.");
			}
			else
			{
				for(FlightDetail flight: details)
				{
					System.out.println("Name : "+flight.getFlightNumber()+" Fare : "+flight.getFare());
				}
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
