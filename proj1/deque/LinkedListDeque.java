package deque;

public class LinkedListDeque<T> implements Deque<T> {

    private Node sentinel;
    private int size;

    private static class Node<T> {
        public T item;
        public Node pre;
        public Node nxt;


        public Node(T itm) {
            item = itm;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null);
        Node<T> tail = new Node<>(null);
        sentinel.pre = tail;
        sentinel.nxt = tail;
        tail.pre = sentinel;
        tail.nxt = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        n.nxt = sentinel.nxt;
        sentinel.nxt.pre = n;
        n.pre = sentinel;
        sentinel.nxt = n;
        size += 1;

    }

    @Override
    public void addLast(T item) {
        Node<T> n = new Node<>(item);
        Node<T> tail = sentinel.pre;
        n.pre = tail.pre;
        n.pre.nxt = n;
        n.nxt = tail;
        tail.pre = n;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> n = sentinel;
        for (int i = 0; i < size; i++) {
            n = n.nxt;
            System.out.print(n.item);
        }
        System.out.print("\n");
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        Node<T> first = sentinel.nxt;
        sentinel.nxt = sentinel.nxt.nxt;
        sentinel.nxt.pre = sentinel;
        size -= 1;
        return first.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        Node<T> tail = sentinel.pre;
        Node<T> last = tail.pre;
        tail.pre = tail.pre.pre;
        tail.pre.nxt = tail;
        size -= 1;
        return last.item;
    }

    @Override
    public T get(int index) {
        Node<T> n = sentinel.nxt;
        Node<T> tail = sentinel.pre;
        int i = 0;
        while (n != tail) {
            if (i == index) return n.item;
            n = n.nxt;
            i++;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque)) return false;
        LinkedListDeque<T> obj = (LinkedListDeque<T>) o;
        Node<T> p1 = sentinel.nxt;
        Node<T> p2 = obj.sentinel.nxt;
        while (p1 != sentinel.pre && p2 != obj.sentinel.pre && p1.item == p2.item) {
            p1 = p1.nxt;
            p2 = p2.nxt;
        }
        return p1.item == p2.item;
    }
}
