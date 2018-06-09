package com.amazon.preparation;

import java.util.ArrayList;
import java.util.List;

public class Example9 {

	public static void main(String[] args) {
		
		List<String> strList=new ArrayList<String>();
		getUniqueStrings(strList, 3);
		System.out.println(strList);
		
	}

	private static void getUniqueStrings(List<String> strList, int count) 
	{
		getString(strList, count,"");
		
	}

	private static void getString(List<String> strList, int count, String str) 
	{
		if(count ==0)
		{
			strList.add(str);
			return;
		}
		if(str.length()==0)
		{
			getString(strList, count-1, str+0);
			getString(strList, count-1, str+1);
		}
		
		else
		{
			if(str.charAt(str.length()-1)=='1')
				getString(strList, count-1, str+0);
			else
			{
				getString(strList, count-1, str+0);
				getString(strList, count-1, str+1);
			}
		}
	}
	
	
}
