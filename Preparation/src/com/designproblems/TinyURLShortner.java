package com.designproblems;

public class TinyURLShortner 
{
	private static String map="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static void main(String[] args) {
		int n=786352847;
		String shortUrl=getUrlFromId(n);
		int id=getIDFromShortUrl(shortUrl);
		System.out.println("shortUrl : "+shortUrl);
		System.out.println("id : "+id);
	}
	private static int getIDFromShortUrl(String shortUrl) {
		
		int id=0;
		for(int i=0;i<shortUrl.length();i++)
		{
			char ch=shortUrl.charAt(i);
			id+=Math.pow(62, i)*(map.indexOf(ch));
		}
		return id;
	}
	private static String getUrlFromId(int n) {
		String str="";
		char[] charArray=map.toCharArray();
		while(n>0)
		{
			str=str+charArray[n%62];
			n=n/62;
		}
		
		return str;
	}
}
