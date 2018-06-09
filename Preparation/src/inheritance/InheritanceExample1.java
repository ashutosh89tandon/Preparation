package inheritance;

class A
{}

class B extends A
{}

public class InheritanceExample1 {

	public static void main(String args[])
	{
		A obj1=new A();
		A obj2=new B();
		B obj3=new B();
		show(obj3);
		show1(obj3);
	}
	
	static void show(A a)
	{
		System.out.println("hi");
	}
	
	static void show1(B b)
	{
		System.out.println("hello");
	}
}
