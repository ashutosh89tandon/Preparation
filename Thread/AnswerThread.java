

public class AnswerThread implements Runnable{

	MessageDisplayer md;
	Thread t;
	
	public MessageDisplayer getMd() {
		return md;
	}

	public void setMd(MessageDisplayer md) {
		this.md = md;
	}

	@Override
	public void run() {
		for(String m: md.getAnswer())
		{
		md.displayAnswer(m);
		}
	}

	public AnswerThread(MessageDisplayer md) {
		super();
		this.md = md;
		t=new Thread(this, "Answer Thread");
		t.start();
	}
	

}
