package ds.Deque;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * Deque is a double-ended queue.
 * It can be used as a queue (FIFO) or as a stack (LIFO).
 */
public class DequeLinkedlist<E> implements DequeImpl<E>, Iterable<E> {


    @Override
    public boolean offerFirst(E val) {
        if (isFull()) {
            return false;
        }
        Node<E> node = new Node<>(val, sentinel.next, sentinel);
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
        return true;
    }

    /**
     * Add an element to the end of the deque.
     * @param val
     * @return
     */
    @Override
    public boolean offerLast(E val) {
        return false;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
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
        return null;
    }

    static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;
        public Node(E val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    int capacity;
    int size;
    Node<E> sentinel = new Node<>(null, null, null);

    public DequeLinkedlist(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
}
