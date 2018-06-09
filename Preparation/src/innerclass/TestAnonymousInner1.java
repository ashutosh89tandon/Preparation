package innerclass;

interface Eatable{  
	 void eat();  
	}  
	 class TestAnonymousInner1{  
	 public static void main(String args[]){  
	 Eatable e=new Eatable(){  
	  public void eat(){System.out.println("nice fruits");}  
	 };  
	 e.eat();  
	 }  
	}  
	 
/*
 * import java.io.PrintStream;  
static class TestAnonymousInner1$1 implements Eatable  
{  
TestAnonymousInner1$1(){}  
void eat(){System.out.println("nice fruits");}  
}  
 * 
 * */
