package um.prog2.tad.stack;
import um.prog2.tad.exceptions.EmptyStackException;


public interface MyStack<T> {

    public void push(T data);
    public T pop() throws EmptyStackException;
    public T top();
    public boolean isEmpty();
    public void clear();





}
