/**
 * 
 */
package edu.ncsu.csc216.travel.list_utils;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for SimpleArrayList class.
 * @author dkudo
 *
 */
public class SimpleArrayListTest {

		/**
		 * Tests constructor
		 */
		@Test
		public void testArrayList() {
			SimpleArrayList<String> l = new SimpleArrayList<String>();
			assertEquals(0, l.size());
			
			SimpleArrayList<String> l2 = new SimpleArrayList<String>(5);
		assertEquals(0, l2.size());
	}
	
	/**
	 * Tests add
	 */
	@Test
	public void testAdd() {
		SimpleArrayList<String> l = new SimpleArrayList<String>(5);
		// adding an element to list whose length is 0
		l.add(0, "b");
		// adding an element to the front of the list
		assertEquals(1, l.size());
		l.add(0, "a");
		assertEquals(2, l.size());
		assertEquals("a", l.get(0));
		assertEquals("b", l.get(1));
		//adding an element to the back of the list
		l.add(2, "d");
		assertEquals(3, l.size());
		assertEquals("a", l.get(0));
		assertEquals("b", l.get(1));
		assertEquals("d", l.get(2));
		//adding new element to the middle of the list.
		l.add(2, "c");
		assertEquals(4, l.size());
		assertEquals("a", l.get(0));
		assertEquals("b", l.get(1));
		assertEquals("c", l.get(2));
		assertEquals("d", l.get(3));
		
		// try to add from 12 to 13(internally resized)
		l.add(4, "e");
		l.add(5, "f");
		assertEquals(6, l.size());
		assertEquals("f", l.get(5));
		
		// try to add null element
		try {
			l.add(0, null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(6, l.size());
		}
			
		// try to add at index less than 0
		try {
			l.add(-1, "a");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(6, l.size());
		}
		
	}
	
	/**
	 * Tests remove()
	 */
	@Test
	public void testRemove() {
		SimpleArrayList<String> l = new SimpleArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		// remove from back
		String d = l.remove(3);
		assertEquals(3, l.size());
		assertEquals("d", d);
		// remove from middle
		String b = l.remove(1);
		assertEquals(2, l.size());
		assertEquals("b", b);
		
		//remove from front
		String a = l.remove(0);
		assertEquals(1, l.size());
		assertEquals("a", a);
		
		// try to remove from index larger or equal to size
		try {
			l.remove(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(1, l.size());
		}
		
		// try to remove from index less than 0
		try {
			l.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(1, l.size());
		}
	}
	
	/**
	 * Tests isEmpty() and contains() and get()
	 */
	@Test
	public void testOthers() {
		SimpleArrayList<String> l = new SimpleArrayList<String>();
		assertTrue(l.isEmpty());
		l.add("a");
		l.add("b");
		l.add("c");
		assertFalse(l.isEmpty());
		
		// test outOfBounds of get()
		try {
			l.get(-1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(3, l.size());
		}
		try {
			l.get(3);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(3, l.size());
		}
		
		assertTrue(l.contains("a"));
		assertFalse(l.contains("not"));
			
		
	}
}