package innerclass;

abstract class Person{  
	  abstract void eat();  
	}  
	class TestAnonymousInner{  
	 public static void main(String args[]){  
	  Person p=new Person(){  
	  void eat(){System.out.println("nice fruits");}  
	  };  
	  p.eat();  
	 }  
	}  
	
	/*
	 * 
	 * import java.io.PrintStream;  
static class TestAnonymousInner$1 extends Person  
{  
   TestAnonymousInner$1(){}  
   void eat()  
    {  
        System.out.println("nice fruits");  
    }  
}  */
