package um.prog2.tad.stack;

import um.prog2.tad.listagenericos.ListaEnlazadaGenerics;

import um.prog2.tad.exceptions.EmptyStackException;

public class PilaEnlazada<T> extends ListaEnlazadaGenerics<T> implements Pila<T> {


    @Override
    public void push(T dato) {
        agregar(dato);
    }

    @Override
    public T pop() throws EmptyStackException {
        if(esVacia()){
            throw new EmptyStackException();
        }
        else {
            return quitar(0);
        }
    }

    @Override
    public T top() {
        return (T) getPrimero().getDato();
    }

    @Override
    public boolean isEmpty() {
        return esVacia();
    }

    @Override
    public void clear() {
        vaciar();

    }
}
