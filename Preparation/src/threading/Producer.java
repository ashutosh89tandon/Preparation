package threading;

public class Producer implements Runnable{

	Commodity commodity;
	public Producer(Commodity commodity)
	{
		System.out.println("Inside producer");
		this.commodity=commodity;
	}
	
	public void run()
	{
		for(int i=0;i<10;i++)
		System.out.println("Produced : "+commodity.produce());
		
	}
}
