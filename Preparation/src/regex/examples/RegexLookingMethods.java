package regex.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLookingMethods 
{



	   public static void main( String args[] ) {
	      // String to be scanned to find the pattern.
	      String line = "This order was placed for QT3000! OK?";
	      String pattern = "(.*)(\\d{4})(.*)";
	      String pattern1 = "(.+)(\\d{4})(.*)";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      System.out.println("Find : "+m.find());
	      System.out.println("Find With Index: "+m.find(28));
	      System.out.println("Matches : "+m.matches());
	      
	      r=Pattern.compile(pattern1);
	      line="3000! OK?";
	      m = r.matcher(line);
	      System.out.println("Looking at : "+m.lookingAt());
	      
	      System.out.println("Matches : "+m.matches());
	   }


}
