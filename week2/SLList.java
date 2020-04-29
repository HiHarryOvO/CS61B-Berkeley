public class SLList {
	private int size;

	/** The first item (if exists) is sentinel.next */
	private IntNode sentinel;

	public SLList() {
		sentinel = new IntNode(22, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(22, null);

		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/** Add x to the front of the list */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	/** Returns the first value in the list */
	public int getFirst() {
		return sentinel.next.item;
	}

	public void addLast(int x) {
		IntNode p = first;

		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);

		size += 1;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		/* Creates a list of integers */
		SLList L = new SLList(15);
		L.addFirst(10);
		L.addFirst(5);

		System.out.println(L.getFirst());
		System.out.println(L.size());
	}

}