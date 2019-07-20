package expdedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solution {

	private static Map<Integer,Integer> positionMap=new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		solution obj=new solution();
		List<String> outputs=new ArrayList<>();
		try
		{
			int t=Integer.parseInt(br.readLine());
			for(int i=1;i<=t;i++)
			{
				int n=Integer.parseInt(br.readLine());
				String m[][]=new String[n][n];
				int k=0;
				for(int j=0;j<n;j++)
				{
					String line= br.readLine();
					String[] array=line.split(" ");	
					m[k]=array;
					k++;
				}
				positionMap.put(i, 0);
				outputs.add(obj.getMaxValuePaths(m, i));

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			br.close();
		}

		for(String output : outputs)
		{
			System.out.println(output);
		}

	}

	private  String getMaxValuePaths(String[][] m,int  position) {
		String output="";
		Map<Integer,Integer> pathMap=new HashMap<>();
		pathMap.put(0, 0);
		int index=m.length-1;

		compute(m,index,index,pathMap,0,position);

		output=positionMap.get(position)+" "+pathMap.get(positionMap.get(position));

		return output;

	}
	private void compute(String[][] m, int x, int y, Map<Integer, Integer> pathMap, int sum, int position) 
	{
		if(x<0 || y<0)
			return;
		if(x==0 && y==0)
		{
			if(positionMap.get(position)<=sum)
			{
				if(pathMap.get(sum)!=null)
					pathMap.put(sum, pathMap.get(sum)+1);
				else
					pathMap.put(sum, 1);
				positionMap.put(position, sum);
			}
			return;
		}

		if(m[x][y].equals("x"))
			return;
		int newSum=0;
		if(!m[x][y].equals("s"))
			newSum= sum+Integer.parseInt(m[x][y]);
		compute(m, x-1, y, pathMap, newSum,position);
		compute(m, x, y-1, pathMap, newSum,position);
		compute(m, x-1, y-1, pathMap, newSum,position);
	}

}


