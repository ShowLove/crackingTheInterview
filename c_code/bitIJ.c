#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*

u are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
method to insert M into Nsuch that M starts at bit j and ends at bit i. You can assume
that the bits j through i have enough space to fit all ofM. That is, ifM= 10011,
you can assume that there are at least 5 bits between j and i. You would not, for
example, have j-3 and i=2, because M could not fully fit between bit 3 and bit 2.
EXAMPLE:
Input: N = 16000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100

*/

int min( int a, int b )
{
	return ( a < b ) ? a: b;
}

int max( int a, int b )
{
	return ( a > b ) ? a : b;
}

int main()
{

	unsigned int N = 0x80000000;
	unsigned short M = 0x13;
	int	i = 2;int  j = 6;

	printf("N( %04x) M(%04x)\n", N, M );


	//masks
	unsigned int N2 = 0x00000000;
	unsigned int N3 = 0xFFFFFF00;
	
	printf(" N2(%04x) \n", N2 );

	int shift = min(i, j);

	N2 = N2 | M;
	
	printf(" N2(%04x) \n", N2);

	for( int k = 0; k < shift; k++ )
	{
		N2 = N2 << 1;
		N3 = N3 << 1;
		printf("N2(%04x)k(%d) \n", N2, k);
	}

	printf("N( %04x) M(%04x) N2(%04x) \n", N, M , N2);

	N = N & N3;
	N = N | N2;

	printf("N( %04x) M(%04x) N2(%04x) \n", N, M , N2);
}
