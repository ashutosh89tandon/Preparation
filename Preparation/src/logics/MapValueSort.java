package logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapValueSort {

	public static void main(String args[])
	{
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1 ,"David");
		map.put(2, "Alex");
		map.put(3, "Broad");
		Set<Entry<Integer,String>> entrySet=map.entrySet();
		List<Entry<Integer,String>> list=new ArrayList<Entry<Integer,String>>(entrySet);
		Comparator<Entry<Integer,String> > comp=(e1,e2)->e1.getValue().compareTo(e2.getValue());
		Collections.sort(list,comp);
		
		System.out.println(list);
	}
}
