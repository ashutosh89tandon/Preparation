package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor 
{
	public static final ExecutorService executor=Executors.newFixedThreadPool(50);
}
