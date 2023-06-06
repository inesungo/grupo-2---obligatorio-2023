package um.prog2.tad.listagenericos;

import um.prog2.tad.exceptions.IllegalIndexException;

public interface GenericList<T>
{
    public boolean isEmpty();

    public void add(T obj);

    public void addLast(T obj);

    public void add(T obj, int index) throws IllegalIndexException;

    public int large();

    public T remove(int index);

    public T element(int index);

    public void clear();

    public void dataPrint();
}

