package deque;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Performs some basic linked deque tests. */
public class LinkedDequeTest {

    /** Adds a few strings to the deque, checking isEmpty() and size() are correct. */
    @Test
    public void addIsEmptySizeTest() {
        LinkedDeque<String> lld = new LinkedDeque<>();
        assertTrue(lld.isEmpty());

        lld.addFirst("front");
        assertEquals(1, lld.size());
        assertFalse(lld.isEmpty());

        lld.addFirst("second front");
        assertEquals(2, lld.size());
        assertFalse(lld.isEmpty());

        lld.addLast("middle");
        assertEquals(3, lld.size());

        lld.addLast("back");
        assertEquals(4, lld.size());
    }

    /** Adds an item, then removes an item, and ensures that the deque is empty afterwards. */
    @Test
    public void addRemoveTest() {
        LinkedDeque<Integer> lld = new LinkedDeque<>();
        assertTrue(lld.isEmpty());

        lld.addLast(10);

        lld.addFirst(20);
        assertFalse(lld.isEmpty());

        lld.addLast(30);
        assertFalse(lld.isEmpty());

        long i = lld.removeLast();
        assertEquals(30, i);

        lld.addLast(40);
        assertFalse(lld.isEmpty());

        i = lld.removeLast();
        assertEquals(40, i);

        i = lld.removeLast();
        assertEquals(10, i);
    }

    @Test
    public void anotherAddRemoveTest() {
        LinkedDeque<Integer> lld = new LinkedDeque<>();
        assertTrue(lld.isEmpty());

        lld.addFirst(10);
        assertFalse(lld.isEmpty());

        lld.addLast(20);
        assertFalse(lld.isEmpty());

        lld.addFirst(30);
        assertFalse(lld.isEmpty());

        lld.addLast(40);
        assertFalse(lld.isEmpty());

        long i = lld.removeLast();
        assertEquals(40, i);

        i = lld.removeFirst();
        assertEquals(30, i);

        i = lld.removeLast();
        assertEquals(20, i);

        i = lld.removeLast();
        assertEquals(10, i);
    }

    @Test
    public void getTest() {
        LinkedDeque<String> lld = new LinkedDeque<>();
        assertTrue(lld.isEmpty());

        lld.addFirst("front");

        lld.addFirst("front front");

        lld.addLast("middle");

        lld.addLast("back");

        lld.get(1);
        assertEquals("front front", lld.get(1));

        assertEquals("front", lld.get(2));
        assertEquals("middle", lld.get(3));
        assertEquals("back", lld.get(4));

        lld.get(5);


    }
}
