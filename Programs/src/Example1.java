import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Example1 
{
	public static void main(String args[])
	{
		 List<String> terms = Arrays.asList(
	                "Coding is great",
	                "Search Engine are great",
	                "Google is a nice search engine",
	                "Bing is also a nice engine");
		 
		 TopCount counter=new TopCount(10);
		 
		 terms.parallelStream().flatMap(t->Arrays.asList(t.split(" ")).stream()).collect(Collectors.toConcurrentMap(w->w, w->1,Integer::sum)).
		 forEach((w,i)->{
			 counter.add(new WordCount(w,i));
		 });
		 
		 
		 System.out.println(counter);
	}
	
	
}

class TopCount
{	
	PriorityQueue< WordCount> heap=new PriorityQueue<>(Comparator.comparingInt(w->w.count));
	int size;
	public TopCount(int size) {
		super();
		this.size = size;
	}
	
	
	public void add(WordCount data)
	{
		if(heap.size()<size)
		{
			heap.offer(data);
		}
		else
		{
			int minCount=heap.peek().count;
			WordCount oldWord=heap.peek();
			for(WordCount word: heap)
			{
				
				if(minCount>word.count)
				{
					minCount=word.count;
					oldWord=word;
				}
			}
			
			heap.remove(oldWord);
		}
		
	}
	
	@Override
	public String toString()
	{
		return "Heap: "+heap;
				
	}
	
}

class WordCount
{
	String word;
	int count;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int cound) {
		this.count = cound;
	}
	
	public WordCount(String word, int cound) {
		super();
		this.word = word;
		this.count = cound;
	}
	
	@Override
	public boolean equals(Object wordCount)
	{
		WordCount newWord=(WordCount) wordCount;
		
		if(newWord==null || newWord.getWord().isEmpty())
			return false;
		
		if(!this.getWord().equals(newWord.getWord()))
			return false;
		
		if(this.getCount()!=newWord.getCount())
			return false;
		
		return true;
		
	}
	
	@Override
	public int hashCode()
	{
		return 31*count;
	}
	
	@Override
	public String toString()
	{
		return "Word: "+word+" Count: "+count;
				
	}
	
	
	
	
}
