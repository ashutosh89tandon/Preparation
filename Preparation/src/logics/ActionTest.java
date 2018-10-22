package logics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ActionTest<T> {

	@SuppressWarnings("rawtypes")
	static Map<Class,BiConsumer> operator =new HashMap<>();
	static BiConsumer<String,String> stringFunction=(t1,t2)->{
		System.out.println(t1+t2);
	};
	static BiConsumer<Integer,Integer> intFunction=(t1,t2)->{
		System.out.println(t1*t2);
	};
	
	static{
		operator.put(String.class,stringFunction);
		operator.put(Integer.class,intFunction);
	}
	
	public static  void main(String args[])
	{
		ActionTest<String> obj=new ActionTest<>();
		obj.test("A","B");
		
		ActionTest<Integer> obj1=new ActionTest<>();
		obj1.test(1,2);
	}
	
	@SuppressWarnings("unchecked")
	public void test(T t1, T t2)
	{
		operator.get(t1.getClass()).accept(t1, t2);
	}
}
