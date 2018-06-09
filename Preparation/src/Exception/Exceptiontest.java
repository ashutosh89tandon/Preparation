package Exception;

public class Exceptiontest {
	
	public static void main(String[] ags)
	{
		try
		{
			abc();
		}
		catch(Throwable e)
		{
			System.out.println("Exception");
			e.printStackTrace();
		}
		
	}
	
	public static void abc()
	{
		throw new Error();
	}

}
