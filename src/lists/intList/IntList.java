package lists.intList;

public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    /**
     * Return the size of the list using recursion
     */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size(); // 1 + however big the reset of the list is
    }

    /** 
     * Return the size of the list using no recursion
     */
    public int iterativeSize() {
        IntList p = this; // pointer variable
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /**
     * return the i-th item of this intList
     * @param index
     */
    public int get(int index) {
        if (index == 0) {
            return this.first;
        }
        return this.rest.get(index - 1);
    }

    @Override
    public String toString() {
		StringBuilder result = new StringBuilder("IntList: ");
		IntList cur = this;
		while (cur != null) {
			result.append(cur.first);
			result.append("\t");
			cur = cur.rest;
		}
		return result.toString();
	}

    public static void main(String[] args) {
        IntList list = new IntList(5, null);
        list.rest = new IntList(10, null);
        list.rest.rest = new IntList(15, null);

        // test size()
        System.out.println("size: " + list.size());
        // test iterativeSize()
        System.out.println("size: " + list.iterativeSize());
        // test get(int index)
        System.out.println("item: " + list.get(2));
    }
}
