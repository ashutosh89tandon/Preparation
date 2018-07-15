package com.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GameOfBits {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int chances=Integer.parseInt(reader.readLine());
		
		if(chances>0)
		{
			for(int i=1;i<=chances;i++)
			{
				int number=Integer.parseInt(reader.readLine());
				int[] binary=convertBinary(number);
				
				for(int j=0;j<binary.length;j++)
				{
					int origValue=binary[j];
					binary[j]=1-binary[j];
					if(j-1>=0 && binary[j-1]==origValue)
						binary[j-1]=1-binary[j-1];
					
					if(j+1<binary.length && binary[j+1]==origValue)
						binary[j+1]=1-binary[j+1];
				}
				int convertedNumber= convertBinaryToDecimal(binary);
				String lastChance= binary.length%2==0?"Y":"X";
				if(convertedNumber==number || convertedNumber== number-1 || 
						convertedNumber==number+1)
					System.out.println(lastChance);
				else
				{
					System.out.println(lastChance.equals("X")?"Y":"X");
				}
			}
		}
		reader.close();
	}
	
	private static int convertBinaryToDecimal(int[] binary) {
		String decimal="";
		for(int i=0;i<binary.length;i++)
			decimal+=""+binary[i];
		return Integer.parseInt(decimal,2);
	}

	private static int[] convertBinary(int num)
	{
		int[] binary=new int[40];
		int index=0;
		while(num > 0){
			binary[index++]=num%2;
			num = num/2;
		}
		for(int j=0,i=index-1;j<index/2;j++,i--)
		{
			int temp=binary[j];
			binary[j]=binary[i];
			binary[i]=temp;
		}
		return Arrays.copyOfRange(binary, 0, index);
	}
}
