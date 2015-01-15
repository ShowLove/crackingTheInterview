import java.util.Arrays;

import javax.swing.JOptionPane;


public class permutation {
	
	/* Given two strings, write a method to decide if one is a permutation of the other.*/
	
	public static void main( String args[] )
	{
		String str1 = JOptionPane.showInputDialog(null, "Enter teh string you wish to check");
		String str2 = JOptionPane.showInputDialog(null, "Enter teh string you wish to check");
		
		if( permutation( str1, str2 ) )
			System.out.println( "Strings "+str1+" and "+str2+" are permutations of each of other" );
		else
			System.out.println( "Strings "+str1+" and "+str2+" are NOT permutations of each of other" );
	}

	public static String sort( String s )
	{
		char[] content = s.toCharArray();
		Arrays.sort( content );
		return new String(content);
	}
	
	public static boolean permutation( String s, String t )
	{
		if( s.length() != t.length() )
			return false;
		
		return sort(s).equals(sort(t));
	}
}
