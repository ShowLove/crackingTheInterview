import javax.swing.JOptionPane;

/*
 * Implement a method to perform basic string compression using the counts of
repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.
 */


public class strCompression {
	
	public static void main( String args[] )
	{
		String str1 = JOptionPane.showInputDialog(null, "Enter teh string you wish to compress");
		
		System.out.println( "Your compressed string is " + compressString( str1 ) );
		
	}
	
	//Returns the size of the compressed string
	public static int countCompression( String str )
	{
		if( str == null || str.isEmpty() )
			return 0;
		
		char last = str.charAt( 0 );
		int size = 0;
		int count = 1;
		
		for(int i = 1; i < str.length(); i++ )
		{
			// 100 is bigger than 10, this is keeping track of how long the word is
			if( str.charAt(i) == last )
				count++;
			else 
			{
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf( count ).length();
				
		return size;
	}
	
	public static String compressString( String str )
	{
		//Check if compression would create a longer string
		int size = countCompression( str );
		
		if( size >= str.length() )
			return str;
		
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt( 0 );	//first letter of the word
		int count = 1;
		
		//compress consecutively repeating chars
		for( int i = 1; i < str.length(); i++ )
		{
			if( str.charAt(i) == last )
			{
				//We found a repeat char
				count++;
			} else
			{
				//Insert char count, and update last char
				mystr.append( last );	//Insert char
				mystr.append( count ); //Insert count
				last = str.charAt(i);
				count = 1;
			}
			

		}
		
		/*
		 * In the lines above characters are inserted when the 
		 * repeated character changes. We need to update the string at 
		 * the end of the method as well, since the very last set of
		 * repeated characters wouldn't be set in the compressed string yet
		 */
		
		mystr.append( last );
		mystr.append( count );
		return mystr.toString();
	}

}
