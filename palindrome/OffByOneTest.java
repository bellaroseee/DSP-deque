package deque.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class OffByOneTest {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        //The autograder will replace this instance with various buggy implementations to run “meta-tests”
        // that test the thoroughness of your tests.
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('!', '"'));

        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('c', 'a'));
        assertFalse(offByOne.equalChars('a', 'w'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('a', 'B'));

    }
}
