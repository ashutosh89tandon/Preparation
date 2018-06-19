package com.prep;

public class AngleBetweenHourAndAngle 
{
	public static void main(String[] args) {
		
		String time="3:30:00";
		double angle=findAngle(time);
		System.out.println("Angle : "+angle);
	}

	private static double findAngle(String time) {
		
		String[] timeSplit=time.split(":");
		double hourAngle=(Double.valueOf(timeSplit[0])*30)+(.5 * Double.valueOf(timeSplit[1]));
		double  minuteAngle=6 * Double.valueOf(timeSplit[1]);
		
		return hourAngle-minuteAngle>minuteAngle-hourAngle?hourAngle-minuteAngle:minuteAngle-hourAngle;
	}
	
	
}
