package um.prog2.tad.lista;

import um.prog2.tad.exceptions.IllegalIndexException;

public class LinkedMyList implements MyList
{
    private Node first;


    public LinkedMyList() {}

    @Override
    public boolean isEmpty()
    {
        return (this.first == null);
    }

    @Override
    public void add(Object obj)
    {
        Node newNode = new Node();

        if (first == null){

            first = newNode;
        }

        newNode.setNext(first);
        first = newNode;
    }

    @Override
    public void addlast(Object obj)
    {
        Node newNode = new Node(obj);
        Node auxiliar;

        if (first == null){

            first = newNode;
        }

        auxiliar = first;
        while (auxiliar.getNext() != null){

            auxiliar = auxiliar.getNext();
        }
        auxiliar.setNext(newNode);
    }

    @Override
    public void add(Object obj, int index) throws IllegalIndexException
    {

        Node newnode = new Node(obj);
        Node auxAdd;

        if (first == null){

            first = newnode;
        }
        if ((index > this.large()) || (index < 0)){

            throw new IllegalIndexException("Error, no es valido el Index");
        }

        auxAdd = first;
        int i=0;

        while (i< (index -1)){

            auxAdd.setNext(auxAdd.getNext());
            i++;
        }
        newnode.setNext(auxAdd.getNext());
        auxAdd.setNext(newnode);

    }


    @Override
    public int large()
    {
        Node auxLarge = first;
        int i = 0;

        while (auxLarge.getNext() != null) {
            auxLarge = auxLarge.getNext();
            i++;
        }
        return i;
    }

    @Override
    public Object remove(int index)
    {
        Node auxRemove;
        if ((index > this.large()) || (index < 0)){
            return null;
        }

        auxRemove = first;
        int i=0;

        while (i< (index -1)){

            auxRemove.setNext(auxRemove.getNext());
            i++;
        }
        Node ret = new Node();
        ret = auxRemove.getNext();
        auxRemove.setNext(auxRemove.getNext().getNext());
        return ret;

    }

    @Override
    public Object elemento(int index)
    {
        Node auxiliarElement;
        if ((index > this.large()) || (index < 0)){
            return null;
        }

        auxiliarElement = first;
        int i=0;

        while (i< (index)){

            auxiliarElement.setNext(auxiliarElement.getNext());
            i++;
        }
        return auxiliarElement;
    }

    @Override
    public void clear()
    {
        int i = 0;

        while (i < this.large()){
            remove(i);
            i++;
        }
    }

    @Override
    public void printData() {
        int i = 0;
        int data = 0;
        Node print = first;

        while (print != null) {

            i++;
            System.out.println(i + ":" + print.getData());
            print = print.getNext();
        }

    }

    public Node getFirst()
    {
        return this.first;
    }
}
