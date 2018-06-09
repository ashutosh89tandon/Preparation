import java.util.ArrayList;
import java.util.List;

public class TestExample 
{
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		list.add("Sumit");
		list.add("Shailesh");
		list.add("Ashu");
		
		list.stream().forEach(e->{
			System.out.println("Name: : "+e);
		});
		
		list.stream().forEach(System.out::println);
	}
}
