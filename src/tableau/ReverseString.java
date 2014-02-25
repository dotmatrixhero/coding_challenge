package tableau;

/**
 * This class represents a tool for reversing Strings
 * @author Brian Park
 */
public class ReverseString {


	/**
	 * Takes in a String text and returns a new String representing
	 * the text in reverse. Does not modify text.
	 * 
	 * @param text: a String representing text that is to be reversed
	 * @return String representing the text in reverse
	 */
	public static String reverse(String text)
	{
		if (text.length() <= 1)
			return text;
		
		String reverse = text;
		int half = text.length()/2;
		for (int i = 0; i < half; i++)
			reverse = swapStringIndices(reverse, i, text.length() - i - 1);
		
		return reverse;
	}
	
	// Helper method to swap indices of a String
	private static String swapStringIndices(String text, int first, int second)
	{
		char[] temp = new char[text.length()];
		
		// copy text into char array
		for(int i = 0; i < text.length(); i++)
			temp[i] = text.charAt(i);
	
		// swap the two indices and return the result as a String
		char swapTemp = text.charAt(first);
		temp[first] = text.charAt(second);
		temp[second] = swapTemp;
		return new String(temp);
	}
}
