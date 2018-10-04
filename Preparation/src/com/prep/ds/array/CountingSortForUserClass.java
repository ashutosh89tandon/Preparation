package com.prep.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountingSortForUserClass {
	
	private static CountingSortForUserClass obj=null;
	private class Person
	{
		private int type;
		private String name;
		
		public Person(int type, String name) {
			super();
			this.type = type;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Person [type=" + type + ", name=" + name + "]";
		}	
		
		
	}
	
	public static void main(String args[])
	{
		obj=new CountingSortForUserClass();
		List<Person> personList=Arrays.asList(obj.new Person(0,"Samuel"),obj.new Person(2,"Peter"),obj.new Person(1,"Alex"),
				obj.new Person(2,"David"),obj.new Person(1,"George"));
		
		obj.countSort(personList);
		System.out.println(personList);
	}

	private void countSort(List<Person> personList) {
		
		Map<Integer,LinkedList<Person>> map=new HashMap<Integer,LinkedList<Person>>();
		for(Person person : personList)
		{
			if(map.get(person.type)==null)
			{
				LinkedList<Person> linkedList=new LinkedList<Person>();
				map.put(person.type,linkedList); 
			}
			map.get(person.type).offer(person);
			
		}
		int i=0;
		int j=0;
		while(i<personList.size())
		{
			while(!map.get(j).isEmpty())
			{
				personList.set(i++, map.get(j).poll());
			}
			j++;
		}
		
	}
}
