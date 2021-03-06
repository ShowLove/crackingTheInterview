package crackTheInterview;

public class isStringPermutation {
	
	/***********************************************************************************
	  Given two strings, write a method to decide if one is a permutation of the other.
	  //details//
		We will assume for this problem that the comparison is case sensitive and whitespace is
		significant. So, "god " is different from "dog".
	 * **********************************************************************************/
	
	//SOLUTION 1
	/***********************************************************************************
	 * Sort each string and then compare them.
	Though this algorithm is not as optimal in some senses, it may be preferable in one
	sense: it's clean, simple and easy to understand	  
	 * **********************************************************************************/	
	 public boolean permutation(String s, String t) 
	 {
		 if (s.length() != t.length()) 
		 {
			 return false;
		 }
	
	 //once both strings are sorted we can easily check if they are permutations
	//Keep in mind we wrote the sort method
	 return sort(s).equals(sort(t));	//returns a boolean
	 
	 }
	 
	 //SOLUTION 2
	/***********************************************************************************
	simply iterate through this code, counting
	how many times each character appears.Then, afterwards, we compare the two arrays  
	 * **********************************************************************************/
	  public boolean permutation2(String s, String t) 
	  {
		 if (s.length() != t.length()) 
		 {
			 return false;
		 }
		 
		 int[] letters = new int[256]; // Assumption
		
		 char[] s_array = s.toCharArray();
		 
		 //find out how many times each letter appears in string1
		 for (char c : s_array) 
		 { // count number of each char in s.
			 letters[c]++;
		 }
		 
		 //String2 should have equal occurrences of each char
		 for (int i = 0; i < t.length(); i++) 
		 {
			  int c = (int) t.charAt(i);
			  if (--letters[c] < 0) 
			  {
				  return false;
			  }
		 }
		 
		  return true;
	  }
		
	
	 /////////////////////////////////HELPER_FUNCTIONS SOLUTION1//////////////////////////////////////
	 
	public String sort(String s) 
	{
		 char[] content = s.toCharArray();
		 java.util.Arrays.sort(content);
		 return new String(content);
	}	 
	 
	public void printResult(boolean isPerm)
	{
		if(isPerm)
		{
			System.out.println("String 1 is a permutation of String2");
		}
		else
		{
			System.out.println("String 1 is NOT a permutation of String2");
		}
	}

}

/***********************************************************************************
//main	SOLUTION1/   //sol2 just change permutation to permutation2
	boolean isPermutation;
	//Create an object of the main class to use its methods
	cti_main myMethods = new cti_main();
	isStringPermutation isPerm = new isStringPermutation();
	
	String myString1 = myMethods.promptForAndRetunString();
	String myString2 = myMethods.promptForAndRetunString();
	
	isPermutation = isPerm.permutation(myString1, myString2);
	isPerm.printResult(isPermutation); 
* **********************************************************************************/
