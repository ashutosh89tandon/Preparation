package junit;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class Test2 extends TestCase{
	
	int i,j;
	protected void setUp()
	{
		i=0;
		j=1;
		
		System.out.println("i : "+i+" j : "+j);
	}
	@Test
	public void test1()
	{
		assertEquals(i+j,1);
	}
	@Test
	public void test2()
	{
		assertEquals(i+j,2);
	}
	
	protected void tearDown()
	{
		i=1;
		j=2;
		
		System.out.println("i : "+i+" j : "+j);
	}
	
	
}
