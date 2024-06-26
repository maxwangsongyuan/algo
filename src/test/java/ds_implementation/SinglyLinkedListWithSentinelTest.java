package ds_implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListWithSentinelTest {

    @Test
    void addFirst() {
    }

    @Test
    void traverse() {
    }

    @Test
    void traverse2() {
    }

    @Test
    void iterator() {
    }

    @Test
    void addLast() {
    }

    @Test
    void findNode() {
    }

    @Test
    void get() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
//        assertEquals(3, list.get(2));
    }

    @Test
    void insert() {
    }

    @Test
    void removeFirst() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.removeFirst();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    void remove() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);


        list.remove(1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}