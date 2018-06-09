package innerclass;

class TestMemberOuter1{  
 private int data=30;  
 class Inner{  
  void msg(){System.out.println("data is "+data);}  
 }  
 public static void main(String args[]){  
  TestMemberOuter1 obj=new TestMemberOuter1();  
  TestMemberOuter1.Inner in=obj.new Inner();  
  in.msg();  
 }  
}  

/*
import java.io.PrintStream;  
class Outer$Inner  
{  
    final Outer this$0;  
    Outer$Inner()  
    {   super();  
        this$0 = Outer.this;  
    }  
    void msg()  
    {  
        System.out.println((new StringBuilder()).append("data is ")  
                    .append(Outer.access$000(Outer.this)).toString());  
    }  
}  */