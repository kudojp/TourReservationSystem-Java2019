/**
 * 
 */
package edu.ncsu.csc216.travel.list_utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for SortedLinkedListWithWriterWithIterator class.
 * @author dkudo
 *
 */
public class SortedLinkedListWithIteratorTest {

	/**
	 * Tests SortedList() by adding elements and checking for size after.
	 */
	@Test
	public void testSortedList() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		assertFalse(list.contains("apple"));

		// Test that the list grows by adding at least 11 elements
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		list.add("k");

		assertEquals(11, list.size());
	}

	/**
	 * Tests add by adding invalid and valid elements to the list and check the
	 * status after each add command.
	 */
	@Test
	public void testAdd() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();

		list.add("b");
		assertEquals(1, list.size());
		assertEquals("b", list.get(0));

		// Test adding to the front
		try {
			list.add("a");
			assertEquals(2, list.size());
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		
		// test adding to the back
		try {
			list.add("d");
			assertEquals(3, list.size());
		} catch (IllegalArgumentException e) {
			fail();
		}

		//try adding to the middle
		try {
			list.add("c");
			assertEquals(4, list.size());
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
		assertEquals("d", list.get(3));
		
		
		
		// Test adding a null element
		try {
			list.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
		}

		// Test adding a duplicate element
		try {
			list.add("a");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(4, list.size());
		}
	}

	/**
	 * Test Get() by adding elements and calling the Get() method and checking
	 * status after each add and get command.
	 */
	@Test
	public void testGet() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();

		// Since get() is used throughout the tests to check the
		// contents of the list, we don't need to test main flow functionality
		// here. Instead this test method should focus on the error
		// and boundary cases.

		// Test getting an element from an empty list
		try {
			list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Add some elements to the list
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		// Test getting an element at an index < 0
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(5, list.size());
		}

		// Test getting an element at size
		try {
			list.get(list.size());
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(5, list.size());
		}
	}

	/**
	 * Tests Remove() by adding and removing elements checking status after each add
	 * and remove command.
	 */
	@Test
	public void testRemove() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();

		// Test removing from an empty list
		try {
			list.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Adding five elements to the list
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		// Test removing an element at an index < 0
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Test removing an element at size
		try {
			list.remove(4);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Test removing a middle element
		// after : abd
		try {
			assertEquals("c", list.remove(2));
			assertEquals(3, list.size());
		} catch (IndexOutOfBoundsException e) {
			fail();
		}

		// Test removing the last element
		//after : ab
		try {
			assertEquals("d", list.remove(2));
			assertEquals(2, list.size());
		} catch (IndexOutOfBoundsException e) {
			fail();
		}

		// Test removing the first element
		//after b
		try {
			assertEquals("a", list.remove(0));
			assertEquals(1, list.size());
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
		// Test removing the last element
		//
		try {
			assertEquals("b", list.remove(0));
			assertEquals(0, list.size());
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}

	/**
	 * Tests indexOf() by adding and getting index of specific elements and
	 * asserting if they are true or not.
	 */
	@Test
	public void testIndexOf() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();

		// Test indexOf on an empty list
		int index = list.indexOf("");
		assertEquals(-1, index);

		// Add some elements
		list.add("a");
		list.add("b");
		list.add("c");

		// Test various calls to indexOf for elements in the list
		// and not in the list
		index = list.indexOf("a");
		assertEquals(0, index);
		index = list.indexOf("c");
		assertEquals(2, index);
		index = list.indexOf("z");
		assertEquals(-1, index);

		/**
		// Test checking the index of null
		try {
			index = list.indexOf(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(3, list.size());
		}
		*/

	}


	/**
	 * Tests isEmpty() by adding elements and asserting if the list is empty.
	 */
	@Test
	public void testIsEmpty() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();

		// Test that the list starts empty
		assertTrue(list.isEmpty());

		// Add at least one element
		list.add("a");

		// Check that the list is no longer empty
		assertFalse(list.isEmpty());
	}

	/**
	 * Tests contains() by adding elements and checking if the list contains those
	 * elements.
	 */
	@Test
	public void testContains() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();

		// Test the empty list case
		assertFalse(list.contains("a"));

		// Add some elements
		list.add("a");
		list.add("b");
		list.add("c");

		// Test some true and false cases
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("z"));
	}
	
	/**
	 * Tests toString() method.
	 */
	@Test
	public void testToString() {
		SortedLinkedListWithIterator<String> list = new SortedLinkedListWithIterator<String>();

		// Add some elements
		list.add("c");
		list.add("b");
		list.add("a");
		
		assertEquals("[a, b, c]", list.toString());
	}
	
	/**
	 * Tests iterator() method and Cursor (i.e. inner class)
	 */
	@Test
	public void testIterator() {
		SortedLinkedListWithIterator<String> l = new SortedLinkedListWithIterator<String>();
		l.add("a");
		l.add("b");
		SimpleListIterator<String> c = l.iterator();
		
		assertTrue(c.hasNext());
		assertEquals("a", c.next());
		
		assertTrue(c.hasNext());
		assertEquals("b", c.next());
		
		assertFalse(c.hasNext());
		
		
		
		SortedLinkedListWithIterator<String> l2 = new SortedLinkedListWithIterator<String>();
		assertEquals("[]", l2.toString());
	}
}
