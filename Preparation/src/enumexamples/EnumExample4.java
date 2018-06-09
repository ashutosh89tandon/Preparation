package enumexamples;

public class EnumExample4 {
 
	enum Days {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
	
	public static void main(String args[])
	{
		Days day=Days.SUNDAY;
		
		switch(day)
		{
		case MONDAY:
			System.out.println("Monday");
			break;
			
		default:
			System.out.println("Other day");
		}
	}
}
