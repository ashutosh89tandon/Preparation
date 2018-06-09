
public class Test 
{
	public static void main(String a[])
	{
		String[] question={"Hi!!","How are you?"};
		String[] answer={"Hi","I am good."};
		MessageDisplayer md=new MessageDisplayer(question, answer, false);
		
		QuestionThread qt=new QuestionThread(md);
		AnswerThread at=new AnswerThread(md);
	}
}
