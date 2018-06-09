package threading;

public class Test {
	
	public static void main(String args[])
	{
		Commodity commodity=new Commodity();
		Thread producer=new Thread(new Producer(commodity));
		Thread consumer=new Thread(new Consumer(commodity));
		
		producer.start();
		consumer.start();
	}

}
