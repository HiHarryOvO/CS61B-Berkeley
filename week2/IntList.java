public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		this.first = f;
		this.rest = r;
	}

	/** Returns the size of the IntList */
	public int size() {
		if (this.rest == null) {
			return 1;
		}
		else {
			return 1 + this.rest.size();
		}
	}

	public int iterativeSize() {
		int s = 0;
		IntList p = this;
		while (p != null) {
			s += 1;
			p = p.rest;
		}
		return s;
	}

	public int get(int i) {
		if (i == 0) {
			return this.first;
		}
		return this.rest.get(i - 1);
	}

	public void printList() {
		IntList p = this;
		while (p != null) {
			System.out.printf("%d ", p.first);
			p = p.rest;
		}
		System.out.printf("\n");
	}

	/** Creates a new increment list without changing L */
	public static IntList incrIterativeList(IntList L, int x) {
		IntList p = L;
		IntList newList = new IntList(p.first + x, null);
		IntList p1 = newList;

		p = p.rest;

		while (p != null) {
			IntList tempList = new IntList(p.first + x, null);
			p1.rest = tempList;
			p1 = tempList;
			p = p.rest;
		}
		
		return newList;
	}

	public static IntList incrRecursionList(IntList L, int x) {
		if (L.rest == null) {
			IntList list = new IntList(L.first + x, null);
			return list;
		}

		IntList list = new IntList(L.first + x, incrRecursionList(L.rest, x));
		return list;
	}

	/** Creates a new increment list without using keyword new */
	public static IntList dincrIterativeList(IntList L, int x) {
		IntList p = L;

		while (p != null) {
			p.first += x;
			p = p.rest;
		}

		return L;
	}

	public static IntList dincrRecursionList(IntList L, int x) {
		if (L == null) {
			return L;
		}
		L.first = L.first + x;
		dincrRecursionList(L.rest, x);
		return L;
	}
	
	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.printf("size of L: %d\n", L.size());
		System.out.printf("size of L: %d\n", L.iterativeSize());
		System.out.printf("2nd item in the list: %d\n", L.get(1));

		System.out.println("Test incrIterativeList with increment of 40:");
		incrIterativeList(L, 40).printList();

		System.out.println("Test incrRecursionList with increment of 40:");
		incrRecursionList(L, 40).printList();

		System.out.println("Test dincrIterativeList with increment of 40:");
		dincrIterativeList(L, 40).printList();

		System.out.println("We'll see L has been changed due to dincrIterativeList function:");
		L.printList();

		System.out.println("Test dincrRecursionList with increment of 40:");
		dincrRecursionList(L, 40).printList();

		System.out.println("We'll see L has been changed due to dincrRecursionList function:");
		L.printList();
	}
}