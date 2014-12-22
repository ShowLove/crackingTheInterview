

import java.io.*;
import java.util.Hashtable;

// A node class whose 'data' field is designed to hold any type of data.
class node<AnyType> {

	AnyType data;
	node<AnyType> next;
	
	// Constructor; sets this object's 'data' field to 'data'.
	node(AnyType data) {
		this.data = data;
	}
}

// A linked list class designed to hold nodes with any type of data.
public class LinkedList<AnyType> {
	
	// Notice that when you create a LinkedList object (in main(), for example),
	// you tell it what kind of data it'll be holding. The LinkedList class
	// needs to pass that information on to the node class, as well. That's
	// what's happening here.
	private node<AnyType> head, tail;

	// insert at the tail of the list
	void insert(AnyType data) {
		// if the list is empty, set 'head' and 'tail' to the new node
		if (head == null) {
			head = tail = new node<AnyType>(data);
		}
		// otherwise, append the new node to the end of the list and move the
		// tail reference forward
		else {
			tail.next = new node<AnyType>(data);
			tail = tail.next;
		}
	}

	// insert at the head of the list
	void headInsert(AnyType data) {
		// first, create the node to be inserted
		node<AnyType> YouCanJustMakeANewNode = new node<AnyType>(data);

		// insert it at the beginning of the list
		YouCanJustMakeANewNode.next = head;
		head = YouCanJustMakeANewNode;

		// if the list was empty before adding this node, 'head' AND 'tail'
		// need to reference this new node
		if (tail == null)
			tail = YouCanJustMakeANewNode;
	}

	// print the contents of the linked list
	void printList() {
		for (node<AnyType> temp = head; temp != null; temp = temp.next)
			System.out.print(temp.data + " ");
		System.out.println();
	}

	// Remove the head of the list (and return its 'data' value).
	AnyType removeHead() {
		// if the list is empty, signify that by returning null
		if (head == null)
			return null;
		
		// Store the data from the head, then move the head reference forward.
		// Java will take care of the memory management when it realizes there
		// are no references to the old head anymore.
		AnyType temp = head.data;
		head = head.next;
		
		// If the list is now empty (i.e., if the node we just removed was the
		// only node in the list), update the tail reference, too!
		if (head == null)
			tail = null;
		
		// Return the value from the old head node.
		return temp;
	}
	
	node<AnyType> deleteNode(node<AnyType> data)
	{
		node<AnyType> helper = head;
		
		if( helper.equals(data) )
		{
			return head.next;
		}
		
		while( helper.next != null )
		{
			if( helper.next.equals(data) )
			{
				helper.next = helper.next.next;
				return helper;
			}
			helper = helper.next;
		}
		return helper;
	}
	
	//This eliminates the duplicates in O(n^2)
	void deleteDuplicatesInt( LinkedList<Integer> L1 )
	{	
		for (node<Integer> temp = L1.head; temp != null; temp = temp.next)
		{
	        for (node<Integer> helper = temp; helper != null && helper.next != null; helper = helper.next)
	        {
	            //start at helper.next so that temp doesn't delete it's self
	            if( temp.data == helper.next.data )
	                helper.next = helper.next.next;
	        }
		}
	}
	
	//This eliminates duplicates in time n
	void deleteDuplicatesIntFast( LinkedList<Integer> L1 )
	{
		Hashtable< Integer, Integer > values = new Hashtable< Integer, Integer >();
		values.put( L1.head.data, 1); //do this so we can use temp.next and don't have to store previous node
		
		for (node<Integer> temp = L1.head; temp != null && temp.next != null; temp = temp.next)
		{	
			//values.put(temp.next.data, 1);
			
			//delete if we have encountered else put it in our hash table
			if( values.containsKey(temp.next.data) )
			{
				temp.next = temp.next.next;
			}		
			
			values.put(temp.next.data, 1);
		}
	}

	// returns true if the list is empty, false otherwise
	boolean isEmpty() {
		return (head == null);
	}

	public static void main(String [] args) {

		// create a new linked list that holds integers
		LinkedList<Integer> L1 = new LinkedList<Integer>();
/*		
		for (int i = 0; i < 10; i++)
		{
			// this inserts random values on the range [1, 100]
			int SomeRandomJunk = (int)(Math.random() * 100) + 1;
			System.out.println("Inserting " + SomeRandomJunk);
			L1.insert(SomeRandomJunk);
		}
*/		
		//8,24,15,15,9,9,25,9
		L1.insert(8);
		L1.insert(24);
		L1.insert(15);
		L1.insert(15);
		L1.insert(9);
		L1.insert(9);
		L1.insert(25);
		L1.insert(9);
		L1.insert(9);
		//L1.insert(9);

		// print the list to verify everything got in there correctly
		System.out.println("Printing integer linked list");
		L1.printList();
		System.out.println("Printing DEL-repeaded LL");
		L1.deleteDuplicatesInt(L1);
		L1.printList();


		// create another linked list (this time, one that holds strings)
		LinkedList<String> L2 = new LinkedList<String>();
		
		L2.insert("Llamas");
		L2.insert("eat");
		L2.insert("very sexy");
		L2.insert("critical thinking");
		L2.insert("Paper clips annd now I'm ");
		L2.insert("daydreaming");

		// print the new list to verify everything got in there correctly
		while (!L2.isEmpty())
			System.out.print(L2.removeHead() + " ");
		System.out.println();

		// print the old list just to verify that there weren't any static
		// problems that messed things up when we created L2
		L1.printList();
	}
}