package threading;

public class Commodity {

	private int commodity=0;
	boolean consume=false;
	public boolean isConsume() {
		return consume;
	}
	public void setConsume(boolean consume) {
		this.consume = consume;
	}
	
	public synchronized int consume() {
		
		while(!consume)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		consume=false;
		commodity--;
		notifyAll();
		return commodity;
	}
	public synchronized int produce() {
		while(consume)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		consume=true;
		commodity++;
		notifyAll();
		return commodity;
	}
	
	
}
