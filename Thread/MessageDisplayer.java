
public class MessageDisplayer 
{
	String[] question;
	String[] answer;
	boolean flag;

	
	
	public MessageDisplayer(String[] question, String[] answer, boolean flag) {
		super();
		this.question = question;
		this.answer = answer;
		this.flag = flag;
	}



	public String[] getQuestion() {
		return question;
	}



	public void setQuestion(String[] question) {
		this.question = question;
	}



	public String[] getAnswer() {
		return answer;
	}



	public void setAnswer(String[] answer) {
		this.answer = answer;
	}



	public boolean isFlag() {
		return flag;
	}



	public void setFlag(boolean flag) {
		this.flag = flag;
	}



	public synchronized void  displayQuestion(String m)
	{
		
			if(flag)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(m);
			flag=true;
			notify();
		
	}
	
	public synchronized void displayAnswer(String m)
	{
		
		
			if(!flag)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(m);
			flag=false;
			notify();
		
	}
}
