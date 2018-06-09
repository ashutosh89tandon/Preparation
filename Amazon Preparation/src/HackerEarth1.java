
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerEarth1 
{
	public static void main(String args[])
	{
		long result=0;
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		try
		{
			String line =br.readLine();
			int numberOftestCases=Integer.parseInt(line);
			
			if(numberOftestCases<=0)
			{
				System.out.println(result);
				return;
			}
			for(int k=1;k<=numberOftestCases;k++)
			{
				int size=Integer.parseInt(br.readLine());
				String input=br.readLine();
				if(input ==null || input.isEmpty())
				{
					System.out.println(result);
					continue;
				}
				String[] array= input.split(" ");
				//System.out.println(Arrays.asList(array));
				result=findXor(array,size);
				System.out.println(result);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static long findXor(String[] array,int size) 
	{
		long result=0;
		int xor=0;
		
		for(int i=0;i<size;i++)
		{
			int freq=(i+1)*(size-i);
			if(freq%2==1)
				xor=xor^Integer.parseInt(array[i]);
		}
		
		result=result^xor;
		return result;
	}
}
