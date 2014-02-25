package tableau;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Simple test cases for the ReverseString class
 * @author Brian Park
 */
public class ReverseStringTest {

	static int STRESSTESTFACTOR;
	
	@Before
	public void setUp() throws Exception {
		STRESSTESTFACTOR = 1000;
	}

	@Test
	public void emptyStringTest() {
		String result = ReverseString.reverse("");
		assertEquals("Empty strings", "", result);
	}
	
	@Test
	public void singleLetterTest() {
		String result = ReverseString.reverse("a");
		assertEquals("Single letter", "a", result);
	}

	
	@Test
	public void doubleLetterTest() {
		String result = ReverseString.reverse("ab");
		assertEquals("Simple reversed letters", "ba", result);
	}

	@Test
	public void numberTest() {
		String result = ReverseString.reverse("123");
		assertEquals("Text with numbers", "321", result);
	}

	@Test
	public void textSpaceTest() {
		String result = ReverseString.reverse("Hi everyone!");
		assertEquals("Text with a space", "!enoyreve iH", result);
	}

	@Test
	public void doubleReverseTest() {
		String text = "I want to work at Tableau.";
		doubleReverse(text);
	}
	
	// Create a random jumble of numbers and periods, then test
	// using the doubleReverse() method
	@Test
	public void doubleReverseStressTest() {
		String text = null;
		for (int i = 0; i < STRESSTESTFACTOR; i++)
			text += new Double(Math.random()).toString();
		doubleReverse(text);
	
	}
	
	// Create a random jumble of numbers and periods, then test
	// using the throroughTest() method
	@Test
	public void thoroughTestStressTest() {
		String text = null;
		for (int i = 0; i < STRESSTESTFACTOR; i++)
			text += new Double(Math.random()).toString();
		thoroughTest(ReverseString.reverse(text), text);
	}

	
	// Reverses the text, makes sure that they are not equal, then
	// reverses it again to make sure it is equal.
	private void doubleReverse(String text) {
		String result = ReverseString.reverse(text);
		assertNotEquals("Text should be reversed", text, result);
		result = ReverseString.reverse(result);
		assertEquals("Text should be the same", text, result);
	}


	// Checks each index of two strings, make sure that they are reversed.
	private void thoroughTest(String result, String text) {
		assertEquals(text.length(), result.length());
		char[] tempText = new char[text.length()];
		char[] tempResult = new char[text.length()];
		
		for(int i = 0; i < text.length(); i++)
		{
			tempText[i] = text.charAt(i);
			tempResult[i] = result.charAt(i);
		}
		
		for(int i = 0; i < text.length(); i++)
			assertEquals("Chars should match at indices", tempText[i], 
					tempResult[text.length() - i - 1]);
		
	}
}
