/**
 * 
 */
package tableau;

/**
 * This class represents a tool used to perform a binary search on a generic array.
 * @author Brian Park
 */
public class BinarySearch<T extends Comparable<T>> {

	/**
	 * Searches for an element in an array. Array must be sorted - otherwise, 
	 * behavior is undefined.
	 *  
	 * @param array: Represents the array to be searched
	 * @param element: Represents the element that is being searched for
	 * @return boolean representing whether or not element was found in array
	 * 
	 */
	public boolean search(T[] array, T element) {
		if (array.length == 0)
			return false;
		return searchHelper(array, element, 0, array.length - 1);
	}
	
	// Recursive method used to search the array
	private boolean searchHelper(T[] array, T element, int startIndex, int endIndex) {
		
		// guard clauses; if element is not contained between elements, return false
		if (element.compareTo(array[startIndex]) == -1)
			return false;
		if (element.compareTo(array[endIndex]) == 1)
			return false;
	
		int half = (endIndex - startIndex)/2;
		
		// check the element halfway between the start and end indices
		// if it does not match the element, recursively check the appropriate half of the indices
		if (element.compareTo(array[startIndex + half]) == -1)
			return searchHelper(array, element, startIndex, startIndex + half - 1);
		else if (element.compareTo(array[startIndex + half]) == 1)
			return searchHelper(array, element, startIndex + half + 1, endIndex);
		else 
			return true;
	
	}
}

