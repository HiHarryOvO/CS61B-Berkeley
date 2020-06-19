public class SLList {
	private class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int item, IntNode next) {
			this.item = item;
			this.next = next;
		}
	}

	private IntNode first;

	private int length;

	public SLList() {
		first = null;
		length = 0;
	}

	public SLList(int item, IntNode next) {
		first = new IntNode(item, next);
		length = 1;
	}

	public void addFirst(int x) {
		first = new IntNode(x, first);
		length += 1;
	}

	public int length() {
		return this.length;
	}

	/** Insert an item into the position, assuming position to be non-negative */
	public void insert(int item, int position) {
		IntNode p = first;
		int i = 0;

		if(first == null || position == 0) {
			addFirst(item);
			return;
		}

		while(p.next != null) {
			i += 1;
			if(position == i) {
				p.next = new IntNode(item, p.next);
				length += 1;
				return;
			}
		}

		p.next = new IntNode(item, null);
		length += 1;
	}

	public void reverseIterative() {
		if (first == null || first.next == null) {
			return;
		}

		IntNode ptr = first.next;
		first.next = null;

		while (ptr != null) {
			IntNode temp = ptr.next;
			ptr.next = first;
			first = ptr;
			ptr = temp;
		}
	}

	public void reverseRecursive() {
		first = reverseHelper(first);
	}

	public IntNode reverseHelper(IntNode lst) {
		if (lst == null || lst.next == null) {
			return lst;
		}

		IntNode endOfReversed = lst.next;
		IntNode reversed = reverseHelper(lst.next);
		endOfReversed.next = lst;
		lst.next = null;

		return reversed;
	}

	public int get(int i) {
		IntNode p = first;
		while (i != 0) {
			p = p.next;
			i -= 1;
		}
		return p.item;
	}

	public void print() {
		IntNode p = first;
		while(p != null) {
			System.out.print(p.item + " ");
			p = p.next;
		}
		System.out.println();
	}

	/**
	 * The following functions are about the Arrays part in discussion 3
	 * Note that in this question we assume arr to be filled
	 * @param arr: The original array
	 * @param item: The number to be inserted
	 * @param position: The position where item is inserted
	 * @return the eventual array
	 */
	public static int[] insert(int[] arr, int item, int position) {
		int[] newArray = new int[arr.length + 1];

		// The following step makes the situation easier
		position = Math.min(arr.length, position);

		System.arraycopy(arr, 0, newArray, 0, position);
		newArray[position] = item;
		System.arraycopy(arr, position, newArray, position + 1, arr.length - position);
		return newArray;
	}

	/** Destructively reverse the items in arr*/
	public static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}

	/**
	 * A non-destructive method that replaces the number at index i
	 * with arr[i] copies of itself.
	 */
	public static int[] replicate(int[] arr) {
		int sumLength = 0;
		for (int value : arr) {
			sumLength += value;
		}
		int[] newArray = new int[sumLength];
		int index = 0;

		for (int value : arr) {
			int j = value;
			while (j > 0) {
				newArray[index] = value;
				j--;
				index++;
			}
		}
		return newArray;
	}

	public static void main(String[] args) {
		SLList a = new SLList();
		a.addFirst(3);
		a.addFirst(2);
		a.addFirst(1);

		a.insert(4, 1);
		a.print();
		System.out.println("The length of list a: " + a.length());
		System.out.println("The 2nd item in list a: " + a.get(1));

		a.reverseIterative();
		System.out.println("List a after reverse function: ");
		a.print();
	}
}