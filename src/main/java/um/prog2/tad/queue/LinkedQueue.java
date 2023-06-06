package um.prog2.tad.queue;

import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.listagenericos.LinkedListGenerics;

public class LinkedQueue<T> extends LinkedListGenerics<T> implements MyQueue<T> {


    @Override
    public void enqueue(T element) {

        add(element);

    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(this.isEmpty()){
            throw new EmptyQueueException();
        }
        else {
            return remove((this.large()-1));
        }
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty();
    }
    @Override
    public int size() {
        return this.size();
    }
}