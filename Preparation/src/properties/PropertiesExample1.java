package properties;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesExample1 {
	
	public static void main(String a[]) throws IOException
	{
		
		FileReader reader=new FileReader("E:/Eclipse Workspace/Files/db.properties");
		
		Properties prop=new Properties();
		prop.load(reader);
		
		Properties prop1=new Properties();
		
		
		System.out.println(prop.getProperty("user"));
		System.out.println(prop.getProperty("password"));
		
		FileWriter writer=new FileWriter("E:/Eclipse Workspace/Files/db.properties");
		FileOutputStream writer1=new FileOutputStream("E:/Eclipse Workspace/Files/db.xml");
		prop.setProperty("age", "23");
		prop.store(writer,"NA");
		
		prop.storeToXML(writer1, "NA");
		
		FileReader reader1=new FileReader("E:/Eclipse Workspace/Files/db.xml");
		prop1.load(reader1);
		
		for(Entry<Object, Object> entry : prop1.entrySet())
		{
			System.out.println("Key : "+entry.getKey()+" Vallue :"+entry.getValue());
		}
		
		reader.close();
		writer.close();
		reader1.close();
		writer1.close();
	}

}
