package um.prog2.tad.queue;
import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.listagenericos.ListaEnlazadaGenerics;
import um.prog2.tad.listagenericos.NodoGeneric;
import um.prog2.tad.queue.Queue;
import um.prog2.tad.queue.QueueEnlazada;

public class QueueEnlazadaDoble<T> extends ListaEnlazadaGenerics<T> implements QueueDoble<T> {


    @Override
    public void enqueueLeft(T element) {

        agregar(element);

    }

    @Override
    public T dequeueRight() throws EmptyQueueException {
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
    public void enqueueRight(T element) {

        agregarAlFinal(element);

    }

    @Override
    public T dequeueLeft() throws EmptyQueueException {
        if(esVacia()){
            throw new EmptyQueueException();
        }
        else {
            return quitar(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return isEmpty();
    }
}
