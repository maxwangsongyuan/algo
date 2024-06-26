package ds_implementation;

import java.util.Iterator;

public class doublyLinkedListWithSentinel implements Iterable<Integer> {

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;

    public doublyLinkedListWithSentinel() {
        head = new Node(666, null, null);
        tail = new Node(666, null, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        for ( Node current = head; current != tail; current = current.next, i++) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value, prev.next, prev);
        prev.next.prev = newNode;
        prev.next = newNode;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IndexOutOfBoundsException();
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw new IndexOutOfBoundsException();
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;

    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(value, tail, last);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast() {
        Node last = tail.prev;
        if (last == head) {
            throw new IndexOutOfBoundsException();
        }
        Node newLast = last.prev;
        newLast.next = tail;
        tail.prev = newLast;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
