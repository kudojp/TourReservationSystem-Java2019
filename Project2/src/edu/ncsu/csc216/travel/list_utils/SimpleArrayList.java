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
	static private int RESIZE = 12;
	/** list used for holding elements of this array. */
	private Object[] list;
	/** current size of this array. */
	private int size;
	

	/**
	 * Constructs SimpleArrayList.
	 */
	public SimpleArrayList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructs SimpleArrayList of given size.
	 * @param size : size of the array
	 */
	public SimpleArrayList(int size) {
		// TODO Auto-generated constructor stub
	}
	
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
	public void add(int pos, E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
