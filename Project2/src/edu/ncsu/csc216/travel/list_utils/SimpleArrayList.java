/**
 * 
 */
package edu.ncsu.csc216.travel.list_utils;

/**
 * SimpleArrayList class which represents the array of Objects
 * @author dkudo
 * @param <E> : Object type of elemnts of this array.
 *
 */
public class SimpleArrayList<E> implements SimpleList<E> {

	/** size of this array which is used for both the initial size and also for the size extension. */
	private static final int RESIZE = 12;
	/** list used for holding elements of this array. */
	private E[] list;
	/** current number of elements in this array. */
	private int size;
	

	/**
	 * Constructs SimpleArrayList.
	 */
	public SimpleArrayList() {
		this(RESIZE);
	}
	
	/**
	 * Constructs SimpleArrayList of a given size.
	 * @param initialCap : internal maximum size for initialization
	 * @throws IllegalArgumentException : if given capacity is 0 or less.
	 */
	@SuppressWarnings("unchecked")
	public SimpleArrayList(int initialCap) {
		if (initialCap <= 0) {
			throw new IllegalArgumentException();
		}
		this.list = (E[]) new Object[initialCap];
		this.size = 0;
	}
	
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
		for (int i = 0 ; i < this.size ; i++) {
			if (this.list[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E e) {
		this.add(this.size(), e);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int pos, E e) {
		// @throws NullPointerException if the specified element is null and this
	    //             list does not permit null elements
	    // @throws IllegalArgumentException if some property of the specified
	    //             element prevents it from being added to this list
	    // @throws IndexOutOfBoundsException if the index is out of range 
	    //             (pos < 0 || pos > size())
		
		
		if (pos < 0 || pos > size()) {
			throw new IndexOutOfBoundsException();
		}		
		
		if (e == null) {
			throw new NullPointerException();
		}
		
		if (this.contains(e)) {
			throw new IllegalArgumentException();
		}
		
		// if the current array is full of elements
		if (this.list.length == this.size()) {
			E[] currentList = this.list;
			this.list = (E[]) new Object[this.list.length + RESIZE];
			
			for (int i = 0 ; i < currentList.length ; i++) {
				this.list[i] =  currentList[i];
			}
		}
		if (0 < this.size) {
			for (int i = this.size - 1 ; pos <= i ; i--) {
				this.list[i+1] = this.list[i];
			}
		}
		this.list[pos] = e;
		this.size++;
	}

	@Override
	public E remove(int pos) {
		// @throws IndexOutOfBoundsException if the index is out of range (pos < 0
	    //             || pos >= size())
		
		if (pos < 0 || pos >= this.size()){
			throw new IndexOutOfBoundsException();
		}
		
		E toBeRemoved = this.list[pos];
		for (int i = pos ; i < this.size ; i++) {
			this.list[i] = list[i + 1];
		}
		
		this.list[this.size - 1] = null;
		this.size--;
		return toBeRemoved;
	}

	@Override
	public E get(int pos) {
		//  @throws IndexOutOfBoundsException if the index is out of range (pos < 0
	    //             || pos >= size())
		if (pos < 0 || pos >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return this.list[pos];
	}

	@Override
	public int indexOf(E e) {
		// @return the index of the first occurrence of the specified element in
	    //         this list, or -1 if this list does not contain the element
		for (int i = 0 ; i < this.size ; i++) {
			if (this.list[i] == e) {
				return i;
			}
		}
		return -1;
	}

}
