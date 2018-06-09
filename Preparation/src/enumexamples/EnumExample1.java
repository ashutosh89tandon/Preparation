package enumexamples;



public class EnumExample1 {
	
	
	public enum Season{WINTER,SUMMER,AUTUMN,SPRING}
	
	public static void main(String args[])
	{
		for(Season s : Season.values())
		{
			System.out.println("Seasons : "+s);
			System.out.println("Seasons Name : "+s.name());
			System.out.println("Seasons Ordinal : "+s.ordinal());
			System.out.println("Seasons ToString : "+s.toString());
			System.out.println("Seasons getClass : "+s.getClass());
			System.out.println("Seasons getDeclaringClass : "+s.getDeclaringClass());
			System.out.println("Seasons s.valueOf(s.toString()) : "+s.valueOf(s.name()));
		}
	}
	
	
	//Internal implementation of enum define above
	/*
	 * public static final class EnumExample1$Season extends Enum { private
	 * EnumExample1$Season(String s, int i) { super(s, i); }
	 * 
	 * public static EnumExample1$Season[] values() { return
	 * (EnumExample1$Season[])$VALUES.clone(); }
	 * 
	 * public static EnumExample1$Season valueOf(String s) { return
	 * (EnumExample1$Season)Enum.valueOf(EnumExample1$Season, s); }
	 * 
	 * public static final EnumExample1$Season WINTER; public static final
	 * EnumExample1$Season SPRING; public static final EnumExample1$Season
	 * SUMMER; public static final EnumExample1$Season FALL; private static
	 * final EnumExample1$Season $VALUES[];
	 * 
	 * static { WINTER = new EnumExample1$Season("WINTER", 0); SPRING = new
	 * EnumExample1$Season("SPRING", 1); SUMMER = new
	 * EnumExample1$Season("SUMMER", 2); FALL = new EnumExample1$Season("FALL",
	 * 3); $VALUES = (new EnumExample1$Season[] { WINTER, SPRING, SUMMER, FALL
	 * }); }
	 * 
	 * }
	 */
	

}
