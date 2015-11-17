import java.util.Hashtable;
import javax.swing.JOptionPane;
//To use Arrays.sort and such
import java.util.Arrays;

/*
All the little java tricks that I always forget when I start using another language 
*/

public class mainMehtods {
	
	//A Hash Table that holds the P index values of each test case
	static Hashtable<Integer, Integer> P_Table = new Hashtable<Integer, Integer>();
	
	public static void main(String args[] )
	{
		String str = JOptionPane.showInputDialog(null, "Enter teh string you wish to check");
		if( str.length() > 256 )
			System.out.println("256 char in ascii, 127 normal chars, therefore characters repeat");
		
		strCompress(str);
	}
	
	public static boolean isUniqueChars2(String str)
	{
		//Declare array of booleans
		boolean[] char_set = new boolean[256];
		//Find char at index of string
		int val = str.charAt(0);
		char_set[val] = true;
		return true;
	}
	
	public static int strCompress(String str )
	{
		//String check condition
		if( str == null || str.isEmpty() )
			return 0;
		//Find string length
		int strLength = str.length();
		//Get # digits in a number 100 = 3
		int value = String.valueOf(str).length();
		//like a String, but can be modified. append and insert
		StringBuffer mystr = new StringBuffer();
		mystr.append("c");
		
		System.out.format("ValueOfstrLength(%d)",value);
		
		return strLength;
	}
	
	public static String sort( String str )
	{
		//Convert string to char array
		char[] content = str.toCharArray();
		//Sort a char array
		Arrays.sort( content );
		//creating a new string so you must return it like that
		return new String(content);
	}
}