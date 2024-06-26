package ds_implementation;

import java.util.Iterator;

public class DoublyCircularLinkedListWithSentinel implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel = new Node(666, null, null);

    public DoublyCircularLinkedListWithSentinel(Node sentinel) {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value) {
        Node first = sentinel;
        Node next = sentinel.next;
        Node newNode = new Node(value, next, first);
        first.next = newNode;
        next.prev = newNode;
    }

    public void addLast(int value) {
        Node last = sentinel.prev;
        Node first = sentinel;
        Node newNode = new Node(value, sentinel, last);
        last.next = newNode;
        sentinel.prev = newNode;
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IndexOutOfBoundsException();
        }
        Node next = removed.next;
        sentinel.next = next;
        next.prev = sentinel;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = removed.prev;
        sentinel.prev = prev;
        prev.next = sentinel;
    }

    public void removeByValue( int value ) {
        Node remove = findByValue(value);
        if (remove == null) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = remove.prev;
        Node next = remove.next;
        prev.next = next;
        next.prev = prev;
    }

    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
