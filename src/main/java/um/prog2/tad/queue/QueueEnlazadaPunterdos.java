package um.prog2.tad.queue;

import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.listagenericos.ListaEnlazadaGenerics;
import um.prog2.tad.listagenericos.NodoGeneric;
import um.prog2.tad.queue.Queue;

public class QueueEnlazadaPunterdos<T> extends ListaEnlazadaGenerics<T> implements Queue<T> {
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
            T dequeued = punteroFinal().getDato();
            quitarFinal();
            return dequeued;
        }
    }

    @Override
    public boolean isEmpty() {
        return (punteroFinal() == null);
    }
}
