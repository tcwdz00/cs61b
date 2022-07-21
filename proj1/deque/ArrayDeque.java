package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int start;
    private int end;

    public int tableSize() {
        return items.length;
    }

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        start = 0; //start is the position of first ele
        end = size - 1; // end is the position of last end

    }

    /** resize the table storing elements to a specific capacity */
    private void resize(int capacity) {
        T[] newTable = (T[]) new Object[capacity];
        int i = start;
        for (int j = 0; j < size; j++) {
            newTable[j] = items[i];
            i = remainder(i+1, items.length);
        }
        items = newTable;
        start = 0;
        end = size-1;

    }

    /** insert item to position 0 of the array */
    public void addFirst(T item) {

        if (size == items.length) {
            resize(items.length * 2);
        }
        int j = remainder(start - 1, items.length);
        items[j] = item;
        start = j;
        size += 1;
    }

    /** insert item to the end of the array */
    public void addLast(T item) {

        if (size == items.length) {
            resize(items.length*2);
        }

        int j = remainder(end + 1, items.length); // position to insert the ele
        items[j] = item;
        end = j;
        size += 1;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void printDeque() {

        for (int i = 0; i < size; i++) {
            System.out.print(items[remainder(start + i, items.length)] + " ");
        }
        System.out.print("\n");

    }

    public T removeFirst() {
        if (size == 0) return null;
        if (items.length > 4 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        T res = items[start];
        start = remainder(start + 1, items.length);
        size -= 1;
        return res;
    }

    public T removeLast() {
        if (size == 0) return null;
        if (items.length > 4 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        T res = items[end];
        end = remainder(end - 1, items.length);
        size -= 1;
        return res;
    }

    public T get(int i) {
        if (size == 0) return null;
        return items[remainder(start + i, items.length)];
    }

    public boolean equals(Object o) {
        if (!(o instanceof ArrayDeque)) return false;
        ArrayDeque<T> obj = (ArrayDeque<T>) o;
        if (size != obj.size) return false;
        int i = start;
        int j = obj.start;
        for (int k = 0; k < size; k++) {
            if (items[i] != obj.items[j]) return false;
            i = remainder(i+1, items.length);
            j = remainder(j+1, obj.items.length);
        }
        return true;
    }

    private static int remainder(int n, int d) {
        int q = Math.floorDiv(n, d);
        int r = n - d * q;
        return r;
    }




}
