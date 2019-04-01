/**
 * 
 */
package edu.ncsu.csc216.travel.list_utils;

/**
 * SortedLinkedListWithIterator class which represents a list which is sorted and whose elements never duplicate.
 * @author dkudo
 * @param <E> : Object type of this 
 *
 */
public class SortedLinkedListWithIterator<E extends Comparable<E>> implements SortedList<E> {
	
	/** Node object which is a head one of this linked list */
	private Node head;
	/** Number of elements (i.e. Nodes) of this List */
	private int size;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E e) {
		if (this.indexOf(e) == -1){
			return false;
		}
		return true;
	}

	@Override
	public boolean add(E e) {
		// @return true (as specified by {@link Collection#add})
		// @throws NullPointerException if e is null
		// @throws IllegalArgumentException if list already contains e
		
		if (e == null) {
			throw new NullPointerException();
		}
		
		if (this.contains(e)) {
			throw new IllegalArgumentException();
		}
		
		// if size = 0
		if (this.head == null) {
			this.head = new Node(e, null);
			size++;
			return true;
		}
		
		// compare with first element
		
		// if new element should be first
		if (this.head.value.compareTo(e) > 0) {
			this.head = new Node(e, this.head);
			size++;
			return true;
		}
		
		// if size = 1, then new element should be last
		if (this.size == 1) {
			this.head.next = new Node(e, null);
			size++;
			return true;
		}
		
		Node current = head;
		
		// if new element should be middle
		while (current.next != null) {
			if (current.next.value.compareTo(e) > 0) {
				current.next = new Node(e, current.next);
				size++;
				return true;
			}
			current = current.next;
		}
		
		
		// insert at the last
		current.next = new Node(e, null);
		size++;
		return true;
		
	}

	@Override
	public E get(int index) {
		// @throws IndexOutOfBoundsException if the index is out of range (index < 0
	    //           || index >= size())
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node current = this.head;
		for (int i = 0 ; i <= index - 1 ; i++) {
			current = current.next;
		}
		return current.value;
	}

	@Override
	public E remove(int index) {
		// * @throws IndexOutOfBoundsException if the index is out of range (index < 0
	    //              || index >= size())
	    
		
		E toBeRemoved = null;
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		//if size = 1
		if (this.size == 1) {
			toBeRemoved = this.head.value;
			size--;
			this.head = null;
			return toBeRemoved;
		}
		
		//remove from front
		if (index == 0) {
			toBeRemoved = this.head.value;
			this.head = this.head.next;
			this.size--;
			return toBeRemoved;
		}
		
		
		Node current = this.head;
		for (int i = 0 ; i < index - 1 ; i++) {
			current = current.next;
		}
		toBeRemoved = current.next.value;
		current.next = current.next.next;
		this.size--;
		return toBeRemoved;
	}

	@Override
	public int indexOf(E e) {
		// @return the index of the first occurrence of the specified element in
	    //         this list, or -1 if this list does not contain the element
	    
		
		if (this.size == 0) {
			return -1;
		}
		Node current = this.head;

		for (int i = 0 ; current.next != null ; i++ ) {
			if (current.value == e) {
				return i;
			}
			current = current.next;
		}
		
		// check the last node
		if (current.value.equals(e)){
			return this.size - 1;
		}
		return -1;
	}
	
	/**
	 * Returns a SimpleListIterator. 
	 * @return Cursor object which is for traversing the array.
	 */
	public SimpleListIterator<E> iterator() {
		return new Cursor();	
	}
	
	/**
	 * Returns a string representation of the list in the format [A,B,...,X] 
	 * where A is the first list item, B is the second, …, and X is the last
	 */
	@Override
	public String toString() {
		return "";
	}
	
	
	/**
	 * Node class which is used for outer LinkedList.
	 * @author dkudo
	 * @param <E> : type of value stored in this node
	 */
	private class Node {
		/** value held in this Node. */
		E value;
		/** next Node which is linked from this Node. */
		private Node next;
		
		/**
		 * Constructs Node object
		 * @param value : value held in this Node
		 * @param next : next Node which is linked from this Node
		 */
		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}	
	}
	
	/**
	 * Cursor class which is a iterator for traveling through the list, one item at a time
	 * @author dkudo
	 *
	 */
	private class Cursor implements SimpleListIterator<E> {
		/** current index of this Coursor which begins from 0 */
		private int nextIndex = 0;

		@Override
		public boolean hasNext() {
			if (nextIndex < SortedLinkedListWithIterator.this.size) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			this.nextIndex++;
			return SortedLinkedListWithIterator.this.get(nextIndex - 1);
		}	
	}

}
