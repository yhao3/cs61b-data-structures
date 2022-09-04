package lists.sllist;

/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SLList {

	public IntNode first;

	public SLList(int x) {
		first = new IntNode(x, null);
	}

	/** Adds an item to the front of the list. */
	public void addFirst(int x) {
		first = new IntNode(x, first);
	}

	/** Retrieves the front item from the list. */
	public int getFirst() {
		return first.item;
	}

	/** Adds an item to the end of the list. */
	public void addLast(int x) {
		IntNode p = this.first; // temp pointer variable

		/* Move p until it reaches the end of the list */
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
	}

	/** Returns the size of the list. */
	public int size() {
		int result = 1;
		IntNode p = this.first; // temp pointer variable
		while (p.next != null) {
			result += 1;
			p = p.next;
		}
		return result;
	}

	@Override
	public String toString() {
		IntNode p = this.first; // temp pointer variable
		StringBuilder result = new StringBuilder("SLList: " + p + "\t");
		while (p.next != null) {
			result.append(p.next + "\t");
			p = p.next;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		/* Creates a list */
		SLList list = new SLList(15); // 15
		list.addFirst(10);            // 10 - 15
		list.addFirst(5);             //  5 - 10 - 15
		list.addLast(20);			 //  5 - 10 - 15 - 20

		System.out.println(list);
		System.out.println(list.size());
	}

}
