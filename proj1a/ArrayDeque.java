public class ArrayDeque<T> {
    private T[] items;
    /** Record the start index since we are using the circular approach. */
    private int newStart;
    private int newEnd;
    private int size;

    /** Creates a null deque of size 8. */
    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T[]) new Object[8];
        newStart = 4;
        newEnd = 5;
        size = 0;
    }

    /** Resize the deque when it's full. */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (newEnd > newStart) {
            /* Copy the initial array to the last of the new array. */
            System.arraycopy(items, newEnd - size, a, capacity - size, size);
            newEnd = 0;
            newStart = capacity - size - 1;
        } else {
            /* Resize the array when newStart == newEnd. */
            System.arraycopy(items, 0, a, 0, newEnd);
            System.arraycopy(items, newStart + 1, a, capacity - (items.length - newStart - 1),
                    items.length - newStart - 1);
            /* newEnd stays while newStart changes. */
            newStart = capacity - items.length + newStart;
        }
        items = a;
    }

    /** Add item to the first of the deque. */
    public void addFirst(T item) {
        if (newStart == 0 || newStart == newEnd) {
            resize(items.length * 2);
        }
        items[newStart] = item;
        size += 1;
        newStart -= 1;
    }

    /** Add item to the last of the deque. */
    public void addLast(T item) {
        if (newEnd == newStart) {
            resize(items.length * 2);
        }
        items[newEnd] = item;
        size += 1;

        if (newEnd == items.length - 1) {
            newEnd = 0;
        } else {
            newEnd += 1;
        }
    }

    /** Check if the deque is empty. Return true if empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Return the size of the deque. */
    public int size() {
        return size;
    }

    /** Print the deque. */
    public void printDeque() {
        for (int i = 1; i <= size; i++) {
            int index = (newStart + i) % items.length;
            System.out.print(items[index]);
            System.out.print(" ");
        }
        System.out.println();
    }

    /** Remove the first item and return it. */
    public T removeFirst() {
        newStart += 1;
        size -= 1;
        return items[newStart];
    }

    /** Remove the last item and return it. */
    public T removeLast() {
        if (newEnd == 0) {
            newEnd = items.length - 1;
        } else {
            newEnd -= 1;
        }
        size -= 1;
        return items[newEnd];
    }

    public T get(int index) {
        return items[(newStart + 1 + index) % items.length];
    }

    /*
    public static void main(String[] args) {
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 16; i++) {
            l1.addFirst(i);
        }

        ArrayDeque<Integer> l2 = new ArrayDeque<Integer>();
        for (int i = 0; i < 16; i++) {
            l2.addLast(i);
        }

        l2.printDeque();
        l2.removeLast();
        l2.printDeque();
        System.out.println(l2.get(7));
        System.out.println(l2.size());
    }*/
}
