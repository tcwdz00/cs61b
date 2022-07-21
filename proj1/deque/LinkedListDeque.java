package deque;

public class LinkedListDeque<Type> {

    private Node sentinel;
    private int size;

    private static class Node<Type> {
        public Type item;
        public Node pre;
        public Node nxt;
        public int index;

        public Node(Type itm) {
            item = itm;
            index = -1;

        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.nxt = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public void addFirst(Type item) {
        Node<Type> n = new Node<>(item);
        n.index = 1;
        n.nxt = sentinel.nxt;
        sentinel.nxt.pre = n;
        n.pre = sentinel;
        sentinel.nxt = n;
        n.pre = sentinel;
        size += 1;

    }

    public void addLast(Type item) {
        Node<Type> n = new Node<>(item);
        n.index = size;
        Node<Type> tail = sentinel.pre;
        tail.nxt = n;
        n.pre = tail;
        n.nxt = sentinel;
        sentinel.pre = n;
        size += 1;
    }

    public boolean isEmpty() {
        return sentinel.nxt == sentinel;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<Type> n = sentinel;
        while (n != sentinel) {
            System.out.print(n.item + " ");
            n = n.nxt;
        }
        System.out.print("\n");
    }



    public Type removeFirst() {
        if (size == 0) return null;
        Node<Type> first = sentinel.nxt;
        sentinel.nxt = sentinel.nxt.nxt;
        sentinel.nxt.pre = sentinel;
        size -= 1;
        return first.item;
    }


    public Type removeLast() {
        if (size == 0) return null;
        Node<Type> last = sentinel.pre;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.nxt = sentinel;
        size -= 1;
        return last.item;
    }


    public Type get(int index) {
        Node<Type> n = sentinel.nxt;
        while (n!=sentinel) {
            if (n.index == index) return n.item;
        }
        return null;
    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque)) return false;
        LinkedListDeque<Type> obj = (LinkedListDeque<Type>) o;
        Node<Type> p1 = sentinel.nxt;
        Node<Type> p2 = obj.sentinel.nxt;
        while (p1 != sentinel && p2 != obj.sentinel && p1.item == p2.item) {
            p1 = p1.nxt;
            p2 = p2.nxt;
        }
        return p1.item == p1.item;
    }



}
