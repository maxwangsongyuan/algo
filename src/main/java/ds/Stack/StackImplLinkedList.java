package ds.Stack;

import java.util.Iterator;

public class StackImplLinkedList<E> implements StackImpl<E>, Iterable<E> {

    private int capacity;
    private int size;
    private Node<E> head = new Node<>(null, null);

    public StackImplLinkedList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * head -> 1 -> null
     *
     * head  -> 2 -> 1 -> null
     */
    @Override
    public boolean push(E val) {
        if (isFull()) {
            return false;
        }
        Node<E> newNode = new Node<>(val, head.next);
        head.next = newNode;
        size++;

        return true;
    }

    /**
     * head  -> 2 -> 1 -> null
     *
     * head -> 1 -> null
     *
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = head.next;
        head.next = head.next.next;
        size--;
        return node.val;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = head.next;
        return node.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p.next != null;
            }

            @Override
            public E next() {
                E value = p.val;
                p = p.next;
                return value;
            }
        };
    }


    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        StackImplLinkedList<Integer> stack = new StackImplLinkedList<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
