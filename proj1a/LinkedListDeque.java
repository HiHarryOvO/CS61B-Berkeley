public class LinkedListDeque<T> {
    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;
        public TNode(T item, TNode prev, TNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /** We apply the circular sentinel method. */
    private TNode sentinel;
    private int size;

    /** Creates a null deque. */
    public LinkedListDeque() {
        sentinel = null;
        size = 0;
    }

    /** Add item to the first of the deque. */
    public void addFirst(T item) {
        if (size == 0) {
            sentinel = new TNode(item, null, null);
            sentinel.next = new TNode(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;

        } else {
            sentinel.next = new TNode(item, sentinel, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
        }
        size += 1;
    }

    /** Add item to the last of the deque. */
    public void addLast(T item) {
        if (size == 0) {
            sentinel = new TNode(item, null, null);
            sentinel.next = new TNode(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.prev = new TNode(item, sentinel.prev, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
        }
        size += 1;
    }

    /** Check if the deque is empty. Return true if empty. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Return the size of the deque. */
    public int size() {
        return size;
    }

    /** Print the deque. */
    public void printDeque() {
        TNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            System.out.print(" ");

            p = p.next;
        }
        System.out.println();
    }

    /** Remove the first item and return it. */
    public T removeFirst() {
        if (sentinel == null || sentinel.next == null) {
            return null;
        }
        T value = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;

        size -= 1;
        return value;
    }

    /** Remove the last item and return it. */
    public T removeLast() {
        if (sentinel == null || sentinel.prev == null) {
            return null;
        }
        T value = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        size -= 1;
        return value;
    }

    public T get(int index) {
        TNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(TNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }

    /*
    public static void main(String[] args) {
        LinkedListDeque<Integer> l1 = new LinkedListDeque<Integer>();
        l1.addFirst(1);
        l1.addLast(3);
        l1.addFirst(2);;
        l1.removeLast();
        l1.printDeque();
        System.out.println(l1.getRecursive(1));
        System.out.println(l1.size());
    }*/
}
