package com.exercise.model;

public class MetroStation 
{
	private int stattionId;
	private MetroStation previousStation;
	private MetroStation nextStation;
	private Strategy prevStationStrategy;
	private Strategy nextStationStrategy;
	public int getStattionId() {
		return stattionId;
	}
	public void setStattionId(int stattionId) {
		this.stattionId = stattionId;
	}
	public MetroStation getPreviousStation() {
		return previousStation;
	}
	public void setPreviousStation(MetroStation previousStation) {
		this.previousStation = previousStation;
	}
	public MetroStation getNextStation() {
		return nextStation;
	}
	public void setNextStation(MetroStation nextStation) {
		this.nextStation = nextStation;
	}
	public Strategy getPrevStationStrategy() {
		return prevStationStrategy;
	}
	public void setPrevStationStrategy(Strategy prevStationStrategy) {
		this.prevStationStrategy = prevStationStrategy;
	}
	public Strategy getNextStationStrategy() {
		return nextStationStrategy;
	}
	public void setNextStationStrategy(Strategy nextStationStrategy) {
		this.nextStationStrategy = nextStationStrategy;
	}
	public MetroStation(int stattionId, MetroStation previousStation,
			MetroStation nextStation, Strategy prevStationStrategy,
			Strategy nextStationStrategy) {
		super();
		this.stattionId = stattionId;
		this.previousStation = previousStation;
		this.nextStation = nextStation;
		this.prevStationStrategy = prevStationStrategy;
		this.nextStationStrategy = nextStationStrategy;
	}
	public MetroStation() {
		// TODO Auto-generated constructor stub
	}
	
	
}