import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class AirtelTest {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(CountLETTER("aZ$6"));
		System.out.println(CountDIGIT("aZ$6"));
		AirtelTest test=new AirtelTest();
		int x[]={2,3,1,3,5};
		int y[]={5,6,2,5,1};
		int[][] array=test.solve(5,x,y);
		System.out.println(array);
		String[] S={"john","john","michael","roma","michael"};
		String[] arrayS=solve(5, S);
		System.out.println(arrayS);
				
		br.close();
	}
	
	private int[][] solve(int N, int[] X, int[] Y) {
		List<Point> list=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			list.add(new Point(X[i], Y[i]));
		}
		
		Comparator<Point> comparator= (p1,p2)->{
			if(p1.x < p2.x)
				return -1;
			else if(p1.x > p2.x)
				return 1;
			else
				return p2.y.compareTo(p1.y);
			
		};
		AtomicInteger i=new AtomicInteger(0);
		int array[][]=new int[N][2];
		list.stream().sorted(comparator).forEach(p->{
			array[i.get()][0]=p.x;
			array[i.get()][1]=p.y;
			i.getAndIncrement();
		});
		
		return array;
	}

	static int CountLETTER(String str) {
	    if(str==null || str.isEmpty())
	    	return 0;
	    int count =0;
	    for(int i=0;i<str.length();i++)
	    {
	    	char ch=str.charAt(i);
	    	if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
	    	{
	    		count++;
	    	}
	    }
	    return count;
    }
	
	 static int CountDIGIT(String str) {
		 if(str==null || str.isEmpty())
		    	return 0;
		    int count =0;
		    for(int i=0;i<str.length();i++)
		    {
		    	char ch=str.charAt(i);
		    	if(ch>='0' && ch<='9')
		    	{
		    		count++;
		    	}
		    }
		    return count;

	    }
	 
	 
	 class Point{
		 Integer x;
		 Integer y;
		 public Point (int x, int y){
			 this.x=x;
			 this.y=y;
		 }
	 }
	 
	 
	 static String[] solve(int N, String[] S){
	       
		String[] array=new String[N];
		if(N==0)
			return array;
		Map<String,Boolean> map=new HashMap<>();
		AtomicInteger i=new AtomicInteger(0);
		Arrays.asList(S).stream().forEach(s->{
			if(map.get(s)!=null)
				array[i.get()]="YES";
			else
			{
				map.put(s, true);
				array[i.get()]="NO";
			}
			
			i.incrementAndGet();
				
		});
		
		return array;
	 }
	 
	 static int find_rank(String X)
	 {
		 TreeSet<String> set=new TreeSet<>();
	     for(int i=0;i<X.length();i++)
	     {
	    	 for(int j=1;j<=X.length();j++)
	    	 {
	    		 set.add(X.substring(i,j));
	    	 }
	     }
	     
	    int i=1; 
	   for(String s : set)
	   {
		   if(s.equals(X))
			   return i;
		   else
			   i++;
	   }
	   
	   return i;
	     
	 }
	 
	 
	 static String solve(int N) 
	 {
	      for(int i=2;i<N;i++)
	      {
	    	  if((N % i ==0 )&&  ((N /i) >1))
	    		  return "YES";
	      }
	      
	      return "NO";
	 }
	 
}
