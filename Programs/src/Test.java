import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test
{
	public static void main(String[] args) {
		
		
		List<Long> list=new ArrayList<Long>();
		list.add(1L);
		
		boolean isEmpty=list.stream().filter(e->e.equals(1L)).collect(Collectors.toList()).isEmpty();
		System.out.println(isEmpty);
	}
}
