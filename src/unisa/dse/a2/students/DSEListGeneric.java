package unisa.dse.a2.students;
import unisa.dse.a2.interfaces.ListGeneric;
import unisa.dse.a2.students.NodeGeneric;

/**
 * @author simont
 *
 */
public class DSEListGeneric<T> implements ListGeneric {
	
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
		NodeGeneric<T> current = other.head;
		 
		while(current != null)
		{
			T current_data = current.get();
			
			this.add(current_data);
			current = current.next;
		}
	}

	//remove and return the item at the parameter's index
//	public void remove(int index) {
//
//	}
//
//	//returns the index of the String parameter 
//	public int indexOf(T obj) {
//	}
//	
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
		else
		{
			while (current != null)
			{
				if (nodeTrack == index)
				{
					nodeData = current.get();
				}
				current = current.next;
				nodeTrack++;
			}
			return (T) nodeData;
		}
	}
//
//	//checks if there is a list
//	public boolean isEmpty() {
//	}
//
//	//return the size of the list
//	public int size() {
//	}
//	
//	//Take each element of the list a writes them to a string 
//	@Override
//	public String toString() {
//	}

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
		if (index < 0 || index > size)
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
//	public boolean remove(T obj) {
//	}
	
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
		
		boolean check = demolist1.add("Ashish");
		boolean check2 = demolist1.add(1,"behal");
		System.out.println(check);
		System.out.println(check2);
		System.out.println(demolist1.toString());
	}
	
}
