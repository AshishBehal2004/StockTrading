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
		this();
		Node current = other.head;
		 
//		while(current != null)
//		{
//			String current_data = current.getString();
//			
//			this.add(current_data);
//			current = current.next;
//		}

		for (int i=0;i < other.size();i++)
		{
			String listItem = other.get(i);
			this.add(listItem);
		}
			
	}

	//remove the String at the parameter's index
	public String remove(int index) 
	{
		Node current = head;
		int nodeTrack = 0;
		String remove_string = "";
		while(current != null)
		{
			if (index < 0 || index > size)
			{
				return "not a valid index";			
			}
			else if (index == nodeTrack)
			{
				remove_string = current.getString();
				if (current == head)
				{
					head = current.next;
					head.prev = null;	
				}
				
				
				else if (index == size -1 )
				{
					tail = tail.prev;
					tail.next = null;
				}
				else 
				{
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				size--;
				return remove_string;
			}
			current = current.next;
			nodeTrack++;
		}
		return remove_string;
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) 
	{
		Node current = head;
		int nodeTrack = 0;
		String node_string = "";
		while (current != null)
		{
			node_string = current.getString();
			if (node_string.equals(obj))
			{
				return nodeTrack;
			}
			nodeTrack++;
			current = current.next;
		}
		return -1;
		
	}
	
	//returns String at parameter's index
	public String get(int index) 
	{
		Node current = head;
		String nodeData = "";
		int nodeTrack = 0;

		if (index < 0 || index >= size)
		{
			return null;
		}
		else
		{
			while (current != null)
			{
				if (nodeTrack == index)
				{
					nodeData = current.getString();
				}
				current = current.next;
				nodeTrack++;
			}
			return nodeData;
		}
		
	}

	//checks if there is a list
	public boolean isEmpty() 
	{
		Node current = head;
		if (current == null)
		{
			return true;
		}
		return false;
	}

	//return the size of the list
	public int size() 
	{
		return size;
		
	}
	
	//Take each element of the list a writes them to a string 
	
	@Override
	public String toString() 
	{
		Node current = head;
		String result = "";
		while (current !=  null)
		{
			result += current.getString();
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
		Node current = head;
		while(current != null)
		{
			if (current.getString().equals(obj))
			{
				return true;
			}
			current = current.next;
			
		}
		return false;
		
	}

	//removes the parameter's String form the list
	
	//removes the parameter's item form the list
	/*does the removal job by first making a pointer current pointing to head, looping through as long as head is not null
	 * then checks if the head node is equal to obj (parameter object) if yes then another check:if there is only node in list,
	 * then set those head and tail to null, then second if checks if it is only head node, point the current next to head and its previous to null.
	 * if its tail(meaning node at last) point the current's previous to tail, then last if the node is in middle points middle node next to its previous next, and middle node
	 * previous to its previous next(meaning change the pointers to the current), decrease the size and return true
	 * travers through the node, otherwise return false  */
	public boolean remove(String obj) 
	{
		Node current = head;
		while(current != null)
		{
			if (current.getString().equals(obj))
			{
				if (current == head && current == tail)
				{
					head = null;
					tail = null;
					size--;
					return true;
				}
				else if (current == head)
				{
					head = current.next;
					if (head != null)
					{
						head.prev = null;
					}
				}
				else if (current == tail)
				{
					if (tail != null) 
					{
						tail.next = null;
					}
					tail = current.prev;
				}
				else
				{
					current.prev.next = current.next;
					current.next.prev = current.prev;
					
				}
				size--;
			}
			current = current.next;
		}
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
		DSEList list = (DSEList) other;
		Node current = head;
		Node other_node = list.head;
		if (this.size != list.size)
		{
			return false;
		}
		while(current != null)
		{
			if (!current.getString().equals(other_node.getString()))
			{
				
				return false;
			}
			else	
			{
				current = current.next;
				other_node = other_node.next;
				
			}
		}
		return true;
	}
	
//	public static void main(String[] args) {
//		DSEList list1 = new DSEList();
//		list1.add("a");
//		list1.add("b");
//		list1.add("c");
//
//		System.out.println(list1.toString());
//	}
	
}
