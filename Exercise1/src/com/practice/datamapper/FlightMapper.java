package com.practice.datamapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.practice.model.Criteria;
import com.practice.model.FlightDetail;

public class FlightMapper {
	
	public List<FlightDetail> getFlightDetails(Map<Criteria,Object> values) throws IOException
	{
		System.out.println("Start getFlightDetails");
		List<FlightDetail> flights=new ArrayList<>();
		
		File folder = new File("E:/Learning/Flight Details");
		File[] listOfFiles = folder.listFiles();
		
		System.out.println("Files List : "+listOfFiles.length);
		for(File file: listOfFiles)
		{
			FileReader reader=new FileReader(file);
			BufferedReader bf=new BufferedReader(reader);
			String line=bf.readLine();
			while(line!=null)
			{
				System.out.println("line:"+line);
				String[] details=line.split(",");
				System.out.println("detail: "+details);
				
				if(details!=null && details.length>0)
				{
					if(values.isEmpty() || values==null)
					{
						FlightDetail flightDetail=new FlightDetail();
						System.out.println("details[Criteria.FLIGHT_NUMBER.ordinal()] : "+details[Criteria.FLIGHT_NUMBER.ordinal()]);
						flightDetail.setFlightNumber(details[Criteria.FLIGHT_NUMBER.ordinal()]);
						flightDetail.setDepartureLoc(details[Criteria.DEP_LOC.ordinal()]);
						flightDetail.setArrivalLoc(details[Criteria.ARR_LOC.ordinal()]);
						flightDetail.setValidity(details[Criteria.VALIDITY.ordinal()]);
						flightDetail.setFlightTime(details[Criteria.FLIGHT_TIME.ordinal()]);
						flightDetail.setDuration(details[Criteria.DURATION.ordinal()]);
						System.out.println("details[Criteria.FARE.ordinal()] : "+details[Criteria.FARE.ordinal()]);
						flightDetail.setFare(Integer.parseInt(details[Criteria.FARE.ordinal()]));
						flights.add(flightDetail);
					}
					else
					{
						System.out.println("detail: "+details.toString());
						boolean criteriaMatch=true;
						for(Entry<Criteria,Object> criteriaEntry:values.entrySet())
						{
							System.out.println("details[criteriaEntry.getKey().ordinal()] : "+details[criteriaEntry.getKey().ordinal()]);
							System.out.println("criteriaEntry.getValue().toString() :"+criteriaEntry.getValue().toString());
							if(!details[criteriaEntry.getKey().ordinal()].equals(criteriaEntry.getValue().toString()))
							{
								criteriaMatch=false;
								break;
							}
						}
						
						if(criteriaMatch)
						{
							FlightDetail flightDetail=new FlightDetail();
							flightDetail.setFlightNumber(details[Criteria.FLIGHT_NUMBER.ordinal()]);
							flightDetail.setDepartureLoc(details[Criteria.DEP_LOC.ordinal()]);
							flightDetail.setArrivalLoc(details[Criteria.ARR_LOC.ordinal()]);
							flightDetail.setValidity(details[Criteria.VALIDITY.ordinal()]);
							flightDetail.setFlightTime(details[Criteria.FLIGHT_TIME.ordinal()]);
							flightDetail.setDuration(details[Criteria.DURATION.ordinal()]);
							flightDetail.setFare(Integer.parseInt(details[Criteria.FARE.ordinal()]));
							flights.add(flightDetail);
						}
					}
				}
				
				
				line=bf.readLine();
			}
			bf.close();
		}
		System.out.println("End getFlightDetails");
		return flights;
	}
}
