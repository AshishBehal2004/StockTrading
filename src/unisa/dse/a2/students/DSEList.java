package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.List;

/**
 * @author simont
 *
 */
public class DSEList implements List {
	
	public Node head;
	private Node tail;
	int size = 0;
	
	
	public DSEList() 
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public DSEList(Node head_) 
	{
		this.head = head_;
		this.tail = head_;
		this.size= 1;
		
		head_.next = null;
		head_.prev = null;	
	}
	
	//Takes a list then adds each element into a new list
	public DSEList(DSEList other) 
	{ 
		Node current = other.head;
		 
		while(current != null)
		{
			String current_data = current.getString();
			
			this.add(current_data);
			current = current.next;
		}
		
	}

	//remove the String at the parameter's index
	public String remove(int index) 
	{

	}

	//returns the index of the String parameter 
	public int indexOf(String obj) 
	{
		
	}
	
	//returns String at parameter's index
	public String get(int index) 
	{
		
	}

	//checks if there is a list
	public boolean isEmpty() 
	{
		
	}

	//return the size of the list
	public int size() 
	{
		
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() 
	{
		
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) 
	{
		Node newNode = new Node(null, tail, obj);
		
		if (head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else 
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
		return true;
	}

	//add String at parameter's index
	public boolean add(int index, String obj) 
	{
		if (index < 0 || index > size)
		{
			return false;			
		}
		else if (index == 0)
		{
			
			Node newNode = new Node(head, null, obj);
			head.prev = newNode;
			head = newNode;
		}
		else if (index == size)
		{
			Node newNode = new Node(null, tail, obj);
			
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		else
		{
			Node current = head;
			for (int i = 0;i < index;i++)
			{
				
				current = current.next;
				Node newNode = new Node(current,current.prev,obj);				
				current.next.prev = newNode;
				current.prev = newNode;
			}
		}
		size++;
		return true;
		
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) 
	{
		
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) 
	{
		
	}
	
	@Override
	public int hashCode() 
	{
		return 0;
	}

	@Override
	public boolean equals(Object other)
	{
		return true;
	}
	
}
