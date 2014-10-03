#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
Given two strings, write a method to decide if one is a permutation of the other
*/

char* getString(void) {
	int size = 8; // initial str size to store input
	char* str = malloc(size*sizeof(char));

	if (str == NULL)
   {
	 return NULL; // out of memory
	}

	char c = '\0';
	int i = 0;
	printf("Enter your string: ");

	do {
	 c = getchar();
	 if (c == '\r' || c == '\n') 
		  c = '\0'; // end str if user hits <enter>

	 if (i == size) {
		  size *= 2; // duplicate str size
		  str = realloc(str, size*sizeof(char)); // and reallocate it
		  if (str == NULL) {
			 return NULL; // out of memory
		  }
	 }
	 str[i++] = c;
	} while (c != '\0');
	return str;
}

int strL(char *str)
{
	char *s;

	for(s = str; *s; s++);
	
	return ( (int) (s - str) );
}

int main()
{

	int asciiSize = 255;
	char *str1 = getString();
	char *str2 = getString();
	int bucket[asciiSize];
	int isPermutation = 1;

	memset( bucket, 0, sizeof(int)*asciiSize );

	if( strL(str1) != strL(str2) )
	{
		isPermutation++;
		printf("%s is NOT a permutation of %s", str1, str2);
	}

	int str1L = strL(str1), strL2 = strL(str2);

	for(int i = 0; i < str1L; i++)
	{
		bucket[ (int) str1[i] ]++;
	}

	for(int i = 0; i < strL2; i++)
	{
		bucket[ (int) str2[i] ]--;
		if( bucket[ (int) str2[i] ] < 0 )
			isPermutation = 0;
	}

	( isPermutation == 1 ) ? printf("They were permutations\n") : printf("They were NOT permutation\n");
}
