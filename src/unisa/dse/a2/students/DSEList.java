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
		return "";
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) 
	{
		return 0;
		
	}
	
	//returns String at parameter's index
	public String get(int index) 
	{
		return "";
		
	}

	//checks if there is a list
	public boolean isEmpty() 
	{
		
		return false;
		
	}

	//return the size of the list
	public int size() 
	{
		return 0;
		
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() 
	{
		Node current = head;
		String result = "";
		while (current !=  null)
		{
			result += current.toString();
			if (current.next != null)
			{
				result += " ";
			}
			current = current.next;
		}
		return result;
		
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
			}
			Node newNode = new Node(current,current.prev,obj);				
			current.prev.next = newNode;
			current.prev = newNode;
		}
		size++;
		return true;
		
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) 
	{
		return false;
		
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) 
	{
		return true;
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
	
	public static void main(String[] args) {
		DSEList list1 = new DSEList();
		list1.add("a");
		System.out.println(list1);
	}
	
}
