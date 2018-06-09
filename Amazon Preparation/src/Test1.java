import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String testCaseCount=br.readLine();
		if(testCaseCount==null || testCaseCount.isEmpty())
			return;
		int t=Integer.parseInt(testCaseCount);
		String line=br.readLine();
		if(line==null || line.isEmpty())
			return;
		
		printNumbers(t,line.split(" "));
		
	}

	private static void printNumbers(int t, String[] split) 
	{
		for(int i=0;i<t;i++)
		{
			for(int k=1;k<=Integer.parseInt(split[i]);k++)
			{
				if(k%3==0 && k%5==0)
				{
					System.out.println("FizzBuzz");
				}
				else if(k%3==0)
					System.out.println("Fizz");
				else if(k%5==0)
					System.out.println("Buzz");
				else
					System.out.println(k);
			}
		}
		
	}
}
