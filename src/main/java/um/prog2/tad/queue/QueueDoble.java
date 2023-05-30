package um.prog2.tad.queue;
import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.exceptions.IllegalIndexException;
public interface QueueDoble <T> {
    void enqueueLeft (T element);
    T dequeueLeft () throws EmptyQueueException;
    void enqueueRight (T element);
    T dequeueRight () throws EmptyQueueException;
    boolean isEmpty();
}