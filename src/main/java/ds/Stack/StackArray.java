package ds.Stack;

import java.util.Iterator;

public class StackArray<E> implements StackImpl<E>, Iterable<E> {



    private E[] arr;
    private int top; // index of the top element

    /**
     *  底      顶
     *  0 1 2 3 4
     *  a
     *    t
     * @param capacity
     */
    public StackArray(int capacity) {
        arr = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E val) {
        if (isFull()) {
            return false;
        }

        arr[top++] = val; // 先赋值，再自增
        return true;


    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E val = arr[top -1]; // 先自减，再取值
        top --;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E val = arr[top -1]; // 先自减，再取值
        return val;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == arr.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = top;
            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public E next() {
                E value = arr[index - 1];
                index--;
                return value;
            }
        };
    }



    public static void main(String[] args) {
        StackImpl<Integer> stack = new StackArray<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.isFull());
        System.out.println(stack.isEmpty());
    }
}
