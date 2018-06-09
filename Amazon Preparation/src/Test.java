import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Test 
{
	public static void main(String ar[])
	{
		String sweet=null;
		String mainSweet=null;
		int counter=0;
		int mainCounter=0;
		String[] arr={"Laddu","Imarti","Imarti","Gulab Jamun","Jalebi"};
		List<String> sweetList=Arrays.asList(arr);
		Collections.sort(sweetList);
		System.out.println(sweetList);
		for(String s: sweetList)
		{
			if(sweet==null)
			{
				sweet=s;
				mainSweet=s;
				counter++;
			}
			else if(sweet.equals(s))
			{
				counter++;
				
				if(mainCounter<counter)
				{
					mainSweet=sweet;
					mainCounter=counter;
				}
			}
			else
			{
				if(mainCounter<counter)
				{
					mainSweet=sweet;
					mainCounter=counter;
				}
				counter=1;
				sweet=s;
			}
			
		}
		
		System.out.println("Sweet: "+mainSweet);
	}
}
