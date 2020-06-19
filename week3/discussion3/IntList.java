/**
 * Implementing Sans in Exam Prep 3.
 * Writing functions in a recursive way always makes me confused...
 */

public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Non-destructively creates a copy of x that contains no y */
    public static IntList ilsans(IntList x, int y) {
        if (x == null) {
            return null;
        }
        if (x.first == y) {
            return ilsans(x.rest, y);
        }
        return new IntList(x.first, ilsans(x.rest, y));
    }

    /** Destructively creates a copy of x that contains no y,
     *  without using the keyword "new". */
    public static IntList dilsans(IntList x, int y) {
        if (x == null) {
            return null;
        }
        x.rest = dilsans(x.rest, y);
        if (x.first == y) {
            return x.rest;
        }
        return x;
    }
}
