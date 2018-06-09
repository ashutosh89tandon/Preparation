import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example6 
{
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String line=reader.readLine();
		String[] array=line.split(",");
		printString(array);
		
	}

	private static void printString(String[] array) 
	{
		int count=0;
		for(int i=0;i<array.length;i++)
		{
			if(array[i].endsWith(".start"))
			{
				String str=array[i];
				for(int j=0;j<count;j++)
				{
					str="\t"+str;
					
				}
				System.out.println(str.replaceAll(".start", ""));
				count++;
			}
			else if(array[i].endsWith(".end"))
			{	
				count--;
			}
		}
		
	}
}
