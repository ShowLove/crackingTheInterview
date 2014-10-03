#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>

/*
Write a  method to replace all spaces in a string with '%20'. You may assume that the
string has sufficient space at the end of the string to hold the additional characters,
and that you are given the "true" length of the string. (Note: if implementing in Java,
please use a character array so that you can perform this operation in place.)
*/

char* getString(void) {
	int size = 1000; // initial str size to store input
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

	int space = 0;

	char *str = getString();

	int length = strL(str);

	for(int i = 0; i < length; i++)
	{
		if( (int) ' ' == (int) str[i] )
			space++;
	}

	int newL = length + space*2;
	str[newL + 1 ] = '\0';

	for(int j = length; j > 0; j--)
	{
		if( (int) str[j] == (int) ' ' )
		{
			str[newL--] = '0';
			str[newL--] = '2';
			str[newL--] = '%';
		}
		else
		{
			str[newL--] = str[j];
		}
	}
	
	printf("Your new string is :%s\n", str);

}
