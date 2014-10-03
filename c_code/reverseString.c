#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>

void reverseString(char *str);

/*
Implement a function void reversefchar* str) in Cor C++ which reverses a null-terminated
string.
*/

char* prompAndAlocStringDynamically(void) 
{
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

void swap( char *a, char *b )
{
	char tmp = *a;
	*a = *b;
	*b = tmp;
}

int strL(char *str)
{
	char *s;

	for(s = str; *s; s++);

	return ( (int) (s - str) );
}

void reverseString(char *str)
{
	int Length = strL(str);

	for(int i = 0; i < Length/2; i++)
	{
		swap( &str[i], &str[Length - i - 1] );
	}

	printf("Your string reversed is %s\n", str);
}


int main()
{

	char *str = prompAndAlocStringDynamically();

	reverseString(str);

	getchar();

}
