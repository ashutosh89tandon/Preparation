package threading;

public class Consumer implements Runnable{
	
	Commodity commodity;
	public Consumer(Commodity commodity)
	{
		System.out.println("Inside Consumer");
		this.commodity=commodity;
	}
	
	public void run()
	{
		for(int i=0 ;i<10;i++)
			System.out.println("Consumed : "+commodity.consume());
	}

}
