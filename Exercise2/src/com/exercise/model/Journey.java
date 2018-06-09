package com.exercise.model;

import com.exercise.constants.Constants;

public class Journey 
{
	private MetroStation sourceStation;
	private MetroStation destStation;
	private String direction;
	
	public MetroStation getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(MetroStation sourceStation) {
		this.sourceStation = sourceStation;
	}
	public MetroStation getDestStation() {
		return destStation;
	}
	public void setDestStation(MetroStation destStation) {
		this.destStation = destStation;
		this.direction=getDirection(sourceStation, destStation);
		
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public Journey(MetroStation sourceStation) {
		super();
		this.sourceStation = sourceStation;
	}
	
	public Journey(MetroStation sourceStation, MetroStation destStation) {
		super();
		this.sourceStation = sourceStation;
		this.destStation = destStation;
		this.direction=getDirection(sourceStation,destStation);
	}
	
	public String getDirection(MetroStation sourceStation,MetroStation destStation)
	{
		if(sourceStation.getStattionId()<destStation.getStattionId())
		{
			return Constants.DIRECTION_ASC;
		}
		else
		{
			return Constants.DIRECTION_DESC;
		}
	}
	
	
}
