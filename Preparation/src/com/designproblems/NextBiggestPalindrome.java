package com.designproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextBiggestPalindrome {

	public static void main(String[] args) {
		long number=941878322;
		Long n[]= findNumberArray(number);
		int palindrome=findNextGreaterPalindrome(n);
		System.out.println(palindrome);
	}

	private static int findNextGreaterPalindrome(Long[] n)
	{
		int palindrome=0;
		//case 1 : All are nine
		if(isAll9(n))
		{
			palindrome=(int) (Math.pow(10, n.length)+1);
		}
		
		//case 2: number is already a palindrome
		if(isPalindrome(n))
		{
			palindrome=getPalindromeForPalindromeInput(n);
		}
		else
		{
			Map<Boolean, Integer> isLeftGreater=isLeftGreater(n);
			if(isLeftGreater.containsKey(true))
				palindrome=getPalindromeWhereLeftIsGreater(n,isLeftGreater.get(true));
			else
				palindrome=getPalindromeWhereRightGreater(n,isLeftGreater.get(false));
		}
		return palindrome;
	}

	private static int getPalindromeWhereRightGreater(Long[] n, Integer index) {
		int palindrome=0;
		int newIndex=0;
		int i,j;
		boolean midEven=n.length%2==0;
		if(midEven)
		{
			j=n.length/2;
			i=(n.length/2)-1;
		}
		else
		{
			i=n.length/2;
			j=n.length/2;
		}
		if(i!=j)
			n[i]++;
		n[j]++;
		int carryForward=0;
		for(;i>=0 && j<n.length;i--,j++)
		{
			n[i]=n[i]+carryForward;
			n[j]=n[j]+carryForward;
			if(n[i]>9)
			{
				carryForward=(int) (n[i]/10);
				if(i!=j)
					n[j]=n[j]%10;
				n[i]=n[i]%10;
			}
			else
				break;
		}
		newIndex=i;
		for(i=newIndex, j=n.length-1-newIndex;i>=0 && j<n.length;i--,j++)
		{
			n[j]=n[i];
		}
		palindrome=getDecimalFromArray(n);
		return palindrome;
	}

	private static int getPalindromeWhereLeftIsGreater(Long[] n, Integer index) {
		int palindrome=0;
		for(int i=index, j=n.length-1-index;i>=0 && j<n.length;i--,j++)
		{
			n[j]=n[i];
		}
		palindrome=getDecimalFromArray(n);
		return palindrome;
	}

	private static Map<Boolean,Integer> isLeftGreater(Long[] n) {
		boolean midEven=n.length%2==0;
		Map<Boolean,Integer> result=new HashMap<>();
		int i,j;
		if(midEven)
		{
			j=n.length/2;
			i=(n.length/2)-1;
		}
		else
		{
			i=n.length/2;
			j=n.length/2;
		}
		
		for(;i>=0 && j<n.length;i--,j++)
		{
			if(n[i]==n[j])
				continue;
			if(n[i]<n[j])
			{
				result.put(false,i);
				break;
			}
			else
			{
				result.put(true, i);
				break;
			}
		}
		
		return result;
	}

	private static int getPalindromeForPalindromeInput(Long[] n) {
		int palindrome=0;
		boolean midEven=n.length%2==0;
		int i,j;
		if(midEven)
		{
			j=n.length/2;
			i=(n.length/2)-1;
		}
		else
		{
			i=n.length/2;
			j=n.length/2;
		}
		if(i!=j)
		 n[i]++;
		n[j]++;
		int carryForward=0;
		for(;i>=0 && j<n.length;i--,j++)
		{
			n[i]=n[i]+carryForward;
			n[j]=n[j]+carryForward;
			if(n[i]>9)
			{
				carryForward=(int) (n[i]/10);
				if(i!=j)
					n[j]=n[j]%10;
				n[i]=n[i]%10;
			}
			else
				break;
		}
		
		palindrome=getDecimalFromArray(n);
		return palindrome;
	}

	private static int getDecimalFromArray(Long[] n) {
		int number=0;
		for(int i=0;i<n.length;i++)
			number+=Math.pow(10, i)*n[i];
		return number;
	}

	private static boolean isPalindrome(Long[] n) {
		for(int i=0,j=n.length-1;i<n.length/2;i++,j--)
		{
			if(n[i]!=n[j])
				return false;
		}
		return true;
	}

	private static boolean isAll9(Long[] n) {
		for(int i=0;i<n.length;i++)
		{
			if(n[i]!=9)
				return false;
		}
		return true;
	}

	private static Long[] findNumberArray(long number) {
		List<Long> num=new ArrayList<>();
		while(number>0)
		{
			num.add(number%10);
			number/=10;
		}
		Collections.reverse(num);
		return num.toArray(new Long[num.size()]);
	}
}
