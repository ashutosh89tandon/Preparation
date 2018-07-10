package threading;


public class ThreadPoolExample 
{
	public static void main(String[] args)
	{
		for(int i =0;i<10;i++)
		{
			ThreadPoolExecutor.executor.execute(new Runnable() {

				public void run() {
					System.out.println("Hello");

				}
			});
		}
		
		ThreadPoolExecutor.executor.shutdown();
	}
}
