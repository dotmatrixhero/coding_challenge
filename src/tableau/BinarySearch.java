/**
 * 
 */
package tableau;

/**
 * @author bpark92
 *
 */
public class BinarySearch<T extends Comparable<T>> {

	/**
	 * @param args
	 */
	public boolean search(T[] array, T element) {
			
		return searchHelper(array, element, 0, array.length - 1);
	}
	
	private boolean searchHelper(T[] array, T element, int startIndex, int endIndex) {
		if (element.compareTo(array[startIndex]) == -1)
			return false;
		if (element.compareTo(array[endIndex]) == 1)
			return false;
	
		int half = (startIndex - endIndex)/2;
		
		if (element.compareTo(array[half]) == -1)
			return searchHelper(array, element, startIndex, half);
		else if (element.compareTo(array[half]) == 1)
			return searchHelper(array, element, half + 1, endIndex);
		else 
			return true;
	
	}
}

