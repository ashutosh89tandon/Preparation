package Exception;

public class Test {

	public void testRuntimeEx()
	{
		throw new RuntimeEx();
	}
	
	public void testCheckedEx()throws CheckedEx
	{
		throw new CheckedEx();
	}
	
	public void testThrowable()throws ThrowableEx
	{
		throw new ThrowableEx();
	}
	
	public static void main(String args[])
	{
		Test obj=new Test();
		//obj.testRuntimeEx();
		try
		{
		obj.testCheckedEx();
		obj.testThrowable();
		}
		catch(Throwable e)
		{
			StackTraceElement[] elems=e.getStackTrace();
			
			for(StackTraceElement elem:elems)
			{
				System.out.println(elem.getClassName()+":"+elem.getLineNumber());
			}
			
			
		}
		
	}
}
