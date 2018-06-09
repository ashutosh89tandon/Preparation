package junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner3 {
	public static void main(String[] args)
	{
		Result result=JUnitCore.runClasses(TestSuite.class);
		
		for(Failure failure :result.getFailures())
		{
			System.out.println("failure : "+failure.getDescription());
			
		}
		
		System.out.println("result.was successful "+result.wasSuccessful());
	}
}
