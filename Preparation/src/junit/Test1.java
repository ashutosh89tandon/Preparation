package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {
	@Test
	public void test1()
	{
		String str="Hello";
		assertEquals("Hello",str);
	}
	
	@Test
	public void test2()
	{
		String str="Hello1";
		assertEquals("Hello",str);
	}
}
