package um.prog2.tad.queue;
import um.prog2.tad.exceptions.EmptyQueueException;


public interface MyQueue<T> {

    void enqueue (T element);
    T dequeue() throws EmptyQueueException;
    boolean isEmpty();
    int size();
}
