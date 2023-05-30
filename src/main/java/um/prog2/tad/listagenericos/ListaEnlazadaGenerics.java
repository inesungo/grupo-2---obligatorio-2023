package um.prog2.tad.listagenericos;

import um.prog2.tad.exceptions.IllegalIndexException;

public class ListaEnlazadaGenerics<T> implements ListaGenerics<T>
{
    private NodoGeneric<T> primero;

    public NodoGeneric getPrimero()
    {
        return this.primero;
    }
    //a

    @Override
    public boolean esVacia()
    {
        return (this.primero == null);
    }

    @Override
    public void agregar(T obj)
    {
        NodoGeneric<T> nuevoNodo = new NodoGeneric<T>(obj);

        if (primero == null){

            primero = nuevoNodo;
        }
        else {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        }
    }

    @Override
    public void agregarAlFinal(T obj)
    {
        NodoGeneric<T> nuevoNodo = new NodoGeneric<T>(obj);
        NodoGeneric<T> auxiliar;

        if (primero == null){

            primero = nuevoNodo;
        }
        else {
            auxiliar = primero;
            while (auxiliar.getSiguiente() != null) {

                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public void agregar(T obj, int index) throws IllegalIndexException
    {
        NodoGeneric<T> nuevoNodo = new NodoGeneric<T>(obj);
        NodoGeneric<T> auxiliarAgregar;

        if (primero == null){

            primero = nuevoNodo;
        }
        if ((index > this.largo()) || (index < 0)){

            throw new IllegalIndexException("Error, index no válido");
        }
        else {
            auxiliarAgregar = primero;
            int i = 0;

            while (i < (index-1)) {

                auxiliarAgregar = auxiliarAgregar.getSiguiente();
                i++;
            }
            nuevoNodo.setSiguiente(auxiliarAgregar.getSiguiente());
            auxiliarAgregar.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public int largo()
    {
        if (primero == null){
            return 0;
        }
        else {
            NodoGeneric<T> auxLargo = primero;
            int i = 1;

            while (auxLargo.getSiguiente() != null) {
                auxLargo = auxLargo.getSiguiente();
                i++;
            }
            return i;
        }
    }

    @Override
    public T quitar(int index)
    {

        if ((index > this.largo()) || (index < 0)){
            return null;
        } else {

            NodoGeneric<T> auxiliarQuitar;
            auxiliarQuitar = primero;
            if (index == 0){
                if (this.largo() == 1){
                    NodoGeneric<T> retorno = primero;
                    primero = null;
                    return retorno.getDato();
                }
                NodoGeneric<T> retorno = primero;
                primero = primero.getSiguiente();
                return retorno.getDato();
            }
            int i = 0;

            while (i < (index - 1)) {

                auxiliarQuitar = auxiliarQuitar.getSiguiente();
                i++;
            }

            NodoGeneric<T> retorno = auxiliarQuitar.getSiguiente();
            if (auxiliarQuitar.getSiguiente().getSiguiente() != null) {
                auxiliarQuitar.setSiguiente(auxiliarQuitar.getSiguiente().getSiguiente());
            } else {
                auxiliarQuitar.setSiguiente(null);
            }
            return retorno.getDato();
        }
    }

    @Override
    public T elemento(int index)
    {
        NodoGeneric<T> auxiliarElemento;
        if ((index > this.largo()) || (index < 0) || (primero == null)){
            return null;
        }
        else {

            auxiliarElemento = primero;
            int i = 0;

            while (i < index) {

                auxiliarElemento = auxiliarElemento.getSiguiente();
                i++;
            }
            return auxiliarElemento.getDato();
        }
    }

    @Override
    public void vaciar()
    {
        int i = 0;
        int largo = this.largo();
        while (i<largo){
            quitar(0);
            i++;
        }
    }

    @Override
    public void imprimirDatos()
    {
        int i = 0;
        NodoGeneric<T> printeado = primero;

        while (printeado != null){

            System.out.println(i++ + ":" + printeado.getDato());
            printeado = printeado.getSiguiente();
        }

    }

    public NodoGeneric<T> punteroFinal() {
        NodoGeneric<T> auxiliar;
        auxiliar = primero;
        while (auxiliar.getSiguiente() != null) {

            auxiliar = auxiliar.getSiguiente();
        }
        return auxiliar;
    }
    public void quitarFinal()
        {
            quitar((this.largo()-1));
            }


}

