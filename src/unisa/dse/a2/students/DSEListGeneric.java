package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.ListGeneric;

/**
 * @author simont
 *
 */
public class DSEListGeneric<T> implements ListGeneric {
	
	public NodeGeneric<T> head;
	private NodeGeneric<T> tail;

	public DSEListGeneric() {
		
	}
	public DSEListGeneric(NodeGeneric head_) {
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEList other) { // Copy constructor. 
	}

	//remove and return the item at the parameter's index
	public void remove(int index) {

	}

	//returns the index of the String parameter 
	public int indexOf(T obj) {
	}
	
	//returns item at parameter's index
	public T get(int index) {
	}

	//checks if there is a list
	public boolean isEmpty() {
	}

	//return the size of the list
	public int size() {
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	}

	//add the parameter item at of the end of the list
	public boolean add(T obj) {
	}

	//add item at parameter's index
	public boolean add(int index, T obj) {
	}

	//searches list for parameter's String return true if found
	public boolean contains(T obj) {
	}

	//removes the parameter's item form the list
	public boolean remove(T obj) {
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
}
