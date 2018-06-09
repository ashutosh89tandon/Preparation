package enumexamples;

public class EnumExample5 {
	
	enum Currency{USD}
	
	public static void main(String args[])
	{
		Currency currency=Enum.valueOf(Currency.class, "USD");
		System.out.println("Currency : "+currency);
		
		currency=Currency.valueOf("USD");
		System.out.println("Currency : "+currency);
		
		currency=Currency.valueOf(Currency.class, "USD");
		System.out.println("Currency : "+currency);
		
		Currency currency1=Enum.valueOf(Currency.class, "INR");
		System.out.println("Currency : "+currency);
		
		currency1=Currency.valueOf("INR");
		System.out.println("Currency : "+currency);
		
		currency1=Currency.valueOf(Currency.class, "INR");
		System.out.println("Currency : "+currency);
		
	}

}
