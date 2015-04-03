package howard.edu.sycs363.spring15.lab5;

/*
 * Lab 3
 * @author Joanna Phillip
 */

public class IntegerArrayList {
	
	/*
	 * array where the integers are stored/managed
	 */
	private int[] list = {};
	/*
	 * maintains the number of items added to the list via Add and Remove operations
	 */
	private int numberOfItems = 0;
	
	/*
	 * Default constructor. Implies that the
	 * default size of the array is 0
	 */
	public IntegerArrayList()
	{
	}
	
	/*
	 * Custom constructor sets the size of the array
	 * 
	 * @param initialSize	the initial size of the array
	 */
	public IntegerArrayList(int initialSize)
	{
		list = new int[initialSize];
	}
	
	/*
	 * Increases the array size by one, and adds the new value
	 * to the end of the array
	 * 
	 * @param value	the value to be added to the array
	 */
	public void Add(int value)
	{
		int listSize = list.length;
		int[] temp = list;
		// grow the list size by 1
		list = new int[++listSize];
		for (int i = 0; i < listSize-1; i++)
		{
			// fill in the old values to the new list
			list[i] = temp[i];
		}
		// add specified value to the end of the list
		list[listSize-1] = value;
		numberOfItems++;
	}
	
	/*
	 * Adds a value to the array at a specified index
	 * 
	 * @param	index							the index of the array the value will be stored
	 * @param 	value							the value to be stored at the index of the array
	 * @throws	ArrayIndexOutOfBoundsException	exception is thrown if the index provided is not within the bounds of the array
	 */
	public void Add(int index, int value)
	{
		if (index >= list.length)
		{
			throw new ArrayIndexOutOfBoundsException("Add: The index provided is out of the array bounds!");
		}

		list[index] = value;
		numberOfItems++;
	}
	
	/*
	 * Gets the value at the specified index
	 * 
	 * @param	index							index of the array where the value will be returned
	 * @throws	ArrayIndexOutOfBoundsException	exception is thrown if the index provided is not within the bounds of the array
	 * @return									value at specified index
	 */
	public int Get(int index)
	{
		if (index >= list.length)
		{
			throw new ArrayIndexOutOfBoundsException("The index provided is out of the array bounds!");
		}

		return list[index]; 
	}
	
	/*
	 * Tries to get the first index of the specified value
	 * 
	 * @param	value	a possible value in the array
	 * @return			the first index where the specified value is found, otherwise -1 if not found
	 */
	public int IndextOf(int value)
	{
		for (int i = 0; i < list.length; i++)
		{
			if (list[i] == value)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/*
	 * Checks to see if the array is empty
	 * 
	 * @return		true if empty, and false otherwise
	 */
	public boolean IsEmpty()
	{
		if (numberOfItems == 0)
		{
			return true;
		}
		return false;
	}
	
	/* 
	 * Removes the integer at specified index, reduces the size of the list by one and returns the value that was removed
	 * 
	 * @param	index							specified index of value to be removed and returned
	 * @throws	ArrayIndexOutOfBoundsException	exception is thrown if the index provided is not within the bounds of the array
	 * @return									the value removed at specified index
	 */
	public int Remove(int index)
	{
		if (index >= list.length)
		{
			throw new ArrayIndexOutOfBoundsException("The index provided is out of the array bounds!");
		}
		
		int listSize = list.length;
		int[] temp = list;
		// shrink the list by 1
		list = new int[--listSize];
		
		int j = 0;
		for (int i = 0; i < listSize+1; i++)
		{
			if (i != index)
			{
				// fill in old values (without the removed value) to the new list
				list[j++] = temp[i];
			}
		}
		
		numberOfItems--;
		// return removed value from old list
		return temp[index];
	}
	
}
