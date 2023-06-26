package um.prog2.tad.hash;

import um.prog2.tad.lista.MyLinkedListImpl;
import um.prog2.tad.lista.MyList;

import java.util.HashMap;

public class MyHashImpl<Key, Value> implements MyHash<Key, Value> {
    private HashMap<Key, Value> map;

    /**
     * Crea un hash cerrado con la cantidad de buckets de 16
     */
    public MyHashImpl() {
        this.map = new HashMap<>();
    }

    /**
     * Crea un hash cerrado con la cantidad de buckets inicial de "initialCapacity"
     */
    public MyHashImpl(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }

    @Override
    public MyList<Key> keys() {
        MyList<Key> toReturn = new MyLinkedListImpl<>();
        map.keySet().stream().forEach(toReturn::add);
        return toReturn;
    }

    @Override
    public MyList<Value> values() {
        MyList<Value> toReturn = new MyLinkedListImpl<>();
        map.values().stream().forEach(toReturn::add);
        return toReturn;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void put(Key key, Value value) {
        map.put(key, value);
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public boolean contains(Key key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }

    @Override
    public Value getOrDefault(Key key, Value defaultValue) {
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }
}
