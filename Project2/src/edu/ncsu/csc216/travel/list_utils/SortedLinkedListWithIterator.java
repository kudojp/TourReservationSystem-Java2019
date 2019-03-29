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
	private Node<E> head;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Returns a SimpleListIterator. 
	 * @return Cursor object which is for traversing the array.
	 */
	public SimpleListIterator<E> iterator() {
		return null;	
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
	private static class Node<E> {
		/** value held in this Node. */
		E value;
		/** next Node which is linked from this Node. */
		private Node<E> next;
		
		/**
		 * Constructs Node object
		 * @param value : value held in this Node
		 * @param next : next Node which is linked from this Node
		 */
		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}	
	}
	
	/**
	 * Cursor class which is for traveling through the list, one item at a time
	 * @author dkudo
	 *
	 */
	private class Cursor implements SimpleListIterator<E> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}	
	}

}
