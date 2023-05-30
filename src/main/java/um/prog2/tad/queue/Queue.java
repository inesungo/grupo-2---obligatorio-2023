package um.prog2.tad.queue;
import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.exceptions.IllegalIndexException;


public interface Queue<T> {

    void enqueue (T element);
    T dequeue() throws EmptyQueueException;
    boolean isEmpty();

}
