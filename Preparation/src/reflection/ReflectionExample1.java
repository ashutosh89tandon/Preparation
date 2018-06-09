package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectionTest
{
	public ReflectionTest()
	{
		System.out.println("Reflection constructor");
	}
	
	private void message()
	{
		System.out.println("Hello");
	}
	
	private int add(int a, int b)
	{
		return a+b;
	}

}

public class ReflectionExample1 {
	
	public static void main(String a[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		Class c=Class.forName("reflection.ReflectionTest");
		ReflectionTest obj=(ReflectionTest) c.newInstance();
		Method m=c.getDeclaredMethod("message",null);
		m.setAccessible(true);
		m.invoke(obj, null);
		
		Method m2=c.getDeclaredMethod("add",new Class[]{int.class, int.class});
		m2.setAccessible(true);
		int z=(Integer) m2.invoke(obj, new Object[]{4,5});
		System.out.println(z);
		
		Constructor<?> ct=c.getConstructor();
		Object obj1=ct.newInstance();
		
		
	}

}
