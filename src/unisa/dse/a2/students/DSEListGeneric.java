package unisa.dse.a2.students;
import unisa.dse.a2.interfaces.ListGeneric;


/**
 * @author simont
 *
 */
public class DSEListGeneric<T> implements ListGeneric<T> {
	
	public NodeGeneric<T> head;
	private NodeGeneric<T> tail;
	int size = 0;
	public DSEListGeneric() 
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public DSEListGeneric(NodeGeneric<T> head_) 
	{
		this.head = head_;
		this.tail = head_;
		this.size= 1;
		
		head_.next = null;
		head_.prev = null;	
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEListGeneric<T> other) 
	{ // Copy constructor. 
		this();
		NodeGeneric<T> current = other.head;
		 
//		while(current != null)
//		{
//			T current_data = current.get();
//			
//			this.add(current_data);
//			current = current.next;
//		}
		for (int i=0;i < other.size();i++)
		{
			T listItem = other.get(i);
			this.add(listItem);
		}
	}

	//remove and return the item at the parameter's index
	@Override
	public T remove(int index) 
	{
		NodeGeneric<T> current = head;
		int nodeTrack = 0;
		T remove_string = null ;
		while(current != null)
		{
			if (index < 0 || index >= size)
			{
				return null;			
			}
			else if (index == nodeTrack)
			{
				remove_string = current.get();
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
				return (T) remove_string;
			}
			current = current.next;
			nodeTrack++;
		}
		return remove_string;
	}
//
//	//returns the index of the String parameter 
	@Override
	public int indexOf(Object obj) 
	{
		NodeGeneric<T> current = head;
		int nodeTrack = 0;
		while (current != null)
		{
			
			if (current.get().equals(obj))
			{
				return nodeTrack;
			}
			nodeTrack++;
			current = current.next;
		}
		return -1;
	}

//	//returns item at parameter's index
	public T get(int index) 
	{
		NodeGeneric<T> current = head;
		T nodeData = null ;
		int nodeTrack = 0;

		if (index < 0 || index >= size)
		{
			return null;
		}

			while (current != null)
			{
				if (nodeTrack == index)
				{
					nodeData = current.get();
					return nodeData;
				}
				current = current.next;
				nodeTrack++;
			}
			return null;	
	}

//
//	//checks if there is a list
	@Override
	public boolean isEmpty() 
	{
		NodeGeneric<T> current = head;
		if (current == null)
		{
			return true;
		}
		return false;
	}
//	}
//
//	//return the size of the list
	public int size() 
	{
		return size;
	}
	
//	//Take each element of the list a writes them to a string 
	@Override
	public String toString() 
	{
		NodeGeneric<T> current = head;
		String result = "";
		while (current !=  null)
		{
			result += current.get();
			if (current.next != null)
			{
				result += " ";
			}
			current = current.next;
		}
		return result;
		
	}

	//add the parameter item at of the end of the list
	@Override
	public boolean add(Object obj) {
		T changeType = (T) obj;
		NodeGeneric<T> newNode = new NodeGeneric<T>(null, tail, changeType);
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

	//add item at parameter's index
	@Override
	public boolean add(int index, Object obj) {
		T changeType = (T) obj;
		if (index < 0 || index >= size)
		{
			return false;			
		}
		else if (index == 0)
		{
			
			NodeGeneric<T> newNode = new NodeGeneric<T>(head, null, changeType);
			head.prev = newNode;
			head = newNode;
		}
		else if (index == size)
		{
			NodeGeneric<T> newNode = new NodeGeneric<T>(null, tail, changeType);
			
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		else
		{
			NodeGeneric<T> current = head;
			for (int i = 0;i < index;i++)
			{
				current = current.next;
			}
			NodeGeneric<T> newNode = new NodeGeneric<T>(current,current.prev,changeType);				
			current.prev.next = newNode;
			current.prev = newNode;
		}
		size++;
		return true;
	}

	//searches list for parameter's String return true if found
	@Override
	public boolean contains(Object obj) 
	{
		T changeType = (T) obj;
		NodeGeneric<T> current = head;
		while(current != null)
		{
			if (current.get().equals(obj))
			{
				return true;
			}
			current = current.next;
			
		}
		return false;
	}

	//removes the parameter's item form the list
	/*does the removal job by first making a pointer current pointing to head(since its generic it can have any data type), looping through as long as head is not null
	 * then checks if the head node is equal to obj (parameter object) if yes then another check:if there is only node in list,
	 * then set those head and tail to null exit the loop, decrement size and return true, then elseif checks if it is only head node and if head is not null(if yes then set its previous node to null,
	 *  point the current next to head.
	 * another elseif its tail(meaning node at last) point the current's previous to tail and check if tail is not null same as before if yes then but this time set its next node to null since its last node.
	 * then else part,  the node is in middle, points middle node next to its previous next, and middle node
	 * previous to its previous next(meaning change the pointers to the current), decrease the size and return true
	 * travers through the node, otherwise return false  */
	@Override
	public boolean remove(Object obj)
	{
		NodeGeneric<T> current = head;
		while(current != null)
		{
			if (current.get().equals(obj))
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
					tail = current.prev;
					if (tail != null) 
					{
						tail.next = null;
					}
				}	
				else
//					(current != head && current != tail)
				{
					current.prev.next = current.next;
					current.next.prev = current.prev;
					
				}
				size--;
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
	public static void main(String[] args) {
		DSEListGeneric<String> demolist1 = new DSEListGeneric<>();
		DSEListGeneric<String> demolist2 = new DSEListGeneric<>();
		
		demolist1.add("Ashish");
		demolist2.add("Ashish");
		demolist1.remove("Ashish");
		System.out.println("Original" + demolist1);
		System.out.println("copy" + demolist2);
//		boolean check2 = demolist1.add(1,"behal");
		
	}
	
}
