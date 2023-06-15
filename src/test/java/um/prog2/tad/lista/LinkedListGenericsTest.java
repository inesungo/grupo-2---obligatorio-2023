package um.prog2.tad.lista;

import um.prog2.tad.exceptions.IllegalIndexException;
import um.prog2.tad.listagenericos.GenericList;
import um.prog2.tad.listagenericos.GenericNode;

public class LinkedListGenericsTest<T> implements GenericList<T>
{
    private GenericNode<T> first;

    public GenericNode getFirst()
    {
        return this.first;
    }

    @Override
    public boolean isEmpty()
    {
        return (this.first == null);
    }

    @Override
    public void add(T obj)
    {
        GenericNode<T> newNodo = new GenericNode<T>(obj);

        if (first != null) {
            newNodo.setNext(first);
        }
        first = newNodo;
    }

    @Override
    public void addLast(T obj)
    {
        GenericNode<T> newNodo = new GenericNode<T>(obj);
        GenericNode<T> aux;

        if (first == null){

            first = newNodo;
        }
        else {
            aux = first;
            while (aux.getNext() != null) {

                aux = aux.getNext();
            }
            aux.setNext(newNodo);
        }
    }

    @Override
    public void add(T obj, int index) throws IllegalIndexException
    {
        GenericNode<T> newNodo = new GenericNode<T>(obj);
        GenericNode<T> addAux;

        if (first == null){

            first = newNodo;
        }
        if ((index > this.large()) || (index < 0)){

            throw new IllegalIndexException("Error, no es valido el index");
        }
        else {
            addAux = first;
            int i = 0;

            while (i < (index-1)) {

                addAux = addAux.getNext();
                i++;
            }
            newNodo.setNext(addAux.getNext());
            addAux.setNext(newNodo);
        }
    }

    @Override
    public int large()
    {
        if (first == null){
            return 0;
        }
        else {
            GenericNode<T> auxLargo = first;
            int i = 1;

            while (auxLargo.getNext() != null) {
                auxLargo = auxLargo.getNext();
                i++;
            }
            return i;
        }
    }

    @Override
    public T remove(int index)
    {

        if ((index > this.large()) || (index < 0)){
            return null;
        } else {

            GenericNode<T> removeAux;
            removeAux = first;
            if (index == 0){
                if (this.large() == 1){
                    GenericNode<T> ret = first;
                    first = null;
                    return ret.getData();
                }
                GenericNode<T> ret = first;
                first = first.getNext();
                return ret.getData();
            }
            int i = 0;

            while (i < (index - 1)) {

                removeAux = removeAux.getNext();
                i++;
            }

            GenericNode<T> ret = removeAux.getNext();
            if (removeAux.getNext().getNext() != null) {
                removeAux.setNext(removeAux.getNext().getNext());
            } else {
                removeAux.setNext(null);
            }
            return ret.getData();
        }
    }

    @Override
    public T element(int index)
    {
        GenericNode<T> auxElement;
        if ((index > this.large()) || (index < 0) || (first == null)){
            return null;
        }
        else {

            auxElement = first;
            int i = 0;

            while (i < index) {

                auxElement = auxElement.getNext();
                i++;
            }
            return auxElement.getData();
        }
    }

    @Override
    public void clear()
    {
        int i = 0;
        int largo = this.large();
        while (i<largo){
            remove(0);
            i++;
        }
    }

    @Override
    public void dataPrint()
    {
        int i = 0;
        GenericNode<T> print = first;

        while (print != null){

            System.out.println(i++ + ":" + print.getData());
            print = print.getNext();
        }

    }

    public GenericNode<T> finalPointer() {
        GenericNode<T> aux;
        aux = first;
        while (aux.getNext() != null) {

            aux = aux.getNext();
        }
        return aux;
    }


}

