package um.prog2.tad.stack;

import um.prog2.tad.exceptions.EmptyStackException;

public class PilaArrays<T> implements Pila<T> {

    private T datos[];
    private int indiceTop; //e va a guardar el indice de la posicion deonde esta el ultimo dato (el ultimo elemento)
    public static final int CAPACIDAD_INICIAL = 100;

    public PilaArrays(){ //Constructor

        datos= (T[]) new Object[CAPACIDAD_INICIAL];
    }

    public PilaArrays(int capacidad){ //Construtcor

        datos= (T[]) new Object[capacidad];
        indiceTop = -1; //para que arranque con la pila vacia, si lo arranco en 0 pueod tener algo, si lo dejo en la posicion 0 ya tendría un elemento en el 0
    }

    @Override
    public void push(T dato) { //Poner dato

        if(indiceTop==datos.length-1){
            System.out.println("Excepcion pila llena");
        }
        else{
            indiceTop++; //arranco en la posicion 0
            datos[indiceTop]=dato;
        }

    }

    @Override
    public T pop() throws EmptyStackException {
        if (indiceTop<0){
            throw new EmptyStackException();
        }

        T elDato = datos[indiceTop];
        datos[indiceTop]=null;
        indiceTop--;
        return elDato;
    }

    @Override
    public T top() {
        if (indiceTop<0){
            System.out.println("Excepcion pila vacia");
            return null;
        }

        return datos[indiceTop];
    }

    @Override
    public boolean isEmpty() {
        return indiceTop<0;
    }

    @Override
    public void clear() {

        for (int i = 0; i<= indiceTop; i++){
            datos[i] = null;
        }


    }
}
