package series.series_9.exercices.exo_2;

import java.util.EmptyStackException;

public class Stack<E> {
    public final static int max = 200;
    private final E[] array;
    private int top;

    public Stack() {
        this.array = (E[]) new Object[max];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(E elem) {
        array[++top] = elem;
    }

    public E pop() {
        if(!this.isEmpty()) {
            return array[top--];
        }
        else {
            throw new EmptyStackException();
        }
    }

    public E peek() {
        if(!this.isEmpty()) {
            return array[top];
        }
        else {
            throw new EmptyStackException();
        }
    }
}
