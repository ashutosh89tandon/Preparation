package inheritance;

import java.io.IOException;

class AA
{
	private int i=0;
	private  void abc()throws Exception
	{
		System.out.println("A");
	}
}
class BB extends AA
{
	private int i=0;
	private  void abc() throws IOException
	{
		System.out.println("B "+i++);
	}
}
public class InheritanceExampe2 {

	public static void main(String ar[])
	{
		AA obj=new BB();
		
		//obj.abc();
	}
}
