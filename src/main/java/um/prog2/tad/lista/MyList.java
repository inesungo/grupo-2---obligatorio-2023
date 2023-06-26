package um.prog2.tad.lista;

import um.prog2.tad.exceptions.IllegalIndexException;

public interface MyList<K> {
    public boolean isEmpty();

    abstract void add(Object obj);

    public void addlast(Object obj);

    void addLast(Object obj);

    public void add(Object obj, int index) throws IllegalIndexException;

    public int large();



    public Object remove(int index);

    public Object elemento(int index);

    public void clear();

    void printData();

    int size();

    K get(int i);
}
