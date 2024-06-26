package ds_implementation;

import java.util.Iterator;
import java.util.function.Consumer;

public class SingleLinkedList implements Iterable<Integer> {
    private Node head = null;

    //没有用到外部类的vairable，所以可以用static
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        // empty list
//        head = new Node(value, null);

        //non-empty list
        head = new Node(value, head);
    }

    public void traverse(Consumer<Integer> consumer) {
        Node current = head;
        while (current != null) {
//            System.out.println(current.value);
            consumer.accept(current.value);
            current = current.next;
        }
    }

    public void traverse2(Consumer<Integer> consumer) {
        for (Node current = head; current != null; current = current.next) {
            consumer.accept(current.value);
        }
    }

    public void traverse3(Consumer<Integer> before,
                          Consumer<Integer> after) {
        recursion(head, before, after);
    }

    public void recursion(Node curr,
                          Consumer<Integer> before,
                          Consumer<Integer> after) {
        if (curr == null) {
            return;
        }

        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }

    @Override
    public Iterator<Integer> iterator() {
        // anonymous inner class
        return new NodeIterator();
    }


    //用到外部类的vairable (head)，所以不可以用static
    private class NodeIterator implements Iterator<Integer> {
        Node curr = head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Integer next() {
            int value = curr.value;
            curr = curr.next;
            return value;
        }
    }

    /**
     * Find the last node in the list
     */
    private Node findLastNode() {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /**
     * Add a new node to the end of the list
     */
    public void addLast(int value) {
        Node last = findLastNode();

        if (last == null) {
            addFirst(value);
            return;
        }

        last.next = new Node(value, null);
    }

    /**
     * Find the node at the specified index
     */
    public Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * Get the value at the specified index
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw getIllegalArgumentException(index);
        }
        return node.value;
    }


    /**
     * Insert a new node at the specified index
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node prev = findNode(index - 1);
        if (prev == null) {
            throw getIllegalArgumentException(index);
        }

        prev.next = new Node(value, prev.next);
    }

    public void removeFirst() {
        if (head == null) {
            throw getIllegalArgumentException(0);
        }
        head = head.next;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

        Node prev = findNode(index - 1);
        if (prev == null) {
            throw getIllegalArgumentException(index);
        }

        Node removed = prev.next;
        if (removed == null) {
            throw getIllegalArgumentException(index);
        }
        prev.next = removed.next;
    }

    private static IllegalArgumentException getIllegalArgumentException(int index) {
        return new IllegalArgumentException(String.format("Index %d not found", index));
    }
}


