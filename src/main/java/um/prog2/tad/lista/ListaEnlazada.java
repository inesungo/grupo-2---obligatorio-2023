package um.prog2.tad.lista;

import um.prog2.tad.exceptions.IllegalIndexException;
import um.prog2.tad.listagenericos.NodoGeneric;

public class ListaEnlazada implements Lista
{
    private Nodo primero;


    public ListaEnlazada() {}

    @Override
    public boolean esVacia()
    {
        return (this.primero == null);
    }

    @Override
    public void agregar(Object obj)
    {
        Nodo nuevoNodo = new Nodo();

        if (primero == null){

            primero = nuevoNodo;
        }

        nuevoNodo.setSiguiente(primero);
        primero = nuevoNodo;
    }

    @Override
    public void agregarAlFinal(Object obj)
    {
        Nodo nuevoNodo = new Nodo(obj);
        Nodo auxiliar;

        if (primero == null){

            primero = nuevoNodo;
        }

        auxiliar = primero;
        while (auxiliar.getSiguiente() != null){

            auxiliar = auxiliar.getSiguiente();
        }
        auxiliar.setSiguiente(nuevoNodo);
    }

    @Override
    public void agregar(Object obj, int index) throws IllegalIndexException
    {

        Nodo nuevoNodo = new Nodo(obj);
        Nodo auxiliarAgregar;

        if (primero == null){

            primero = nuevoNodo;
        }
        if ((index > this.largo()) || (index < 0)){

            throw new IllegalIndexException("Error, index no válido");
        }

        auxiliarAgregar = primero;
        int i=0;

        while (i< (index -1)){

            auxiliarAgregar.setSiguiente(auxiliarAgregar.getSiguiente());
            i++;
        }
        nuevoNodo.setSiguiente(auxiliarAgregar.getSiguiente());
        auxiliarAgregar.setSiguiente(nuevoNodo);

    }


    @Override
    public int largo()
    {
        Nodo auxLargo = primero;
        int i = 0;

        while (auxLargo.getSiguiente() != null) {
            auxLargo = auxLargo.getSiguiente();
            i++;
        }
        return i;
    }

    @Override
    public Object quitar(int index)
    {
        Nodo auxiliarQuitar;
        if ((index > this.largo()) || (index < 0)){
            return null;
        }

        auxiliarQuitar = primero;
        int i=0;

        while (i< (index -1)){

            auxiliarQuitar.setSiguiente(auxiliarQuitar.getSiguiente());
            i++;
        }
        Nodo retorno = new Nodo();
        retorno = auxiliarQuitar.getSiguiente();
        auxiliarQuitar.setSiguiente(auxiliarQuitar.getSiguiente().getSiguiente());
        return retorno;

    }

    @Override
    public Object elemento(int index)
    {
        Nodo auxiliarElemento;
        if ((index > this.largo()) || (index < 0)){
            return null;
        }

        auxiliarElemento = primero;
        int i=0;

        while (i< (index)){

            auxiliarElemento.setSiguiente(auxiliarElemento.getSiguiente());
            i++;
        }
        return auxiliarElemento;
    }

    @Override
    public void vaciar()
    {
        int i = 0;

        while (i < this.largo()){
            quitar(i);
            i++;
        }
    }

    @Override
    public void imprimirDatos() {
        int i = 0;
        int dato = 0;
        Nodo printeado = primero;

        while (printeado != null) {

            i++;
            System.out.println(i + ":" + printeado.getDato());
            printeado = printeado.getSiguiente();
        }

    }

    public Nodo getPrimero()
    {
        return this.primero;
    }
}
