package um.prog2.tad.stack;

import um.prog2.tad.listagenericos.LinkedListGenerics;

import um.prog2.tad.exceptions.EmptyStackException;

public class LinkedStack<T> extends LinkedListGenerics<T> implements MyStack<T> {


    @Override
    public void push(T data) {
        add(data);
    }

    @Override
    public T pop() throws EmptyStackException {
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        else {
            return remove(0);
        }
    }

    @Override
    public T top() {
        return (T) getFirst().getData();
    }

    @Override
    public boolean isEmpty() {

        return this.isEmpty();
    }

    @Override
    public void clear() {
        this.clear();

    }
}
