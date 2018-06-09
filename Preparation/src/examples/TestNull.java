package examples;

public class TestNull {

	static void runIt()
	{
		System.out.println("Hello");
		
	}
	
	public void runAgain()
	{
		System.out.println("Test");
	}
	
	public static void main(String args[])
	{
		TestNull obj=null;
		obj.runIt();
		obj.runAgain();
		
	}
}
