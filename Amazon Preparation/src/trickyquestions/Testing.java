package trickyquestions;

import java.io.File;

public class Testing {
	public static void main(String[] args) throws Exception {
		//test();
		//test1();
		//test2();
		test3();
	}
	
    public static void test()
     {
         // the line below this gives an output
         // \u000d System.out.println("comment executed");
     }
    
    public static void test1()
    {
    loop1:
    for (int i = 0; i < 5; i++)
     {
        for (int j = 0; j < 5; j++) 
        {
            if (i == 3)
                break loop1;
            System.out.println("i = " + i + " j = " + j);
        }
    }
   }
    
    public static void test2()
    {
        File file = new File("E:\\");
         
        double size = file.getFreeSpace() / (1024.0 * 1024 * 1024);
        System.out.printf( "%.3f GB\n", size); 
        
         size =file.getUsableSpace() ;
         System.out.printf( "%.3f GB\n", size);
    }
    
    public static void test3()
            throws java.lang.Exception
  {
      int inum = 1_00_00_000;
      System.out.println("inum:" + inum);

      long lnum = 1_00_00_000;
      System.out.println("lnum:" + lnum);

      float fnum = 2.10_001F;
      System.out.println("fnum:" + fnum);

      double dnum = 2.10_12_001;
      System.out.println("dnum:" + dnum);
   }
}