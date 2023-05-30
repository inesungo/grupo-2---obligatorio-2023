package um.prog2.tad.stack;
import um.prog2.tad.exceptions.EmptyStackException;

import um.prog2.tad.exceptions.IllegalIndexException;



public interface Pila<T> {

    public void push(T dato);
    public T pop() throws EmptyStackException;
    public T top();
    public boolean isEmpty();
    public void clear();





}
