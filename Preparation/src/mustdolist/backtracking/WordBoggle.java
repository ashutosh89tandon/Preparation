package mustdolist.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBoggle 
{
	public static void main(String[] args) {
		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
		Character boggle[][]   = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
		List<String> availableStrings=findAvailableStrings(dictionary,boggle);
	
		System.out.println(availableStrings);
	}

	private static List<String> findAvailableStrings(String[] dictionary, Character[][] boggle)
	{
		List<String> result=new ArrayList<>();
		for(String word: dictionary)
		{
			List<String> indexes=new ArrayList<String>();
			Map<String,Integer> map=findCharacter(boggle,word.charAt(0));
			if(!map.isEmpty())
			{
				boolean found =findWord(indexes,boggle,0,word,map);
				if(found)
					result.add(word);
			}
		}
		
		return result;
	}

	private static Map<String, Integer> findCharacter(Character[][] boggle, char character) {
		
		for(int i=0;i<boggle.length;i++)
		{
			for(int j=0;j<boggle[0].length;j++)
			{
				if(boggle[i][j]==character)
				{
					Map<String, Integer> map=new HashMap<>();
					map.put("row", i);
					map.put("column", j);
					return map;
				}
			}
		}
		
		return Collections.emptyMap(); 
	}

	private static boolean findWord(List<String> indexes, Character[][] boggle, int index, String word, Map<String, Integer> map) 
	{
		if(index+1==word.length())
			return true;
		if(!map.isEmpty())
		{
			indexes.add(map.get("row")+"->"+map.get("column"));
			if(isSafe(map,indexes,index+1,word,boggle))
			{
				if(findWord(indexes, boggle, index+1, word, map))
					return true;
			}
		}
		
		return false;
	}

	private static boolean isSafe(Map<String, Integer> map, List<String> indexes, int index, String word,
			Character[][] boggle)
	{
		char character=word.charAt(index);
		int row=map.get("row");
		int col=map.get("column");
		int colSize=boggle[0].length;
		int rowSize=boggle.length;
		
		if(col>0 && boggle[row][col-1]==character && !indexes.contains((row)+"->"+(col-1)))
		{
			map.put("row", row);
			map.put("column", col-1);
			return true;
		}
		if(col<colSize-1 && boggle[row][col+1]==character && !indexes.contains((row)+"->"+(col+1)))
		{
			map.put("row", row);
			map.put("column", col+1);
			return true;
		}
		if(row>0 && col>0 && boggle[row-1][col-1]==character && !indexes.contains((row-1)+"->"+(col-1)))
		{
			map.put("row", row-1);
			map.put("column", col-1);
			return true;
		}
		if(row>0 && col<colSize-1 && boggle[row-1][col+1]==character && !indexes.contains((row-1)+"->"+(col+1)))
		{
			map.put("row", row-1);
			map.put("column", col+1);
			return true;
		}
		if(row<rowSize-1 && col>0 && boggle[row+1][col-1]==character && !indexes.contains((row+1)+"->"+(col-1)))
		{
			map.put("row", row+1);
			map.put("column", col-1);
			return true;
		}
		if(row<rowSize-1 &&  col<colSize-1 && boggle[row+1][col+1]==character && !indexes.contains((row+1)+"->"+(col+1)))
		{
			map.put("row", row+1);
			map.put("column", col+1);
			return true;
		}
		if(row>0 && boggle[row-1][col]==character && !indexes.contains((row-1)+"->"+(col)))
		{
			map.put("row", row-1);
			map.put("column", col);
			return true;
		}
		if(row<rowSize-1 && boggle[row+1][col]==character && !indexes.contains((row+1)+"->"+(col)))
		{
			map.put("row", row+1);
			map.put("column", col);
			return true;
		}
		return false;
	}
}
