import org.junit.Test;
import static org.junit.Assert.*;

public class testSLList {
    @Test
    public void testInsert() {
        SLList expected = new SLList();
        expected.addFirst(3);
        expected.addFirst(2);
        expected.addFirst(4);
        expected.addFirst(1);

        SLList actual = new SLList();
        actual.addFirst(3);
        actual.addFirst(2);
        actual.addFirst(1);

        actual.insert(4, 1);

        for (int i = 0; i < actual.length(); i++) {
            assertEquals("Checking item with index " + i, expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testReverseIterative() {
        SLList expected = new SLList();
        expected.addFirst(4);
        expected.addFirst(3);
        expected.addFirst(2);
        expected.addFirst(1);

        SLList actual = new SLList();
        actual.addFirst(1);
        actual.addFirst(2);
        actual.addFirst(3);
        actual.addFirst(4);

        actual.reverseIterative();

        for (int i = 0; i < actual.length(); i++) {
            assertEquals("Checking item with index " + i, expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testReverseRecursive() {
        SLList expected = new SLList();
        expected.addFirst(4);
        expected.addFirst(3);
        expected.addFirst(2);
        expected.addFirst(1);

        SLList actual = new SLList();
        actual.addFirst(1);
        actual.addFirst(2);
        actual.addFirst(3);
        actual.addFirst(4);

        actual.reverseRecursive();

        for (int i = 0; i < actual.length(); i++) {
            assertEquals("Checking item with index " + i, expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testArrayInsert() {
        int[] expected = new int[] {1, 2, 3, 4, 5, 6};

        int[] original = new int[] {1, 2, 3, 5, 6};
        int[] actual = SLList.insert(original, 4, 3);

        assertArrayEquals(expected, actual);

        int[] original1 = new int[] {1, 2, 3, 4, 5};
        int[] actual1 = SLList.insert(original1, 6, 10);
        assertArrayEquals(expected, actual1);
    }

    @Test
    public void testArrayReverse() {
        int[] expected = new int[] {1, 2, 3, 4, 5, 6};
        int[] actual = new int[] {6, 5, 4, 3, 2, 1};
        SLList.reverse(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testArrayReplicate() {
        int[] expected = new int[] {2, 2, 3, 3, 3, 2, 2, 1};
        int[] original = new int[] {2, 3, 2, 1};
        int[] actual = SLList.replicate(original);

        assertArrayEquals(expected, actual);
    }
}