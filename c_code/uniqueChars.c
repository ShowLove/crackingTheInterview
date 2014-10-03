#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

/*
Implement an algorithm to determine if a string has all unique characters. What if
you cannot use additional data structures?
*/

void duplicatesDataStructure( char *str );
void duplicatesNoDataStructure( char *str );


char *promptForString()
{

	int size = 8;
	int i = 0;
	char c;
	char *str = malloc( sizeof( char )*size );

	printf("\nInsert string: ");

	do
	{
		c = getchar();

		if( c == '\r' || c == '\n' )
			c = '\0';

		if( size == i )
		{
			size *= 2;
			str = realloc( str, sizeof( char )*size );
		}

		str[i] = c;
		
		i++;
	
	}
	while( c != '\0' );

	return str;

}

int strL( char *str )
{
	char *c;

	for( c = str; *c; c++ );

	return (int) (c - str);	
}

int mycmp( const void *a, const void *b )
{
	return ( *(char *)a - *(char *)b );
}

int main()
{
	char *str = promptForString();
	int dataStructure;

	printf(" find if %s has duplicates. \n\t Can we use data structures? \n 1 = yes, 0 = no : ", str );
	scanf("%d", &dataStructure );

	//asssume the user gives valid input
	( dataStructure == 1 ) ? duplicatesDataStructure(str) : duplicatesNoDataStructure(str);

	
	getchar();
}

void duplicatesDataStructure( char *str )
{
	int duplicates = 0;
	int asciiNum = 255;
	int chars[asciiNum];

	memset( chars, 0, sizeof(int)*asciiNum );

	for(int i = 0; i < strL(str); i++)
	{
		if( str[ (int) str[i] ] > 0 )
		{
			printf("Duplicate found\n");
			duplicates++;
		}
		
		str[ (int) str[i] ]++;
	}	

	( duplicates > 0 ) ? printf("Your string had  %d duplicates\n", duplicates) : printf("Your string had no duplicates\n");

}

void duplicatesNoDataStructure( char *str )
{
	int duplicates = 0;

	qsort( str, strL(str), sizeof(char), mycmp);

	for(int i = 0; i < strL(str); i++)
		if( i > 0 )
			if( str[i] == str[i-1] )
				duplicates++;

	( duplicates > 0 ) ? printf("Your string had  %d duplicates\n", duplicates) : printf("Your string had no duplicates\n");

}
