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
public class AList<T> {
    private T[] items;
    private int size;
    private static final int RFACTOR = 2;
    
    /** Creates an empty list. */
    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
//          resize(size + RFACTOR);
            resize(size * RFACTOR); 
        }
        items[size] = x;
        size++;
    }
    
    /** Resize the underlying array to the target capacity */
    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        System.arraycopy(items, 0, arr, 0, size);
        items = arr;
    }
        
    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public T removeLast() {
        T temp = items[size - 1];
        items[size - 1] = null; // null out any items that we "delete" to avoid "loitering"
        size--;
        return temp;
    }
} 