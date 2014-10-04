#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hashtable_int_int.h"

/*
Implement a method to perform basic string compression using the counts of
repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.
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

	char *str = getString();
	int strSize = strL(str);
	int value;

	hash_table *h = create_table( strSize*2 );

	for(int i = 0; i < strSize; i++)
	{
		//Key has not been initiated
		if( hash_get( h, (int) str[i] ) == -1 )
			hash_put( h, (int) str[i], 1 );
		else
		{
			value = hash_get(h,(int) str[i]);
			hash_put( h, (int) str[i], ++value );
		}
	}

	//	print_table(h);

	for(int j = 0; j < strSize; j++)
	{
		//We haven't yet printed this string
		if( hash_get(h, (int) str[j]) != -1 )
		{
			printf("%c%d", str[j], hash_get(h, (int) str[j] ) );
			hash_put(h, (int) str[j], -1 );
		}
	}

	printf("\n");

}

	
