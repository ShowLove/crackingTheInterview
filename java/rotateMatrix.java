import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class rotateMatrix {

	/*
	 * Given an image represented by an NxN matrix, where each pixel in the image is 4
	bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
	 
	 *  //Algorithm
	 *  for i = 0 to n
	 *  	temp = top[i]
	 *  	top[i] = left[]
	 *  	left[i] = bottom[i]
	 *  	bottom[i] = right[i]
	 *  	right[i] = temp
	 */
	
	public static void main( String args[] )
	{
		System.out.println("Enter the dimensions of the array you want to create");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[][] myArray = retDoubleArray( n );
		
		System.out.println("Before Rotation \n" + Arrays.deepToString(myArray));
		
		myArray = rotate( myArray, n );
		
		System.out.println("After Rotation \n" + Arrays.deepToString(myArray));
		
	}
	
	// - n is the dimension of the side of the matrix
	public static int[][] rotate( int[][] matrix, int n )
	{
		//layer is what layer you are on from outside in
		for( int layer = 0; layer < (n/2); ++layer )
		{
			int first = layer;
			int last = n - 1 - layer;
			
			for( int i = first; i < last; ++i )
			{
				int offset = i - first; //Remember u r layers in and need this as an index measure for your current layer
				//save top
				int top = matrix[first][i];
				
				// left --> top
				matrix[first][i] = matrix[last - offset][first];
				
				// bottom --> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// right --> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top --> right
				matrix[i][last] = top;
			}
		}
		return matrix;
	}
	
	//Returns a double array
	public static int[][] retDoubleArray( int n )
	{
		int[][] myArray = new int[n][n];
		
		for(int i = 0; i < n; i++ )
		{
			for(int j = 0; j < n; j++)
			{
				myArray[i][j] = n*i + j;
			}
		}
		
		return myArray;
	}
	
}
