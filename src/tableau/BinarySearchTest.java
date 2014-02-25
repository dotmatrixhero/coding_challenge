package tableau;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Simple test cases for the BinarySearch class
 * @author Brian Park
 */
public class BinarySearchTest {

	BinarySearch<Integer> IntegerSearcher;
	BinarySearch<Double> DoubleSearcher;
	static int STRESSTESTFACTOR;
	
	@Before
	public void setUp() throws Exception {
		STRESSTESTFACTOR = 1000;
		IntegerSearcher = new BinarySearch<Integer>();
		DoubleSearcher = new BinarySearch<Double>();	
	}
	
	@Test
	public void noElementEmptyArray() {
		Integer[] array = { };
		boolean result = IntegerSearcher.search(array, 0);
		assertFalse("Search for non-existent element in empty array", result);
	}
	
	@Test
	public void noElementFullArray() {
		Integer[] array = { 1, 2 , 5, 8 };
		boolean result = IntegerSearcher.search(array, 3);
		assertFalse("Search for non-existent element in empty array", result);
	}
	
	@Test
	public void lowElementFullArray() {
		Integer[] array = { 1, 2 , 5, 8 };
		boolean result = IntegerSearcher.search(array, 0);
		assertFalse("Search for non-existent element in empty array", result);
	}
	
	@Test
	public void highElementFullArray() {
		Integer[] array = { 1, 2 , 5, 8 };
		boolean result = IntegerSearcher.search(array, 67);
		assertFalse("Search for non-existent element in empty array", result);
	}
	
	@Test
	public void firstElementOddArray() {
		Integer[] array = { 0, 1, 2 , 3, 4, 5, 6, 7, 8, 9};
		boolean result = IntegerSearcher.search(array, 0);
		assertTrue("Search for first element in odd numbered array", result);
	}
	
	@Test
	public void lastElementOddArray() {
		Integer[] array = { 0, 1, 2 , 3, 4, 5, 6, 7, 8, 9};
		boolean result = IntegerSearcher.search(array, 9);
		assertTrue("Search for last element in odd numbered array", result);
	}
	
	@Test
	public void findElementOddArray() {
		Integer[] array = { 0, 1, 2 , 3, 4, 5, 6, 7, 8};
		boolean result = IntegerSearcher.search(array, 4);
		assertTrue("Search for element in odd numbered array", result);
	}
	
	@Test
	public void firstElementEvenArray() {
		Integer[] array = { 0, 1, 2 , 3, 4, 5, 6, 7, 8};
		boolean result = IntegerSearcher.search(array, 0);
		assertTrue("Search for last element in odd numbered array", result);
	}
	
	@Test
	public void lastElementEvenArray() {
		Integer[] array = { 0, 1, 2 , 3, 4, 5, 6, 7, 8};
		boolean result = IntegerSearcher.search(array, 8);
		assertTrue("Search for last element in odd numbered array", result);
	}
	
	@Test
	public void findElementEvenArray() {
		Integer[] array = { 0, 1, 2 , 3, 4, 5, 6, 7, 8};
		boolean result = IntegerSearcher.search(array, 3);
		assertTrue("Search for random element in odd numbered array", result);
	}
	
	@Test
	public void negativeElementEvenArray() {
		Integer[] array = { -87, -5, -2 , -1, 4, 5, 6, 7, 8};
		boolean result = IntegerSearcher.search(array, -87);
		assertTrue("Search for random element in odd numbered array", result);
	}
	
	@Test
	public void findFirstDouble() {
		Double[] array = { -1.0, 0.0, 1.5, 1.75 };
		boolean result = DoubleSearcher.search(array, -1.0);
		assertTrue("Search for double in array", result);
	}
	
	// Create a number of arrays, fill them with numbers 
	// and search for random numbers in the range of the array
	@Test
	public void smallStressTest() {
		for (int i = 1; i < STRESSTESTFACTOR; i++)
		{
			Integer[] array = new Integer[i];
			Integer randomTest = 0;
			for (int j = 0; j < i; j++)
			{
				array[j] = j;
				randomTest = (int) Math.ceil(Math.random() * j);
			}			
			boolean result = IntegerSearcher.search(array, randomTest);
			assertTrue("Finding random number in range of array", result);
		}
	}

}
