package mustdolist.string;

public class RecursivelyRemoveAdjacent 
{
	public static void main(String[] args) {
		String str="caaabbbaac";
		removeUtil(str);
	}

	private static void removeUtil(String str) {
		String str1=str.charAt(0)+"";
		for(int i=1;i<str.length();)
		{
			boolean found=false;
			while(str1.length()>0 && str.charAt(i)==str1.charAt(str1.length()-1))
			{
				if(str1.length()>0)
				str1=str1.substring(0, str1.length()-1);
				found=true;
				if(i+1<str.length() && str.charAt(i)==str.charAt(i+1))
					i++;
			}
			if(!found)
				str1=str1+str.charAt(i);
			
			i++;
		}
		System.out.println(str1);
	}
}
