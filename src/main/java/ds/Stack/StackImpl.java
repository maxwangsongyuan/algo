package ds.Stack;

public interface StackImpl<E> {

    boolean push(E val);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();
}
