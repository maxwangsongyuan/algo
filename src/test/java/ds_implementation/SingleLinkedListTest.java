package ds_implementation;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void traverse() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.traverse(integer -> System.out.println(integer));
    }

    @Test
    void traverse2() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.traverse2(integer -> System.out.println(integer));
    }

    @Test
    void iterator() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    void addLast() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.addLast(4);
        assertIterableEquals(List.of(3,2,1,4), list);
    }

    @Test
    void addFirst() {
    }

    @Test
    void findNode() {
    }

    @Test
    void get() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.addLast(4);

        int i = list.get(2);
        System.out.println(i);
    }

    @Test
    void insert() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void remove() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.remove(0);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    void traverse3() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.traverse3( integer -> System.out.println("before: " + integer),
                integer -> System.out.println( "after: " +  integer) );
    }

    @Test
    void recursion() {
    }
}