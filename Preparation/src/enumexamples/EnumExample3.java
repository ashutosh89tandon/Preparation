package enumexamples;

public class EnumExample3 {
	
	enum Season
	{
		WINTER(10,"Winter"),AUTUMN(20,"Autumn"),SPRING(30,"Spring"),SUMMER(40,"Summer");
		
		int value;
		String name;
		Season(int value, String name)
		{
			this.value=value;
			this.name=name;
		}
		
		int getValue()
		{
			return value;
		}
		void setValue(int value)
		{
			this.value=value;		
		}
		
		String getName()
		{
			return name;
		}
		void setName(String name)
		{
			this.name=name;
		}
	}
	
	public static void main(String a[])
	{
		for(Season s : Season.values())
		{
			System.out.println("Value : "+s.getValue()+" Name : "+s.getName());
		}
	}
}
