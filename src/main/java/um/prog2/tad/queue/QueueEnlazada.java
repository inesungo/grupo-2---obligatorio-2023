package um.prog2.tad.queue;

import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.listagenericos.ListaEnlazadaGenerics;

import um.prog2.tad.exceptions.EmptyStackException;
import um.prog2.tad.stack.Pila;

public class QueueEnlazada<T> extends ListaEnlazadaGenerics<T> implements Queue<T> {


    @Override
    public void enqueue(T element) {

        agregar(element);

    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(esVacia()){
            throw new EmptyQueueException();
        }
        else {
            return quitar((this.largo()-1));
        }
    }

    @Override
    public boolean isEmpty() {
        return esVacia();
    }
}
