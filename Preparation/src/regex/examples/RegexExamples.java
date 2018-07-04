package regex.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples 
{

	public static void main(String[] args) {
		
		websiteExample();
	}

	private static void websiteExample() {
		String line="http://google.eu";
		String pattern="^((http|https)://)([a-zA-Z][a-zA-Z0-9]*)(\\.(com|eu|is|se|(co\\.in)))";
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(line);
		System.out.println("Matched : "+m.matches());
	}
}
