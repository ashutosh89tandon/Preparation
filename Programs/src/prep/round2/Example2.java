package prep.round2;

public class Example2 
{
	
	public static void main(String[] args)
	{
		int n=3;
		int iter=3;
		int index=6;
		String str=decimaltoBinary(n);
		System.out.println(str);
		
		for(int i=1;i<=iter;i++)
		{
			String newStr="";
			for(int j=0;j<str.length();j++)
			{
				if(str.charAt(j)=='0')
					newStr+="01";
				else
					newStr+="10";
			}
			str=newStr;
		}
		
		System.out.println("Character at index : "+index+" : "+str.charAt(index));
	}
	
	public static String decimaltoBinary(int n)
	{
		String str="";
		while(n>0)
		{
			int a=n%2;
			str+=""+a;
			n=n/2;
		}
		
		if(str.charAt(0)=='1')
			str="0"+str;
		return str;
	}
}
