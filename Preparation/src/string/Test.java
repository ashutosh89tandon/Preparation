package string;

public class Test {

	public static void main(String aa[])
	{
		String s=new String("abc");
		StringBuffer s1=new StringBuffer("abc");
		System.out.println(s.equals(s1));
		System.out.println(s1.equals(s));
	}
}
