package lists.alist;

/** 
 * Array based list.
 * <pre>
 * Invariants (things that must be true): 
 * 1. The position of the next item to be inserted (using addLast) is always size.
 * 2. The number of items in the AList is always size.
 * 3. The position of the last item in the list is always (size - 1).
 * </pre>
 */
public class AList {
    private int[] items;
    private int size;
    
    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size++;
    }
    
    /** Resize the underlying array to the target capacity */
    private void resize(int capacity) {
        int[] arr = new int[capacity];
        System.arraycopy(items, 0, arr, 0, size);
        items = arr;
    }
        
    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int temp = items[size - 1];
        items[size - 1] = 0; // Setting deleted item to zero is not necessary to preserve invariants, and thus not necessary for correctness.
        size--;
        return temp;
    }
} 