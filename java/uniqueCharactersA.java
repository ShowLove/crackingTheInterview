import java.util.Hashtable;
import javax.swing.JOptionPane;

/*
Implement an algorithm to determine if a string has all unique characters. 
*/

public class uniqueCharacters {
	
	//A Hash Table that holds the P index values of each test case
	static Hashtable<Integer, Integer> P_Table = new Hashtable<Integer, Integer>();
	
	public static void main(String args[] )
	{
		String str = JOptionPane.showInputDialog(null, "Enter teh string you wish to check");
		if( isUniqueChars2( str ) )
			System.out.println("The string "+str+" has all unique characters");
		else
			System.out.println("The string "+str+" has repeating characters");
	}
	
	public static boolean isUniqueChars2(String str)
	{
		if( str.length() > 256 )
			return false;
		
		boolean[] char_set = new boolean[256];
		
		for( int i = 0; i < str.length(); i++ )
		{
			int val = str.charAt(i);
			
			//We Already found this char in string
			if( char_set[val] )
			{
				return false;
			}
			
			char_set[val] = true;
		}
		return true;
	}
}
