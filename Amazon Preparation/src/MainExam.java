import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MainExam 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String startWord=br.readLine();
		String endWord=br.readLine();
		String numberfWords=br.readLine();
		int n=Integer.parseInt(numberfWords);

		Set<String> arr=new LinkedHashSet<String>();
		for(int i=1;i<=n;i++)
		{
			String line=br.readLine();
			arr.add(line);
		}
		int count=findCount(startWord,endWord,arr);
		System.out.println(count);

	}

	public static int findCount(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null || dict.size() == 0) {
			return 0;
		}

		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int length = 1;

		while (!queue.isEmpty())
		{
			int count = queue.size();

			for (int i = 0; i < count; i++)
			{
				String current = queue.poll();
				for (int j = 0; j < current.length(); j++)
				{
					for (char c = 'a'; c <= 'z'; c++)
					{
						if (c == current.charAt(j)) {
							continue;
						}

						String temp = replace(current, j, c);

						if (temp.equals(end)) {
							return length + 1;
						}

						if (dict.contains(temp)) {
							queue.offer(temp);
							dict.remove(temp);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}

	private static  String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);

	}
}

