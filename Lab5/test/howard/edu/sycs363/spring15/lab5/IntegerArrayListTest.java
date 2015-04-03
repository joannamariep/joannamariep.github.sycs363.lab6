package howard.edu.sycs363.spring15.lab5;

/*
 * @author Joanna Phillip @02663087
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerArrayListTest {

	/*
	 * Test adding numbers to a list specifying only the value to be added
	 */
	@Test
	public void testAdd() {
		IntegerArrayList list = new IntegerArrayList();
		// Adding three numbers to the list
		list.Add(2);
		list.Add(15);
		list.Add(30);
		
		//Tests
		assertEquals("The first number in the list should be 2", 2, list.Get(0));
		assertEquals("The second number in the list should be 15", 15, list.Get(1));
		assertEquals("The third number in the list should be 30", 30, list.Get(2));
	}
	
	/*
	 * Test adding numbers to a list specifying both the value to be added and the index
	 */
	@Test
	public void testAddInt() {
		IntegerArrayList list = new IntegerArrayList(20);
		
		// Adding numbers at index 5 and 19
		list.Add(5, 24);
		list.Add(19, 30);
		
		//Tests
		assertEquals("The number at index 5 should be 24", 24, list.Get(5));
		assertEquals("The number at index 19 should be 30", 30, list.Get(19));
		
		try
		{
			// Try to add a number to an index that is out of bounds
			list.Add(25, 6);
			fail("The index provided is out of bounds. Add() should throw an exception");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			// expected behavior
		}
	}

	/*
	 * Test getting previously added number from a list
	 */
	@Test
	public void testGet() {
		IntegerArrayList list = new IntegerArrayList();
		// Adding numbers to list
		list.Add(2);
		list.Add(15);
		
		// Test
		assertEquals("The second number in the list should 15", 15, list.Get(1));
		
		try
		{
			// Try to get a number from an index that is out of bounds
			list.Get(20);
			fail("The index provided is out of bounds. Get() should throw an exception");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			// expected behavior
		}
	}

	/*
	 * Test getting the index of a value that could possibly be in the list
	 */
	@Test
	public void testIndextOf() {
		IntegerArrayList list = new IntegerArrayList();
		list.Add(2);
		list.Add(15);
		list.Add(15);
		
		assertEquals("The first index of the value 15 should be 1", 1, list.IndextOf(15));
		// if the item is not in the list, IndexOf should return -1
		assertEquals("The index returned from a value not in the list should be -1", -1, list.IndextOf(30));
	}

	/*
	 * Test checking if a list is empty
	 */
	@Test
	public void testIsEmpty() {
		IntegerArrayList list = new IntegerArrayList();
		// Newly created lists should be empty
		assertEquals("The list should be empty since it was newly created", true, list.IsEmpty());
		list = new IntegerArrayList(20);
		assertEquals("The list should be empty since it was newly created", true, list.IsEmpty());
		
		// Removing the last item in a list should cause subsequent IsEmpty calls to return true
		list.Add(24);
		assertEquals("The list should not be empty since a number was just added", false, list.IsEmpty());
		list.Remove(0);
		assertEquals("The list should be item since the last item was removed", true, list.IsEmpty());
		
	}
	
	/*
	 * Test removing items from a list
	 */
	@Test
	public void testRemove() {
		IntegerArrayList list = new IntegerArrayList();
		// Add and remove numbers from list and check list state
		list.Add(2);
		list.Add(15);
		list.Remove(1);
		list.Add(30);
		assertEquals("The second number in the list should be 30 since 15 was removed", 30, list.Get(1));
		list.Add(50);
		list.Add(60);
		list.Remove(2);
		assertEquals("The third number in the list should be 60 since 50 was removed", 60, list.Get(2));
		
		try
		{
			// Try to remove a number using an index that is out of bounds
			list.Remove(20);
			fail("The index provided is out of bounds. Remove() should throw an exception");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			// expected behavior
		}
	}

}
