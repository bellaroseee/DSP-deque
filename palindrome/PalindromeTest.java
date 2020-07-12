package deque.palindrome;

import deque.Deque;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class PalindromeTest {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static DNABasePair dnaBasePair = new DNABasePair();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);

        d = palindrome.wordToDeque("");
        actual = "";
        assertEquals("", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("persiflage"));

        assertTrue(palindrome.isPalindrome("aabbaa"));

        assertTrue(palindrome.isPalindrome("caabaac"));

        assertTrue(palindrome.isPalindrome(""));

        assertTrue(palindrome.isPalindrome("e"));

        assertTrue(palindrome.isPalindrome("aba"));

        assertTrue(palindrome.isPalindrome("abcdedcb", offByOne));

        assertFalse(palindrome.isPalindrome("aba", offByOne));

        assertTrue(palindrome.isPalindrome("abcddcb", offByOne));

        assertFalse(palindrome.isPalindrome("abbcdedc", offByOne));

        //testing for bad cases
        //upper / lower case
        /**
         * From here to below, causes the buggypalindrome test to fail.
         */
        assertFalse(palindrome.isPalindrome("ABCcba"));
        assertFalse(palindrome.isPalindrome("ADEFedeb", offByOne));
        //non alphabetical characters
        assertTrue(palindrome.isPalindrome("!!: :!!"));
        assertFalse(palindrome.isPalindrome("?!!##?!"));
        assertTrue(palindrome.isPalindrome("1! 2", offByOne));
        //combination
        assertFalse(palindrome.isPalindrome("A!bB!a"));
    }

    @Test
    public void testRandPalindrome() {
        System.out.println(dnaBasePair.randomPalindrome(4));
        System.out.println(dnaBasePair.randomPalindrome(5));
    }
}
