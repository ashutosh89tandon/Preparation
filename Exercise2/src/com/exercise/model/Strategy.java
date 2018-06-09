package com.exercise.model;

public class Strategy 
{
	private int fare;
	private String instanceDesc;
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getInstanceDesc() {
		return instanceDesc;
	}
	public void setInstanceDesc(String instanceDesc) {
		this.instanceDesc = instanceDesc;
	}
	public Strategy(int fare, String instanceDesc) {
		super();
		this.fare = fare;
		this.instanceDesc = instanceDesc;
	}
	
	
	
}
