package um.prog2.tad.lista;


import um.prog2.tad.exceptions.IllegalIndexException;

public class MyLinkedListImpl<T> implements MyList<T> {
    private Node first;

    public MyLinkedListImpl() {}

    @Override
    public boolean isEmpty() {
        return (this.first == null);
    }

    @Override
    public void add(Object obj) {
        Node newNode = new Node();

        if (first == null) {
            first = newNode;
        }

        newNode.setNext(first);
        first = newNode;
    }

    @Override
    public void addlast(Object obj) {

    }

    @Override
    public void addLast(Object obj) {
        Node newNode = new Node(obj);
        Node aux;

        if (first == null) {
            first = newNode;
        }

        aux = first;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        aux.setNext(newNode);
    }

    @Override
    public void add(Object obj, int index) throws IllegalIndexException {
        Node newNode = new Node(obj);
        Node addAux;

        if (first == null) {
            first = newNode;
        }
        if (index > this.large() || index < 0) {
            throw new IllegalIndexException("Error, índice no válido");
        }

        addAux = first;
        int i = 0;

        while (i < (index - 1)) {
            addAux = addAux.getNext();
            i++;
        }
        newNode.setNext(addAux.getNext());
        addAux.setNext(newNode);
    }

    @Override
    public int large() {
        Node auxLarge = first;
        int i = 0;

        while (auxLarge != null) {
            auxLarge = auxLarge.getNext();
            i++;
        }
        return i;
    }

    @Override
    public Object remove(int index) {
        Node auxRemove;
        if (index >= this.large() || index < 0) {
            return null;
        }

        if (index == 0) {
            Node removedNode = first;
            first = first.getNext();
            return removedNode.getData();
        }

        auxRemove = first;
        int i = 0;

        while (i < (index - 1)) {
            auxRemove = auxRemove.getNext();
            i++;
        }
        Node removedNode = auxRemove.getNext();
        auxRemove.setNext(auxRemove.getNext().getNext());
        return removedNode.getData();
    }

    @Override
    public Object elemento(int index) {
        Node auxiliarElemento;
        if (index >= this.large() || index < 0) {
            return null;
        }

        auxiliarElemento = first;
        int i = 0;

        while (i < index) {
            auxiliarElemento = auxiliarElemento.getNext();
            i++;
        }
        return auxiliarElemento.getData();
    }

    @Override
    public void clear() {
        while (first != null) {
            remove(0);
        }
    }

    public void printData() {
        int i = 0;
        Node print = first;

        while (print != null) {
            i++;
            System.out.println(i + ": " + print.getData());
            print = print.getNext();
        }
    }

    public Node getFirst() {
        return this.first;
    }
}
