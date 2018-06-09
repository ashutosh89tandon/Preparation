

public class QuestionThread implements Runnable{

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
		for(String m: md.getQuestion())
		{
		md.displayQuestion(m);
		}
	}

	public QuestionThread(MessageDisplayer md) {
		super();
		this.md = md;
		t=new Thread(this, "Question Thread");
		t.start();
	}
	

}
