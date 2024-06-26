package ds_implementation;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListWithSentinel implements Iterable<Integer> {

    //Head points to the sentinel node
    private Node head = new Node(666, null);


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
//        head.next = new Node(value, head.next);

        insert(0, value);
    }

    public void traverse(Consumer<Integer> consumer) {
       Node current = head.next; //skip the sentinel
        while (current != null) {
//            System.out.println(current.value);
            consumer.accept(current.value);
            current = current.next;
        }
    }

    public void traverse2(Consumer<Integer> consumer) {
        //skip the sentinel
        for (Node current = head.next; current != null; current = current.next) {
            consumer.accept(current.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        // anonymous inner class
        return new NodeIterator();
    }


    //用到外部类的vairable (head)，所以不可以用static
    private class NodeIterator implements Iterator<Integer> {
       Node curr = head.next; //skip the sentinel

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
        Node last = findLastNode(); //always present, a sentinel
        last.next = new Node(value, null);
    }

    /**
     * Find the node at the specified index
     */
    public Node findNode(int index) {
        int i = -1;
        //skip the sentinel
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
       Node prev = findNode(index - 1);
        if (prev == null) {
            throw getIllegalArgumentException(index);
        }

        prev.next = new Node(value, prev.next);
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {

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
